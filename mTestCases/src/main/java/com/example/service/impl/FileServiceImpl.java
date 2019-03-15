package com.example.service.impl;

import com.example.dao.FileDao;
import com.example.model.File;
import com.example.model.TestCaseVersion;
import com.example.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public List<File> findAll() {
        return fileDao.findAll();
    }

    @Override
    public List<File> findByTestCaseVersion(TestCaseVersion testCaseVersion) {
        return fileDao.findByTestCaseVersion(testCaseVersion);
    }

    @Override
    public File save(File file) {
        return fileDao.save(file);
    }
}
