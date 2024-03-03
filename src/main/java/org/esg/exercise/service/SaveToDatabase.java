package org.esg.exercise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.esg.exercise.entity.CustomerEntity;
import org.esg.exercise.repository.CustomerRepository;
import org.esg.exercise.transaformer.ConvertCustomerPayloadToEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveToDatabase {

    private CustomerRepository customerRepository;
    private ConvertCustomerPayloadToEntity convertCustomerPayloadToEntity;

    public void save(final String payload) throws JsonProcessingException {
        final CustomerEntity customerEntity = convertCustomerPayloadToEntity.transform(payload);
        customerRepository.save(customerEntity);
    }
}
