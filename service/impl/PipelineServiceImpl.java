package org.example.etldatahandler.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.camel.spring.SpringCamelContext;
import org.example.etldatahandler.dto.PipelineCodeEnum;
import org.example.etldatahandler.dto.request.ActivationPipelineRequest;
import org.example.etldatahandler.dto.response.ActivationPipelineResponse;
import org.example.etldatahandler.service.PipelineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class PipelineServiceImpl implements PipelineService {

    private final SpringCamelContext camelContext;

    private final ScheduledExecutorService executor;

    private final Map<String, List<Future<?>>> stopRouteFuturesMap = new ConcurrentHashMap<>();

//    @SneakyThrows
//    @Override
//    public ActivationPipelineResponse startPipe(ActivationPipelineRequest request) {
//        camelContext.startRoute("KafkaToPostgres");
//        return ActivationPipelineResponse.builder()
//                .pipelineCode(PipelineCodeEnum.MERCHANTS_EXPORT_INCREMENTAL)
//                .consumer("kafka")
//                .topicName("ucs-static-incr")
//                .build();
//    }

    @SneakyThrows
    @Override
    public void startPipe(String routeId, Optional<Long> s) {
        camelContext.startRoute(routeId);

        if (!stopRouteFuturesMap.containsKey(routeId)) {
            stopRouteFuturesMap.put(routeId, new ArrayList<>());
        }

        stopRouteFuturesMap.get(routeId).add(executor.schedule(() -> {
            try {
                stopRoute(routeId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, s.orElse(10L), TimeUnit.SECONDS));
    }

    @SneakyThrows
    @Override
    public void stopPipe(String routeId) {
        if (!stopRouteFuturesMap.containsKey(routeId)) {
            stopRouteFuturesMap.put(routeId, new ArrayList<>());
        }

        stopRoute(routeId);
    }

    private void stopRoute(String routeId) throws Exception {
        camelContext.stopRoute(routeId);
        List<Future<?>> futureList = stopRouteFuturesMap.get(routeId);
        futureList.forEach(el -> el.cancel(true));
        futureList.clear();
    }
}
