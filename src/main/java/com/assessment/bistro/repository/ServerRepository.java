package com.assessment.bistro.repository;

import com.assessment.bistro.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface ServerRepository extends JpaRepository<Server,Integer> {

    @NativeQuery("select * from `Server` where Term_Date is null;")
    List<Server>findByTermDateIsNull();

}
