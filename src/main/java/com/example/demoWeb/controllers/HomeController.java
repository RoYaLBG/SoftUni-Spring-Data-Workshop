package com.example.demoWeb.controllers;

import com.example.demoWeb.services.CompanyService;
import com.example.demoWeb.services.EmployeeService;
import com.example.demoWeb.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends BaseController {

    private final CompanyService companyService;

    private final EmployeeService employeeService;

    private final ProjectService projectService;

    public HomeController(CompanyService companyService, EmployeeService employeeService, ProjectService projectService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.projectService = projectService;
    }


    @GetMapping("/")
    public String index(HttpServletRequest request) {
        if (this.isLogged(request)) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request, Model model) {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute(
                "areImported",
                this.companyService.exists() && this.projectService.exists()
                && this.employeeService.exists()
        );

        return "home";
    }
}
