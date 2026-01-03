package org.example.etldatahandler.dto.messageformat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaRawTidData extends KafkaData{
    String hoid;
    String role;
    String asam_profile;
    String mid;
    String model;
    String id;
    String lastModified;
    String activeflag;
    String tid;
}
