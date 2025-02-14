package com.assessment.bistro.repository;

import com.assessment.bistro.model.PaymentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;
@ActiveProfiles("test")
@SpringBootTest
class PaymentTypeRepositoryTest {
    PaymentType expectedPaymentType;
    @Autowired
    private PaymentTypeRepository repo;

    @Test
    void testGetAllPaymentTypes() {
        //arrange
        expectedPaymentType = new PaymentType();
        expectedPaymentType.setPaymentTypeName("Ethereum");
        repo.save(expectedPaymentType);

        //act
        List<PaymentType> paymentTypes = repo.findAll();

        //assert
        assertFalse(paymentTypes.isEmpty());
        assertTrue(paymentTypes.contains(expectedPaymentType));
        assertTrue(paymentTypes.size() >= 5);

    }
}