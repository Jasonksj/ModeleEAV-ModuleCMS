package com.example.modeleEAV.models.Test;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Customer> customers;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User() {
    }
}
