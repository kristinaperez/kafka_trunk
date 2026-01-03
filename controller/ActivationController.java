package org.example.etldatahandler.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.etldatahandler.dto.request.ActivationPipelineRequest;
import org.example.etldatahandler.dto.response.ActivationPipelineResponse;
import org.example.etldatahandler.service.PipelineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ActivationController {

    private final PipelineService pipelineService;

//    @PostMapping
//    public ResponseEntity<ActivationPipelineResponse> startPipe(@RequestBody ActivationPipelineRequest request) {
//        return new ResponseEntity<>(pipelineService.startPipe(request), HttpStatus.OK);
//    }

    @PostMapping("start")
    public void startPipe(@RequestParam(name = "route-id") String routeId, @RequestParam(required = false) Optional<Long> s) throws Exception {
        pipelineService.startPipe(routeId, s);
    }

    @PostMapping("stop")
    public void stopPipe(@RequestParam(name = "route-id") String routeId) throws Exception {
        pipelineService.stopPipe(routeId);
    }
}
