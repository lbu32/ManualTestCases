package com.example.service;

import com.example.model.TestCaseVersion;
import com.example.model.TestProtocol;

import java.util.List;


public interface TestProtocolService {
    List<TestProtocol> findAll();

    TestProtocol findByTestProtocolId(int testProtocolId);

    List<TestProtocol> findByTestCaseVersion(TestCaseVersion testCaseVersion);

    TestProtocol save(TestProtocol testProtocol);
}
