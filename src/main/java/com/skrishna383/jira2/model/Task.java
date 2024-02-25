package com.skrishna383.jira2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE)
    private Integer id;
    private String summary;
    @ManyToOne
    private JiraUser assignee;
    @ManyToOne
    private Sprint sprint;




}
