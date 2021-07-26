package com.example.demoWeb.services;

import java.io.IOException;

public interface CompanyService {

    String FILE_PATH = "files/xmls/companies.xml";

    boolean exists();

    String getXmlForImport() throws IOException;
}
