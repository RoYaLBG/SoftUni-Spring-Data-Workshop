package com.example.demoWeb.services;

import com.example.demoWeb.dto.CompanyDto;
import com.example.demoWeb.entities.Company;
import com.example.demoWeb.repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final ModelMapper mapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper mapper) {
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }


    @Override
    public boolean exists() {
        return this.companyRepository.existsAllBy();
    }

    @Override
    public String getXmlForImport() throws IOException {
        return new String(this.getClass().getClassLoader().getResourceAsStream(FILE_PATH).readAllBytes(), StandardCharsets.UTF_8);
    }

    @Override
    public Long create(CompanyDto request) {
        var existing = this.companyRepository.findFirstByName(request.getName());
        if (existing != null) {
            return existing.getId();
        }

        var company = this.mapper.map(request, Company.class);

        this.companyRepository.save(company);

        return company.getId();
    }

    @Override
    public Company find(Long id) {
        return this.companyRepository.findById(id).orElseThrow();
    }
}
