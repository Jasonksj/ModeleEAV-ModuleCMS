package com.SamyBodio.AEVCms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@jakarta.persistence.Entity
@Table
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Entity_Type{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "entityType"
    )
    private List<Entity> entityList;

    @JsonIgnore
    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "entityTypes"
    )
    private List<Attribute> attributes;
}
