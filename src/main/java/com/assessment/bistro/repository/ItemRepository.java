package com.assessment.bistro.repository;

import com.assessment.bistro.model.Item;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {
    @NativeQuery("SELECT * FROM Item WHERE Item_Category_ID = ?1;")
    List<Item> findByItemCategoryId(Integer itemCategoryId);
}