package com.example.demoWeb.services;

import java.io.IOException;

public interface ProjectService {

    String FILE_PATH = "files/xmls/projects.xml";

    boolean exists();

    String getXmlForImport() throws IOException;

}
