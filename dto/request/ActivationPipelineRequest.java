package org.example.etldatahandler.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.etldatahandler.dto.PipelineCodeEnum;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ActivationPipelineRequest {
    PipelineCodeEnum pipelineCode;
    List<String> parameters;
}
