package com.example.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int fileId;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public TestCaseVersion getTestCaseVersion() {
        return testCaseVersion;
    }

    public void setTestCaseVersion(TestCaseVersion testCaseVersion) {
        this.testCaseVersion = testCaseVersion;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getFileId() {

        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @ManyToOne
    @JoinColumn(name = "testcase_version_id")
    private TestCaseVersion testCaseVersion;

    @CreationTimestamp
    private Date created;
}
