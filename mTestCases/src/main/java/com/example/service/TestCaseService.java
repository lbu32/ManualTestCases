package com.example.service;

import com.example.model.Project;
import com.example.model.TestCase;

import java.util.List;


public interface TestCaseService {

    List<TestCase> findAll();

    TestCase findByTestCaseId(int testCaseId);

    TestCase findByTitel(String titel);

    TestCase save(TestCase testcase);

    List<TestCase> findByProject(Project project);
}
