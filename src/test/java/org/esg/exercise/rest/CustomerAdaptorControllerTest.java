package org.esg.exercise.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.esg.exercise.dto.CustomerDto;
import org.esg.exercise.service.GetFromDatabase;
import org.esg.exercise.service.SaveToDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerAdaptorControllerTest {
    public static final long CUSTOMER_REFERENCE = 123456L;
    private CustomerAdaptorController customerAdaptorController;
    @Mock
    private GetFromDatabase getFromDatabase;
    @Mock
    private SaveToDatabase saveToDatabase;

    @BeforeEach
    void setUp() {
        customerAdaptorController = new CustomerAdaptorController(getFromDatabase, saveToDatabase);
    }

    @Test
    void getCustomerContactDetail() throws Exception {
        final CustomerDto customerDto = CustomerDto.builder()
                .customerRef(String.valueOf(CUSTOMER_REFERENCE))
                .customerName("Paul Hardy")
                .build();
        when(getFromDatabase.getCustomerData(CUSTOMER_REFERENCE)).thenReturn(customerDto);

        final ResponseEntity<CustomerDto> response =
                customerAdaptorController.getCustomerContactDetail(CUSTOMER_REFERENCE);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(getFromDatabase).getCustomerData(CUSTOMER_REFERENCE);
    }

    @Test
    void postCustomerContactDetail() throws JsonProcessingException {
        doNothing().when(saveToDatabase).save(any());

        customerAdaptorController.postCustomerContactDetail("{body}");

        verify(saveToDatabase).save("{body}");
    }
}