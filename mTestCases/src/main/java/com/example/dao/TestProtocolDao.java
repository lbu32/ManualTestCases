package com.example.dao;

import com.example.model.TestCaseVersion;
import com.example.model.TestProtocol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestProtocolDao extends CrudRepository<TestProtocol,Integer> {

    List<TestProtocol> findAll();

    TestProtocol findByTestProtocolId(int testProtocolId);

    List<TestProtocol> findByTestCaseVersion(TestCaseVersion testCaseVersion);

    TestProtocol save(TestProtocol testProtocol);
}
