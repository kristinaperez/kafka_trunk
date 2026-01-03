package org.example.etldatahandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"org.example.etldatahandler.repository"})
@EnableJpaRepositories("org.example.etldatahandler.repository")
@EntityScan("org.example.etldatahandler.model")
public class EtlDataHandlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EtlDataHandlerApplication.class, args);
    }
}
