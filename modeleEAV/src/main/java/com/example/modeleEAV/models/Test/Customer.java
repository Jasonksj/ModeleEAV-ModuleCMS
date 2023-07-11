package com.example.modeleEAV.models.Test;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
    }
}
