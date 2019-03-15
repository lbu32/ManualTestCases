package com.example.controller;

import com.example.model.Project;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value="all")
    public List<Project> findAllProjects() {

        return projectService.findAll();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Project saveProject(@RequestBody String projectName) {

        //String projectName = project.getProjectName();

        Project projectInDatabase = projectService.findByProjectName(projectName);

        if(projectInDatabase == null){
            Project project = new Project();
            project.setProjectName(projectName);
            projectService.save(project);
            return project;
        } else {
            System.out.println("Project already exists");
            return null;
        }
    }

    @RequestMapping(value = "updateProject", method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project) {
        Project projectInDatabase = projectService.findById(project.getProjectId());
        Project projectWithSameName = projectService.findByProjectName(project.getProjectName());
        if(projectWithSameName != null){
            return null;
        } else {
            projectInDatabase.setProjectName(project.getProjectName());
            return projectService.save(projectInDatabase);
        }


    }



    @RequestMapping(value= "getProjectByName", method = RequestMethod.POST)
    public Project getProjectByName(@RequestBody String projectName) {
        Project project = projectService.findByProjectName(projectName);
        return project;
    }

}
