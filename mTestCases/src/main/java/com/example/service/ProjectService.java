package com.example.service;

import com.example.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project findById(int projectId);

    Project findByProjectName(String projectName);

    Project save(Project project);
}
