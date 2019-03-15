package com.example.controller;

import com.example.model.Project;
import com.example.model.TestCase;
import com.example.model.TestCaseVersion;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/testcase")
public class TestCaseController {

    private String imageName;

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private TestCasesVersionService testCaseVersionService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    //@Autowired
    //private FileService fileService;

    TestCase currentTestCase;

    @RequestMapping(value = "saveTestCase", method = RequestMethod.POST)
    public TestCase saveTestCase(@RequestBody TestCase testCase){
        testCase.setVersionCounter(1);
        TestCase tCase = testCaseService.save(testCase);
        currentTestCase = tCase;
        //testCaseVersion.setTestCase(testCase);
        //testCaseVersionService.save(testCaseVersion);
        return tCase;
    }

    @RequestMapping(value = "saveTestCaseVersion", method = RequestMethod.POST)
    public TestCaseVersion saveTestCaseVersion(@RequestBody TestCaseVersion testCaseVersion){
        testCaseVersion.setTestCase(currentTestCase);
        testCaseVersion.setVersionNumber(1);
        testCaseVersion.setProtocolCounter(0);
        if(currentTestCase.isActive()){
            testCaseVersion.setActive(true);
        } else {
            testCaseVersion.setActive(false);
        }
        if(imageName != null) {
            testCaseVersion.setUpload(imageName);
            imageName = null;
        }
        currentTestCase = null;
        return testCaseVersionService.save(testCaseVersion);

    }

    @RequestMapping(value = "updateTestCaseVersion", method = RequestMethod.POST)
    public TestCaseVersion updateTestCaseVersion(@RequestBody TestCaseVersion testCaseVersion){
        TestCaseVersion versionToUpdate = testCaseVersionService.findByTestCaseVersionId(testCaseVersion.getTestCaseVersionId());
        versionToUpdate = testCaseVersion;
        if(imageName != null) {
            versionToUpdate.setUpload(imageName);
            imageName = null;
        }

        if(testCaseVersion.isActive()){
            TestCase testCase = testCaseService.findByTestCaseId(testCaseVersion.getTestCase().getTestCaseId());
            List<TestCaseVersion> testcaseversions = new ArrayList<TestCaseVersion>();
            testcaseversions = testCaseVersionService.findByTestCase(testCase);
            for (int i = 0; i < testcaseversions.size(); i++) {
                TestCaseVersion testCaseVersionToUpdate = testCaseVersionService.findByTestCaseVersionId(testcaseversions.get(i).getTestCaseVersionId());
                testCaseVersionToUpdate.setActive(false);
                testCaseVersionService.save(testCaseVersionToUpdate);
            }
        }
        return testCaseVersionService.save(versionToUpdate);

    }

    @RequestMapping(value = "testcasesForProject", method = RequestMethod.POST)
    public List<TestCase> getTestCasesByProject(@RequestBody String projectName){
        System.out.println(projectName);
        Project pro = projectService.findByProjectName(projectName);
        return testCaseService.findByProject(pro);
    }

    @RequestMapping(value = "testCaseVersionsForTestCase", method = RequestMethod.POST)
    public List<TestCaseVersion> getTestCaseVersionsForTestCase(@RequestBody String testCaseId){
        System.out.println("TestCaseId: "+testCaseId);
        int tcid = Integer.parseInt(testCaseId);
        TestCase tc = testCaseService.findByTestCaseId(tcid);
        return testCaseVersionService.findByTestCase(tc);
    }

    @RequestMapping(value="getTestCase", method = RequestMethod.POST)
    public TestCase getTestCase(@RequestBody TestCase testcase) {
        TestCase tc = testCaseService.findByTestCaseId(testcase.getTestCaseId());
        return tc;
    }

    @RequestMapping(value = "newTestCaseVersion", method = RequestMethod.POST)
    public TestCaseVersion saveNewTestCaseVersion(@RequestBody TestCaseVersion testCaseVersion) {
        int versionCounter = testCaseVersion.getTestCase().getVersionCounter();
        //we let the corresponding testcase know there is another Version
        versionCounter ++;
        TestCase testCaseToUpdate = testCaseService.findByTestCaseId(testCaseVersion.getTestCase().getTestCaseId());
        testCaseToUpdate.setVersionCounter(versionCounter);
        //set the testCaseVersionNumber
        testCaseVersion.setVersionNumber(versionCounter);
        if(imageName != null) {
            testCaseVersion.setUpload(imageName);
            imageName = null;
        }

        testCaseService.save(testCaseToUpdate);

        //if new Version is set active, set the others to inactive
        if(testCaseVersion.isActive()){
            List<TestCaseVersion> testcaseversions = new ArrayList<TestCaseVersion>();
            testcaseversions = testCaseVersionService.findByTestCase(testCaseToUpdate);
            for (int i = 0; i < testcaseversions.size(); i++) {
                TestCaseVersion testCaseVersionToUpdate = testCaseVersionService.findByTestCaseVersionId(testcaseversions.get(i).getTestCaseVersionId());
                testCaseVersionToUpdate.setActive(false);
                testCaseVersionService.save(testCaseVersionToUpdate);
            }
        }
        return testCaseVersionService.save(testCaseVersion);
    }

    @RequestMapping(value="fileUpload", method = RequestMethod.POST)
    public String saveImage(HttpServletResponse response, HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> it = multipartRequest.getFileNames();
        MultipartFile multipartFile = multipartRequest.getFile(it.next());
        String fileName = multipartFile.getOriginalFilename();
        imageName = fileName;

        String path = new File("target/classes/static/images").getAbsolutePath()+"/"+fileName;
        try {
            multipartFile.transferTo(new File(path));
            com.example.model.File file = new com.example.model.File();
            file.setFileName(fileName);
            //fileService.save(file);
            System.out.println(path);

        } catch (IOException e){
            e.printStackTrace();
        }

        return imageName;
    }

}
