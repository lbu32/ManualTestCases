package com.example.model;

import javax.persistence.*;

@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int testCaseId;
    private String ticketId;
    private String titel;
    private boolean active;
    private int versionCounter;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public int getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(int testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getVersionCounter() {
        return versionCounter;
    }

    public void setVersionCounter(int versionCounter) {
        this.versionCounter = versionCounter;
    }
}
