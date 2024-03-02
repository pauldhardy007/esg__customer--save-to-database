package org.esg.exercise.service;

import lombok.AllArgsConstructor;
import org.esg.exercise.dto.CustomerDto;
import org.esg.exercise.entity.CustomerEntity;
import org.esg.exercise.repository.CustomerRepository;
import org.esg.exercise.transaformer.ConvertCustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetFromDatabase {

    private final CustomerRepository customerRepository;
    private ConvertCustomerEntity convertCustomerEntity;

    public CustomerDto getCustomerData(final String customerRef) {

        List<CustomerEntity> customerEntities =  customerRepository.findByCustomerRef(customerRef);
        //todo - Check for duplicates
        return convertCustomerEntity.transform(customerEntities.get(0));
    }
}
