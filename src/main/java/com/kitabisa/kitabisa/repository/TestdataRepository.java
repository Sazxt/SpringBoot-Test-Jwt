package com.kitabisa.kitabisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kitabisa.kitabisa.model.Testdata;

@Repository
public interface TestdataRepository extends JpaRepository<Testdata, Long> {
    
}
