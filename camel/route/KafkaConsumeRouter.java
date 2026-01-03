package org.example.etldatahandler.camel.route;

import org.apache.camel.InvalidPayloadException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.component.kafka.consumer.KafkaManualCommit;
import org.example.etldatahandler.camel.processor.KafkaProcessingBean;
import org.example.etldatahandler.camel.processor.NullFieldsCheckingBean;
import org.example.etldatahandler.dto.messageformat.KafkaRawHoData;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumeRouter extends RouteBuilder {
    private final String UCS_INCR = "ucs-static-incr";

    @Override
    public void configure() throws Exception {
        String kafkaConsumerEndpoint = new StringBuilder("kafka:")
                .append(UCS_INCR)
                .append("?autoOffsetReset=")
                .append("earliest")
                .append("&autoCommitEnable=")
                .append(false)
                .append("&allowManualCommit=")
                .append(true)
                .toString();

        try (JacksonDataFormat kafkaRawHoDataFormat = new JacksonDataFormat(KafkaRawHoData.class)) {
            from(kafkaConsumerEndpoint)
                    .routeId("KafkaToPostgres")
                    .noAutoStartup()
                    .doTry()
                        .unmarshal(kafkaRawHoDataFormat)
                    .doCatch(InvalidPayloadException.class)
                        .log("MARSHALING EXCEPTION OCCURRED")
                        .stop()
                    .end()
                    .log("--------------------------------------------------------------------------------------")
                    .to("log:kafka-info")
                    .log("Headers: ${headers}")
                        .choice()
                            .when(method(NullFieldsCheckingBean.class, "validate"))
                                .log("TRUE >>> ${body}")
                            .otherwise()
                                .log("FALSE >>> ${body}")
                                .stop()
                        .endChoice()
                        .end()
                    .bean(method(KafkaProcessingBean.class, "process"))
                    .marshal(kafkaRawHoDataFormat)
                    .convertBodyTo(String.class)
                    .doTry()
                        .log("TO STORAGE")
                        .to("log:kafka-info")
                    .doCatch(Exception.class)
                        .log("EXCEPTION OCCURRED")
                        .stop()
                    .end()
                    .log("SENDING ACK...")
                    .process(exchange -> {
                        KafkaManualCommit manual = exchange.getIn().getHeader(KafkaConstants.MANUAL_COMMIT, KafkaManualCommit.class);
                        manual.commit();
                    })
                    .to("log:kafka-info")
                    .log("${headers}");
        }
    }
}


