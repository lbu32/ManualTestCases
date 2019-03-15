package com.example.dao;

import com.example.model.TestCase;
import com.example.model.TestCaseVersion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestCaseVersionDao extends CrudRepository<TestCaseVersion,Integer> {
    List<TestCaseVersion> findAll();

    TestCaseVersion findByTestCaseVersionId(int testCaseVersionId);

    List<TestCaseVersion> findByTestCase(TestCase testcase);

    TestCaseVersion save(TestCaseVersion testCaseVersion);
}
