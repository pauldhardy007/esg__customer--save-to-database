package org.esg.exercise.transaformer;

import org.esg.exercise.dto.CustomerDto;
import org.esg.exercise.entity.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.esg.exercise.util.TestHelper.getTestCustomerDto;
import static org.esg.exercise.util.TestHelper.getTestCustomerEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertCustomerEntityToDtoTest {
    private ConvertCustomerEntityToDto convertCustomerEntityToDto;

    @BeforeEach
    void setUp() {
        convertCustomerEntityToDto = new ConvertCustomerEntityToDto();
    }

    @Test
    void transform() {
        CustomerEntity customerEntity = getTestCustomerEntity();
        CustomerDto expected = getTestCustomerDto();

        CustomerDto actual = convertCustomerEntityToDto.transform(customerEntity);

        assertEquals(expected, actual);
    }
}