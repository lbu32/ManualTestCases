package com.example.service;

import com.example.model.TestCase;
import com.example.model.TestCaseVersion;

import java.util.List;

public interface TestCasesVersionService {

    List<TestCaseVersion> findAll();

    List<TestCaseVersion> findByTestCase(TestCase testCase);

    TestCaseVersion findByTestCaseVersionId(int testCaseVersionId);

    TestCaseVersion save(TestCaseVersion testCaseVersion);
}
