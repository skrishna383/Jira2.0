package com.skrishna383.jira2.dao;

import com.skrishna383.jira2.model.JiraUser;
import com.skrishna383.jira2.model.Sprint;
import com.skrishna383.jira2.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskDao extends JpaRepository<Task,Integer> {
    List<Task> findByAssignee(Optional<JiraUser> jiraUser);
    List<Task> findBySprint(Optional<Sprint> sprint);
}
