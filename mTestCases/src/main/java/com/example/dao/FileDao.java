package com.example.dao;

import com.example.model.File;
import com.example.model.TestCaseVersion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao extends CrudRepository<File,Integer> {

    List<File> findAll();

    List<File> findByTestCaseVersion(TestCaseVersion testCaseVersion);

    File save(File file);
}
