package com.example.demoWeb.repositories;

import com.example.demoWeb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByUsername(String username);

    boolean existsByUsernameOrEmail(String username, String email);
}
