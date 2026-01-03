package org.example.etldatahandler.camel.processor;

import org.example.etldatahandler.dto.messageformat.KafkaData;
import org.springframework.stereotype.Component;

@Component
public class NullFieldsCheckingBean {
    public boolean validate(KafkaData data) throws IllegalAccessException {
        return data.isAnyNull();
    }

}
