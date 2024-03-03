package org.esg.exercise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.esg.exercise.entity.CustomerEntity;
import org.esg.exercise.repository.CustomerRepository;
import org.esg.exercise.transaformer.ConvertCustomerPayloadToEntity;
import org.esg.exercise.util.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;

import static org.esg.exercise.util.TestHelper.getTestCustomerEntity;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveToDatabaseTest {
    private SaveToDatabase saveToDatabase;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ConvertCustomerPayloadToEntity convertCustomerPayloadToEntity;

    @BeforeEach
    void setUp() {
        saveToDatabase = new SaveToDatabase(customerRepository, convertCustomerPayloadToEntity);
    }

    @Test
    void shouldSaveContentOfJsonToDatabase() throws FileNotFoundException, JsonProcessingException {
        final CustomerEntity customerEntity = getTestCustomerEntity();
        final String payload = TestHelper.getJsonFromFile("/json/customer.json");
        when(convertCustomerPayloadToEntity.transform(payload)).thenReturn(customerEntity);
        when(customerRepository
                .save(customerEntity)).thenReturn(any(CustomerEntity.class));

        saveToDatabase.save(payload);

        verify(convertCustomerPayloadToEntity).transform(payload);
        verify(customerRepository).save(customerEntity);
    }
}