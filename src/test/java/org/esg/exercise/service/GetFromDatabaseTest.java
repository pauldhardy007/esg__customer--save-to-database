package org.esg.exercise.service;

import org.esg.exercise.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetFromDatabaseTest {

    @InjectMocks
    private GetFromDatabase getFromDatabase;
    @Mock
    private CustomerRepository customerRepository;


    @Test
    void getCustomerData() {

        getFromDatabase.getCustomerData("123456");
    }
}