package com.example.demoWeb.services;

import com.example.demoWeb.dto.ExportedProjectDto;
import com.example.demoWeb.dto.ProjectDto;
import com.example.demoWeb.entities.Project;
import com.example.demoWeb.repositories.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final CompanyService companyService;

    private final ModelMapper mapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, CompanyService companyService, ModelMapper mapper) {
        this.projectRepository = projectRepository;
        this.companyService = companyService;
        this.mapper = mapper;
    }

    @Override
    public boolean exists() {
        return this.projectRepository.existsAllBy();
    }

    @Override
    public String getXmlForImport() throws IOException {
        return new String(this.getClass().getClassLoader().getResourceAsStream(FILE_PATH).readAllBytes(), StandardCharsets.UTF_8);
    }

    @Override
    public Long create(ProjectDto request) {
        var existing = this.projectRepository.findFirstByNameAndCompanyName(request.getName(), request.getCompany().getName());
        if (existing != null) {
            return existing.getId();
        }

        var companyId = this.companyService.create(request.getCompany());

        var company = this.companyService.find(companyId);

        var project = this.mapper.map(request, Project.class);
        project.setCompany(company);

        this.projectRepository.save(project);

        return project.getId();
    }

    @Override
    public Project find(Long id) {
        return this.projectRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ExportedProjectDto> finishedProjects() {
        return this.projectRepository.findAllByFinishedIsTrue()
                .stream().map(p -> this.mapper.map(p, ExportedProjectDto.class))
                .collect(Collectors.toList());
    }
}
