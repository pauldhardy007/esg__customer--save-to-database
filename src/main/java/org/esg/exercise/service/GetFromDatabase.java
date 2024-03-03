package org.esg.exercise.service;

import lombok.AllArgsConstructor;
import org.esg.exercise.dto.CustomerDto;
import org.esg.exercise.entity.CustomerEntity;
import org.esg.exercise.repository.CustomerRepository;
import org.esg.exercise.transaformer.ConvertCustomerEntityToDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetFromDatabase {

    private CustomerRepository customerRepository;
    private ConvertCustomerEntityToDto convertCustomerEntityToDto;

    public CustomerDto getCustomerData(final long customerRef) throws Exception {

        List<CustomerEntity> customerEntities = customerRepository.findByCustomerRef(customerRef);
        if (customerEntities.isEmpty()) {
            throw new Exception("The record with reference " + customerRef + " does not exist");
        }
        return convertCustomerEntityToDto.transform(customerEntities.get(0));
    }
}
