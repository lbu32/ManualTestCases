package com.example.model;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TestProtocol {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int testProtocolId;

    @ManyToOne
    @JoinColumn(name = "testcase_version_id")
    private TestCaseVersion testCaseVersion;

    @CreationTimestamp
    private Date created;

    //@ManyToOne
    //@JoinColumn(name = "tester_case_assignee_id")
    private String testCaseAssignee;

    private String title;

    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private int protocolNumber;

    public int getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(int protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TestCaseVersion getTestCaseVersion() {
        return testCaseVersion;
    }

    public void setTestCaseVersion(TestCaseVersion testCaseVersion) {
        this.testCaseVersion = testCaseVersion;
    }

    public String getTestCaseAssignee() {
        return testCaseAssignee;
    }

    public void setTestCaseAssignee(String testCaseAssignee) {
        this.testCaseAssignee = testCaseAssignee;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    private boolean resultStatus;

    @Type(type="text")
    private String description;

    private String upload;

    public int getTestProtocolId() {
        return testProtocolId;
    }

    public void setTestProtocolId(int testProtocolId) {
        this.testProtocolId = testProtocolId;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(boolean resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }
}