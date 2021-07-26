package com.example.demoWeb.services;

import com.example.demoWeb.dto.ExportedProjectDto;
import com.example.demoWeb.dto.ProjectDto;
import com.example.demoWeb.entities.Project;

import java.io.IOException;
import java.util.List;

public interface ProjectService {

    String FILE_PATH = "files/xmls/projects.xml";

    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(ProjectDto request);

    Project find(Long id);

    List<ExportedProjectDto> finishedProjects();
}
