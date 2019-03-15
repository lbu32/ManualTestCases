package com.example.dao;

import com.example.model.Project;
import com.example.model.TestCase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestCaseDao extends CrudRepository<TestCase,Integer> {
    List<TestCase> findAll();

    TestCase findByTestCaseId(int testCaseId);

    TestCase findByTitel(String titel);

    List <TestCase> findByProject(Project project);

    TestCase save(TestCase testcase);
}
