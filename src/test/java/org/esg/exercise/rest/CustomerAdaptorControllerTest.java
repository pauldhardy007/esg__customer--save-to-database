package org.esg.exercise.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CustomerAdaptorControllerTest {
    private CustomerAdaptorController customerAdaptorController;

    @BeforeEach
    void setUp() {
        customerAdaptorController = new CustomerAdaptorController();
    }

    @Test
    void postCustomerContactDetail() {
        customerAdaptorController.postCustomerContactDetail("{body}");
    }

    @Test
    void getCustomerContactDetail() {
        customerAdaptorController.getCustomerContactDetail("123456");
    }
}