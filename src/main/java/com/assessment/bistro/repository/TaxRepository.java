package com.assessment.bistro.repository;

import com.assessment.bistro.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Integer> {
}
