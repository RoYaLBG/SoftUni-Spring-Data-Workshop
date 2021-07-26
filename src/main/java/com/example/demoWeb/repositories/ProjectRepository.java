package com.example.demoWeb.repositories;

import com.example.demoWeb.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findFirstByNameAndCompanyName(String name, String companyName);

    List<Project> findAllByFinishedIsTrue();

    boolean existsAllBy();
}
