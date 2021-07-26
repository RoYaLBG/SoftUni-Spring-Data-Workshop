package com.example.demoWeb.services;

import com.example.demoWeb.dto.CompanyDto;
import com.example.demoWeb.entities.Company;

import java.io.IOException;

public interface CompanyService {

    String FILE_PATH = "files/xmls/companies.xml";

    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(CompanyDto request);

    Company find(Long id);
}
