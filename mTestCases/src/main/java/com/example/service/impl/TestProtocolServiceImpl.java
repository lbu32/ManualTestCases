package com.example.service.impl;

import com.example.dao.TestProtocolDao;
import com.example.model.TestCaseVersion;
import com.example.model.TestProtocol;
import com.example.service.TestProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestProtocolServiceImpl implements TestProtocolService {

    @Autowired
    private TestProtocolDao tpDao;

    @Override
    public List<TestProtocol> findAll() {
        return tpDao.findAll();
    }

    @Override
    public TestProtocol findByTestProtocolId(int testProtocolId) {
        return tpDao.findByTestProtocolId(testProtocolId);
    }

    @Override
    public List<TestProtocol> findByTestCaseVersion(TestCaseVersion testCaseVersion) {
        return tpDao.findByTestCaseVersion(testCaseVersion);
    }

    @Override
    public TestProtocol save(TestProtocol testProtocol) {
        return tpDao.save(testProtocol);
    }
}
