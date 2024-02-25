package com.skrishna383.jira2.controller;

import com.skrishna383.jira2.model.JiraUser;
import com.skrishna383.jira2.model.Sprint;
import com.skrishna383.jira2.model.Task;
import com.skrishna383.jira2.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprints")
public class SprintController {
    @Autowired
    SprintService sprintService;

    @PostMapping("/")
    public ResponseEntity<String> createSprint(@RequestBody Sprint sprint) {
        return sprintService.createSprints(sprint);
    }

    @GetMapping("/")
    public ResponseEntity<List<Sprint>> getAllUsers() {
        return sprintService.getAllSprints();
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getSprintTasks(@PathVariable Integer id) {
        return sprintService.getSprintTasks(id);
    }

}
