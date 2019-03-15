package com.example.service.impl;

import com.example.dao.ProjectDao;
import com.example.model.Project;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> findAll() {
        return projectDao.findAll();
    }

    @Override
    public Project findById(int projectId) {
        return projectDao.findByProjectId(projectId);
    }

    @Override
    public Project findByProjectName(String projectName) {
        return projectDao.findByProjectName(projectName);
    }

    @Override
    public Project save(Project project) {
        return projectDao.save(project);
    }
}
