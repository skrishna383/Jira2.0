package com.skrishna383.jira2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class JiraUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;

}
