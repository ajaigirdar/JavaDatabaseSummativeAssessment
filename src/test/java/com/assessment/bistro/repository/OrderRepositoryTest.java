package com.assessment.bistro.repository;

import com.assessment.bistro.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
class OrderRepositoryTest {
    Order expectedOrder;
    @Autowired
    private OrderRepository repo;

    @BeforeEach
    void setUp() {
        expectedOrder = new Order();
        expectedOrder.setServerId(5);
        expectedOrder.setOrderDate(LocalDate.of(2025,2,14));
        expectedOrder.setSubTotal(new BigDecimal("0.00"));
        expectedOrder.setTax(new BigDecimal("0.00"));
        expectedOrder.setTip(new BigDecimal("0.00"));
        expectedOrder.setTotal(new BigDecimal("0.00"));
        expectedOrder = repo.save(expectedOrder);
    }

    @Test
    public void testGetOrderById() {
        //act
        Optional<Order> foundOrder = repo.findById(expectedOrder.getOrderId());

        //assert
        assertTrue(foundOrder.isPresent());
    }

    @Test
    public void testGetAllOrders() {
        //act
        List<Order> orders = repo.findAll();

        //assert
        assertFalse(orders.isEmpty());
        assertTrue(orders.contains(expectedOrder));
    }

    @Test
    public void testAddOrder() {
        //arrange
        expectedOrder = new Order();
        expectedOrder.setServerId(9);
        expectedOrder.setOrderDate(LocalDate.of(2024,1,1));
        expectedOrder.setSubTotal(new BigDecimal("0.00"));
        expectedOrder.setTax(new BigDecimal("0.00"));
        expectedOrder.setTip(new BigDecimal("0.00"));
        expectedOrder.setTotal(new BigDecimal("0.00"));
        expectedOrder = repo.save(expectedOrder);

        //act
        Optional<Order> foundOrder = repo.findById(expectedOrder.getOrderId());

        //assert
        assertTrue(foundOrder.isPresent());
        assertEquals(expectedOrder.getServerId(),foundOrder.get().getServerId());
    }

    @Test
    public void testDeleteOrder() {
        //act
        repo.delete(expectedOrder);
        Optional<Order> foundOrder = repo.findById(expectedOrder.getOrderId());

        //assert
        assertFalse(foundOrder.isPresent());
    }

    @Test
    public void testUpdateOrder() {
        //arrange
        expectedOrder.setSubTotal(new BigDecimal("100"));
        expectedOrder.setTax(new BigDecimal("6.25"));
        expectedOrder.setTip(new BigDecimal("15.00"));
        expectedOrder.setTotal(new BigDecimal("121.25"));
        repo.save(expectedOrder);

        //act
        Optional<Order> updatedOrder = repo.findById(expectedOrder.getOrderId());

        //assert
        assertTrue(updatedOrder.isPresent());
        assertEquals(new BigDecimal("15.00"),updatedOrder.get().getTip());
        assertEquals(new BigDecimal("6.25"),updatedOrder.get().getTax());
        assertEquals(new BigDecimal("100.00"),updatedOrder.get().getSubTotal());
        assertEquals(new BigDecimal("121.25"),updatedOrder.get().getTotal());
    }

    /*
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
     */
    }