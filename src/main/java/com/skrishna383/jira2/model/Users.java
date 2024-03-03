package com.skrishna383.jira2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "licenses")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;
}
