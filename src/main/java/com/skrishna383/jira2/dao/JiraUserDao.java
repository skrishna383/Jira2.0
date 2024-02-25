package com.skrishna383.jira2.dao;

import com.skrishna383.jira2.model.JiraUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JiraUserDao extends JpaRepository<JiraUser, Integer> {
}
