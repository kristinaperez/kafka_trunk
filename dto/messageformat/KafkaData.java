package org.example.etldatahandler.dto.messageformat;

import java.lang.reflect.Field;

public abstract class KafkaData {
    public boolean isAnyNull() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields()) {
            if (f.get(this) == null) return false;
        }
        return true;
    }
}
