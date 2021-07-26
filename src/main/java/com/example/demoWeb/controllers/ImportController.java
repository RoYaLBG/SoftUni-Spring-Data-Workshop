package com.example.demoWeb.controllers;

import com.example.demoWeb.services.CompanyService;
import com.example.demoWeb.services.EmployeeService;
import com.example.demoWeb.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ImportController extends BaseController {

    private final CompanyService companyService;

    private final EmployeeService employeeService;

    private final ProjectService projectService;

    public ImportController(CompanyService companyService, EmployeeService employeeService, ProjectService projectService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @GetMapping("/import/xml")
    public String importXml(Model model, HttpServletRequest request) {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute("areImported", new boolean[]{this.companyService.exists(), this.projectService.exists(), this.employeeService.exists()});

        return "xml/import-xml";
    }

    @GetMapping("/import/companies")
    public String importCompanies(Model model, HttpServletRequest request) throws IOException {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute(
                "companies",
                this.companyService.getXmlForImport()
        );

        return "xml/import-companies";
    }

    @GetMapping("/import/projects")
    public String importProjects(Model model, HttpServletRequest request) throws IOException {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute(
                "projects",
                this.projectService.getXmlForImport()
        );

        return "xml/import-projects";
    }

    @GetMapping("/import/employees")
    public String importEmployees(Model model, HttpServletRequest request) throws IOException {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute(
                "employees",
                this.employeeService.getXmlForImport()
        );

        return "xml/import-employees";
    }
}
