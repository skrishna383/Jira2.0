package com.skrishna383.jira2.service;

import com.skrishna383.jira2.dao.SprintDao;
import com.skrishna383.jira2.dao.TaskDao;
import com.skrishna383.jira2.model.JiraUser;
import com.skrishna383.jira2.model.Sprint;
import com.skrishna383.jira2.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {
    @Autowired
    SprintDao sprintDao;
    @Autowired
    TaskDao taskDao;

    public ResponseEntity<String> createSprints(Sprint sprint) {
        sprintDao.save(sprint);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Sprint>> getAllSprints() {
        return new ResponseEntity<>(sprintDao.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<List<Task>> getSprintTasks(Integer id) {
        return new ResponseEntity<>(taskDao.findBySprint(sprintDao.findById(id)), HttpStatus.OK);
    }
}
