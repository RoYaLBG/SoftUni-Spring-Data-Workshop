package com.example.demoWeb.repositories;

import com.example.demoWeb.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsAllBy();
}
