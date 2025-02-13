package com.assessment.bistro.repository;

import com.assessment.bistro.model.Order;
import com.assessment.bistro.model.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    private OrderRepository repo;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void testGetOrderById() {


    }

    @Test
    public void testGetAllOrders() {

    }

    @Test
    public void testAddOrder() {

    }

    @Test
    public void testDeleteOrder() {

    }

    @Test
    public void testUpdateOrder() {

    }


    private void compareOrders(Order expected, Order actual) {
        assertEquals(expected.getOrderId(), actual.getOrderId());
        assertEquals(expected.getSubTotal(), actual.getSubTotal());
        assertEquals(expected.getTax(), actual.getTax());
        assertEquals(expected.getTip(), actual.getTip());
        assertEquals(expected.getTotal(), actual.getTotal());

        assertEquals(expected.getItems().size(), actual.getItems().size());
        for (int i = 0; i < expected.getItems().size(); i++) {
            OrderItem e = expected.getItems().get(i);
            OrderItem a = actual.getItems().get(i);

            assertEquals(e.getOrderItemId(), a.getOrderItemId());
            assertEquals(e.getOrderId(), a.getOrderId());
            assertEquals(e.getItemId(), a.getItemId());
            assertEquals(e.getQuantity(), a.getQuantity());
            assertEquals(e.getPrice(), a.getPrice());
        }
    }
}