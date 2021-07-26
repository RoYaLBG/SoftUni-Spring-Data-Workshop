package com.example.demoWeb.controllers;

import com.example.demoWeb.dto.UserLoginDto;
import com.example.demoWeb.dto.UserRegisterDto;
import com.example.demoWeb.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/users/register")
    public String register(UserRegisterDto user, Model model) {
        if (this.userService.register(user)) {
            return "redirect:/users/login";
        }

        model.addAttribute("error", "There is an error");

        return "user/register";
    }

    @GetMapping("/users/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginDto user, Model model, HttpServletRequest request) {
        var userId = this.userService.validateUserLoginDetails(user);
        if (userId == null) {
            model.addAttribute("error", "There is an error");
            return "user/login";
        }

        request.getSession().setAttribute(
                "userId",
                userId
        );

        return "redirect:/";
    }
}
