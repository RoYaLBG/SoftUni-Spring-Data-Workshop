package com.example.demoWeb.services;

import com.example.demoWeb.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public boolean exists() {
        return this.companyRepository.existsAllBy();
    }

    @Override
    public String getXmlForImport() throws IOException {
        return new String(this.getClass().getClassLoader().getResourceAsStream(FILE_PATH).readAllBytes(), StandardCharsets.UTF_8);
    }
}
