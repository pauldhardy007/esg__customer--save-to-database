package org.esg.exercise.transaformer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.esg.exercise.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConvertCustomerPayloadToEntity {

    private ObjectMapper objectMapper;

    public CustomerEntity transform(final String payload) throws JsonProcessingException {
        return objectMapper.readValue(payload, CustomerEntity.class);
    }
}
