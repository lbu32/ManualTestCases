package com.example.model;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TestCaseVersion {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int testCaseVersionId;

    @ManyToOne
    @JoinColumn(name = "testcase_id")
    private TestCase testCase;

    @CreationTimestamp
    private Date created;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    //Abgrenzung, was wird getestet?
    @Type(type="text")
    private String testDescription;

    //Abgrenzung erfolgreich/nicht erfolgreich
    @Type(type="text")
    private String definitionOfSuccess;

    @Type(type="text")
    private String definitionOfFailure;

    @Type(type="text")
    private String notToTest;

    private String upload;

    @Type(type="text")
    private String purposeOfFunctionality;
    private boolean active;

    private int versionNumber;

    public int getProtocolCounter() {
        return protocolCounter;
    }

    public void setProtocolCounter(int protocolCounter) {
        this.protocolCounter = protocolCounter;
    }

    private int protocolCounter;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public String getDefinitionOfSuccess() {
        return definitionOfSuccess;
    }

    public void setDefinitionOfSuccess(String definitionOfSuccess) {
        this.definitionOfSuccess = definitionOfSuccess;
    }

    public int getTestCaseVersionId() {
        return testCaseVersionId;
    }

    public void setTestCaseVersionId(int testCaseVersionId) {
        this.testCaseVersionId = testCaseVersionId;
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }



    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getPurposeOfFunctionality() {
        return purposeOfFunctionality;
    }

    public void setPurposeOfFunctionality(String purposeOfFunctionality) {
        this.purposeOfFunctionality = purposeOfFunctionality;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }
    public String getDefinitionOfFailure() {
        return definitionOfFailure;
    }

    public void setDefinitionOfFailure(String definitionOfFailure) {
        this.definitionOfFailure = definitionOfFailure;
    }
    public String getNotToTest() {
        return notToTest;
    }

    public void setNotToTest(String notToTest) {
        this.notToTest = notToTest;
    }
}