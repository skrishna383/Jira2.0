package com.skrishna383.jira2.service;

import com.skrishna383.jira2.dao.JiraUserDao;
import com.skrishna383.jira2.dao.TaskDao;
import com.skrishna383.jira2.model.JiraUser;
import com.skrishna383.jira2.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class JiraUserService {
    @Autowired
    JiraUserDao jiraUserDao;
    @Autowired
    TaskDao taskDao;

    public ResponseEntity<String> createUser(JiraUser jiraUser) {
        jiraUserDao.save(jiraUser);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<JiraUser>> getAllUsers() {
        return new ResponseEntity<>(jiraUserDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Task>> getUserTasks(Integer id) {
        return new ResponseEntity<>(taskDao.findByAssignee(jiraUserDao.findById(id)), HttpStatus.OK);


    }

    public ResponseEntity<String> createUsers(List<JiraUser> jiraUsers) {
        jiraUsers.stream().forEach(e->jiraUserDao.save(e));
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> createUsersFromFile(MultipartFile file) {
        try {
            // Validate if the file is a CSV
            if (!file.getOriginalFilename().endsWith(".csv")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file format. Please upload a CSV file.");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            reader.lines().forEach(e-> {
                                        JiraUser js= new JiraUser();
                                        js.setName(e);
                                        jiraUserDao.save(js);});

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());

        }
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
