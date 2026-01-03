package org.example.etldatahandler.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class KafkaRecordDto {

    String hoid;
    String role;
    String asam_profile;
    String mid;
    String model;
    long id;
    String lastModified;
    String activeflag;
    String tid;
    private List<KafkaRecordDto> kafkaRecords;
}
