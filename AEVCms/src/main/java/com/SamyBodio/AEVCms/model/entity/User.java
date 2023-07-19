package com.SamyBodio.AEVCms.model.entity;

import com.SamyBodio.AEVCms.model.Attribute;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Long id;
    @Column(length = 10)
    private String Name;
    @Column(length = 10)
    private String passWord;

    public User(String name, String passWord) {
        Name = name;
        this.passWord = passWord;
    }
}
