package com.assessment.bistro.repository;
import static org.junit.jupiter.api.Assertions.*;

import com.assessment.bistro.model.Item;
import com.assessment.bistro.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ItemRepositoryTest {
    Item expectedItem;
    @Autowired
    private ItemRepository repo;

    @BeforeEach
    public void setup() {
        expectedItem = new Item();
        expectedItem.setItemCategoryId(2);
        expectedItem.setItemName("Fire Nachos");
        expectedItem.setItemDescription("Not you regular nachos. These are fire");
        expectedItem.setStartDate(LocalDate.of(2024,2,14));
        expectedItem.setEndDate(LocalDate.of(2024,2,20));
        expectedItem.setUnitPrice(new BigDecimal("9.99"));
        expectedItem = repo.save(expectedItem);
    }

    @Test
    void testGetItemById() {
        //act
        Optional<Item> foundItem = repo.findById(expectedItem.getItemId());

        //assert
        assertTrue(foundItem.isPresent());
    }
    @Test
    void testGetAllItems() {
        //act
        List<Item> items = repo.findAll();

        //assert
        assertFalse(items.isEmpty());
        assertTrue(items.contains(expectedItem));
    }

    @Test
    void testGetItemsByCategory() {
        //act
        List<Item> items = repo.findByItemCategoryId(2);

        //assert
        assertFalse(items.isEmpty());
        assertTrue(items.contains(expectedItem));
    }

    @Test
    void testUpdateItem() {
        //arrange
        expectedItem.setItemName("Dragon Nachos");
        repo.save(expectedItem);

        //act
        Optional<Item> updatedItem = repo.findById(expectedItem.getItemId());

        //assert
        assertTrue(updatedItem.isPresent());
        assertEquals("Dragon Nachos", updatedItem.get().getItemName());
    }

    @Test
    void testAddItem() {
        // Arrange
        Item newItem = new Item();
        newItem.setItemCategoryId(3);
        newItem.setItemName("Cheesy Fries");
        newItem.setItemDescription("It's loaded");
        newItem.setStartDate(LocalDate.of(2024, 3, 1));
        newItem.setUnitPrice(new BigDecimal("8.99"));
        newItem = repo.save(newItem);

        // Act
        Optional<Item> foundItem = repo.findById(newItem.getItemId());

        // Assert
        assertTrue(foundItem.isPresent());
        assertEquals(newItem.getItemCategoryId(), foundItem.get().getItemCategoryId());
        assertEquals(newItem.getItemName(), foundItem.get().getItemName());
    }
}