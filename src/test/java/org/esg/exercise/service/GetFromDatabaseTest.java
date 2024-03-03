package org.esg.exercise.service;

import org.esg.exercise.dto.CustomerDto;
import org.esg.exercise.entity.CustomerEntity;
import org.esg.exercise.repository.CustomerRepository;
import org.esg.exercise.transaformer.ConvertCustomerEntityToDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetFromDatabaseTest {

    public static final long CUSTOMER_REF = 123456L;
    @InjectMocks
    private GetFromDatabase getFromDatabase;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ConvertCustomerEntityToDto convertCustomerEntityToDto;

    @Test
    void shouldReturnCustomerDataWhenExists() throws Exception {
        final CustomerDto expected = CustomerDto.builder()
                .customerRef(String.valueOf(CUSTOMER_REF))
                .build();
        final CustomerEntity customerEntity = CustomerEntity.builder()
                .customerRef(CUSTOMER_REF)
                .build();
        when(customerRepository.findByCustomerRef(CUSTOMER_REF)).thenReturn(Collections.singletonList(customerEntity));
        when(convertCustomerEntityToDto.transform(customerEntity)).thenReturn(expected);

        final CustomerDto actual = getFromDatabase.getCustomerData(CUSTOMER_REF);

        assertEquals(expected, actual);
        verify(customerRepository).findByCustomerRef(CUSTOMER_REF);
        verify(convertCustomerEntityToDto).transform(customerEntity);
    }
}