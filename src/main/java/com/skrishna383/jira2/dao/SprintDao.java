package com.skrishna383.jira2.dao;

import com.skrishna383.jira2.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintDao extends JpaRepository<Sprint,Integer> {
}
