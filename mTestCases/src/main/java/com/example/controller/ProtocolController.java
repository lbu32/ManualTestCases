package com.example.controller;

import com.example.model.TestCaseVersion;
import com.example.model.TestProtocol;
import com.example.service.TestCasesVersionService;
import com.example.service.TestProtocolService;
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
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("protocol")
public class ProtocolController {

    private String imageName;

    @Autowired
    private TestProtocolService protocolService;

    @Autowired
    private TestCasesVersionService testCaseVersionService;

    @RequestMapping(value = "saveProtocol", method = RequestMethod.POST)
    public TestProtocol saveProtocol(@RequestBody TestProtocol testProtocol){

        int protocolCounter = testProtocol.getTestCaseVersion().getProtocolCounter();
        protocolCounter++;
        TestCaseVersion testCaseVersionToUpdate = testCaseVersionService.findByTestCaseVersionId(testProtocol.getTestCaseVersion().getTestCaseVersionId());
        testCaseVersionToUpdate.setProtocolCounter(protocolCounter);
        testProtocol.setProtocolNumber(protocolCounter);
        testCaseVersionService.save(testCaseVersionToUpdate);
        System.out.println("in protocol");
        if(imageName != null) {
            testProtocol.setUpload(imageName);
            imageName = null;
        }
        TestProtocol protocol = protocolService.save(testProtocol);

        return protocol;
    }

    @RequestMapping(value="getProtocolsByTestCaseVersion", method = RequestMethod.POST)
    public List<TestProtocol> getProtocolsByTestCaseVersion(@RequestBody TestCaseVersion testCaseVersion){
        System.out.println("in protocol");
        return protocolService.findByTestCaseVersion(testCaseVersion);
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
