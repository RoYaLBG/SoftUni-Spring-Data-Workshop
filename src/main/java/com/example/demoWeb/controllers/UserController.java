package com.example.demoWeb.controllers;

import com.example.demoWeb.dto.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @GetMapping("/users/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/users/register")
    public String register(UserRegisterDto user) {
        return "user/register";
    }
}
