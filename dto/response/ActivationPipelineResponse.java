package org.example.etldatahandler.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.etldatahandler.dto.PipelineCodeEnum;
import org.example.etldatahandler.dto.UnloadType;

import java.util.List;
import java.util.Map;

@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ActivationPipelineResponse {
    PipelineCodeEnum pipelineCode;
    List<String> parameters;
    UnloadType unloadType;
    String consumer;
    String topicName;
    Map<String, String> unloadSign;
    List<String> relatedMappings;
}
