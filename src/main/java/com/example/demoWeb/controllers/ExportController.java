package com.example.demoWeb.controllers;

import com.example.demoWeb.services.EmployeeService;
import com.example.demoWeb.services.ProjectService;
import com.example.demoWeb.services.util.DataConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final ProjectService projectService;

    private final EmployeeService employeeService;

    private final DataConverter converter;

    public ExportController(ProjectService projectService, EmployeeService employeeService, DataConverter converter) {
        this.projectService = projectService;
        this.employeeService = employeeService;
        this.converter = converter;
    }

    @GetMapping("/project-if-finished")
    public String finishedProjects(Model model, HttpServletRequest req) {
        if (!this.isLogged(req)) {
            return "redirect:/";
        }

        model.addAttribute(
                "projectsIfFinished",
                this.projectService.finishedProjects().stream().map(this.converter::serialize)
                        .collect(Collectors.joining("\n"))
        );

        return "export/export-project-if-finished";
    }

    @GetMapping("/employees-above")
    public String employeesAbove(Model model, HttpServletRequest req) {
        if (!this.isLogged(req)) {
            return "redirect:/";
        }

        model.addAttribute(
                "employeesAbove",
                this.employeeService.getEmployeesAfter25()
                        .stream()
                        .map(this.converter::serialize)
                        .collect(Collectors.joining("\n"))
        );

        return "export/export-employees-with-age";
    }

}
