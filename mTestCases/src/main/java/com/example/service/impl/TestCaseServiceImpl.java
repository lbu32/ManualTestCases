package com.example.service.impl;

import com.example.dao.TestCaseDao;
import com.example.model.Project;
import com.example.model.TestCase;
import com.example.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestCaseServiceImpl implements TestCaseService{

    @Autowired
    private TestCaseDao testCaseDao;

    @Override
    public List<TestCase> findAll() {
        return testCaseDao.findAll();
    }

    @Override
    public TestCase findByTestCaseId(int testCaseId) {
        return testCaseDao.findByTestCaseId(testCaseId);
    }

    @Override
    public TestCase findByTitel(String titel) {
        return testCaseDao.findByTitel(titel);
    }

    @Override
    public TestCase save(TestCase testcase) {
        return testCaseDao.save(testcase);
    }

    @Override
    public List <TestCase> findByProject(Project project) {
        return testCaseDao.findByProject(project);
    }
}
