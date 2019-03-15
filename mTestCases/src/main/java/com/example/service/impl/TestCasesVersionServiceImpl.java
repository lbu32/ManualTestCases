package com.example.service.impl;

import com.example.dao.TestCaseVersionDao;
import com.example.model.TestCase;
import com.example.model.TestCaseVersion;
import com.example.service.TestCasesVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCasesVersionServiceImpl implements TestCasesVersionService {

    @Autowired
    private TestCaseVersionDao tcVersionDao;

    @Override
    public List<TestCaseVersion> findAll() {
        return tcVersionDao.findAll();
    }

    @Override
    public TestCaseVersion findByTestCaseVersionId(int testCaseVersionId) {
        return tcVersionDao.findByTestCaseVersionId(testCaseVersionId);
    }

    @Override
    public List<TestCaseVersion> findByTestCase(TestCase testCase) {
        return tcVersionDao.findByTestCase(testCase);
    }

    @Override
    public TestCaseVersion save(TestCaseVersion testCaseVersion) {
        return tcVersionDao.save(testCaseVersion);
    }
}
