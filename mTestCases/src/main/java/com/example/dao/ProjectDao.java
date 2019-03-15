package com.example.dao;

import com.example.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectDao extends CrudRepository<Project,Integer> {

    List<Project> findAll();

    Project findByProjectId(int projectId);

    Project findByProjectName(String projectName);

    Project save(Project project);

}
