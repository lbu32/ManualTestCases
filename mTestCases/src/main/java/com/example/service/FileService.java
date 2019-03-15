package com.example.service;
import com.example.model.File;
import com.example.model.TestCaseVersion;

import java.util.List;

public interface FileService {

    List<File> findAll();

    List<File> findByTestCaseVersion(TestCaseVersion testCaseVersion);

    File save(File file);

}
