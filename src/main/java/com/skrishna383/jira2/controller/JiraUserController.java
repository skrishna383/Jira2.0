package com.skrishna383.jira2.controller;

import com.skrishna383.jira2.model.JiraUser;
import com.skrishna383.jira2.model.Task;
import com.skrishna383.jira2.service.JiraUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
public class JiraUserController {
    @Autowired
    JiraUserService jiraUserService;

    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody JiraUser jirauser) {
        return jiraUserService.createUser(jirauser);
    }

    @PostMapping("/list")
    public ResponseEntity<String> createUsers(@RequestBody List<JiraUser> jiraUsers) {
        return jiraUserService.createUsers(jiraUsers);
    }
    @PostMapping("/listfromfile")
    public ResponseEntity<String> createUsersFromFile(@RequestPart("file") MultipartFile file){
        return jiraUserService.createUsersFromFile(file);
    }



    @GetMapping("/")
    public ResponseEntity<List<JiraUser>> getAllUsers() {
        return jiraUserService.getAllUsers();
    }
    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getUserTasks(@PathVariable Integer id) {
        return jiraUserService.getUserTasks(id);
    }
}