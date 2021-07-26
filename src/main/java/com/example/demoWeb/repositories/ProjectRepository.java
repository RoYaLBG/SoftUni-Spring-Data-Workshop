package com.example.demoWeb.repositories;

import com.example.demoWeb.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsAllBy();
}
