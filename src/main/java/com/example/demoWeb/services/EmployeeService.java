package com.example.demoWeb.services;

import java.io.IOException;

public interface EmployeeService {

    String FILE_PATH = "files/xmls/employees.xml";

    boolean exists();

    String getXmlForImport() throws IOException;

}
