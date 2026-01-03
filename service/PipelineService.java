package org.example.etldatahandler.service;

import org.example.etldatahandler.dto.request.ActivationPipelineRequest;
import org.example.etldatahandler.dto.response.ActivationPipelineResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PipelineService {
//    ActivationPipelineResponse startPipe(ActivationPipelineRequest request);

    void startPipe(String routeId, Optional<Long> s);

    void stopPipe(String routeId);
}
