package com.skrishna383.jira2.service;

import com.skrishna383.jira2.dao.JiraUserDao;
import com.skrishna383.jira2.dao.SprintDao;
import com.skrishna383.jira2.dao.TaskDao;
import com.skrishna383.jira2.dto.JiraUserDTO;
import com.skrishna383.jira2.dto.SprintDTO;
import com.skrishna383.jira2.model.JiraUser;
import com.skrishna383.jira2.model.Sprint;
import com.skrishna383.jira2.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;
    @Autowired
    JiraUserDao jiraUserDao;
    @Autowired
    SprintDao sprintDao;

    public ResponseEntity<String> createTask(Task task) {
        taskDao.save(task);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskDao.findAll(),HttpStatus.OK);

    }

    public ResponseEntity<String> assignUser(Integer id, JiraUserDTO jiraUserDTO) {
        Optional<Task> task = taskDao.findById(id);
        Optional<JiraUser> jiraUser = jiraUserDao.findById(jiraUserDTO.getId());
        task.get().setAssignee(jiraUser.get());
        taskDao.save(task.get());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> assignSprint(Integer id, SprintDTO sprintDTO) {
        Optional<Task> task = taskDao.findById(id);
        Optional<Sprint> sprint = sprintDao.findById(sprintDTO.getId());
        task.get().setSprint(sprint.get());
        taskDao.save(task.get());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
