package com.example.demoWeb.repositories;

import com.example.demoWeb.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsAllBy();
}
