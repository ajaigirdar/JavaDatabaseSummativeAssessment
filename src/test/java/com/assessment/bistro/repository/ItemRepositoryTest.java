package com.assessment.bistro.repository;


import com.assessment.bistro.model.Item;
import com.assessment.bistro.model.ItemCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    public void setup() {

    }

    @Test
    void testGetItemById() {

    }
    @Test
    void testGetAllItems() {

    }

    @Test
    void testGetItemsByCategory() {

    }

    @Test
    void testUpdateItem() {

    }

    @Test
    void testAddItem() {

    }
}