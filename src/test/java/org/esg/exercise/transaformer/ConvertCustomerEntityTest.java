package org.esg.exercise.transaformer;

import org.esg.exercise.entity.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertCustomerEntityTest {
    private ConvertCustomerEntity convertCustomerEntity;

    @BeforeEach
    void setUp() {
        convertCustomerEntity = new ConvertCustomerEntity();
    }

    @Test
    void transform() {
        CustomerEntity customerEntity = new CustomerEntity();

    }
}