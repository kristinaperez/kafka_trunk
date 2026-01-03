package org.example.etldatahandler.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class KafkaRecord {

    String hoid;
    String role;
    String asam_profile;
    String mid;
    String model;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String lastModified;
    String activeflag;
    String tid;
}
