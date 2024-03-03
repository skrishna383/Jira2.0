package com.skrishna383.jira2.dao;

import com.skrishna383.jira2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersDao extends JpaRepository<Users,Integer> {
    Optional<Users> findByUserName(String userName);
}
