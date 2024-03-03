package org.esg.exercise.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.esg.exercise.dto.CustomerDto;
import org.esg.exercise.entity.CustomerEntity;
import org.esg.exercise.repository.CustomerRepository;
import org.esg.exercise.transaformer.ConvertCustomerEntityToDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class GetFromDatabase {

    private CustomerRepository customerRepository;
    private ConvertCustomerEntityToDto convertCustomerEntityToDto;

    public CustomerDto getCustomerData(final long customerRef) throws Exception {
        log.info("Getting Customer Data. customerRef[{}]", customerRef);
        List<CustomerEntity> customerEntities = customerRepository.findByCustomerRef(customerRef);
        if (customerEntities.isEmpty()) {
            throw new Exception("The record with reference " + customerRef + " does not exist");
        }
        return convertCustomerEntityToDto.transform(customerEntities.get(0));
    }
}
