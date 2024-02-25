package com.skrishna383.jira2.controller;

import com.skrishna383.jira2.dto.JiraUserDTO;
import com.skrishna383.jira2.dto.SprintDTO;
import com.skrishna383.jira2.model.JiraUser;
import com.skrishna383.jira2.model.Sprint;
import com.skrishna383.jira2.model.Task;
import com.skrishna383.jira2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllUsers() {
        return taskService.getAllTasks();
    }

    @PostMapping("/{id}/assignUser")
    public ResponseEntity<String> assignUser(@PathVariable Integer id, @RequestBody JiraUserDTO jiraUserDTO) {
        return taskService.assignUser(id,jiraUserDTO);
    }
    @PostMapping("/{id}/assignSprint")
    public ResponseEntity<String> assignSprint(@PathVariable Integer id, @RequestBody SprintDTO sprintDTO) {
        return taskService.assignSprint(id,sprintDTO);
    }
}
