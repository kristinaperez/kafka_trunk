package org.example.etldatahandler.camel.processor;

import org.example.etldatahandler.dto.messageformat.KafkaRawHoData;
import org.springframework.stereotype.Component;

// EXAMPLE
@Component
public class KafkaProcessingBean {
    public KafkaRawHoData process(KafkaRawHoData kafkaRawHoData) {
        kafkaRawHoData.setInn("some new inn");
        return kafkaRawHoData;
    }
}
