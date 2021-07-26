package com.example.demoWeb.services;

import com.example.demoWeb.dto.EmployeeDto;
import com.example.demoWeb.dto.ExportedEmployeeDto;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    String FILE_PATH = "files/xmls/employees.xml";

    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(EmployeeDto request);

    List<ExportedEmployeeDto> getEmployeesAfter25();

}
