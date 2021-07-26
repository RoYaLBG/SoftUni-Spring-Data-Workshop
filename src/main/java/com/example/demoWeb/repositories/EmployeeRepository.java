package com.example.demoWeb.repositories;

import com.example.demoWeb.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findFirstByFirstNameAndLastNameAndAge(String firstName, String lastName, int age);

    List<Employee> findAllByAgeAfter(int age);

    boolean existsAllBy();
}
