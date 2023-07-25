package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.Jsonconverter;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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

    @Column(columnDefinition = "json")
    @Convert(converter = Jsonconverter.class)
    private TString title;

    @Column(columnDefinition = "json")
    @Convert(converter = Jsonconverter.class)
    private TString description;


    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "entityType"
    )
    private List<Entity> entityList ;

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "entityTypes"
    )
    private List<Attribute> attributes;

    public Entity_Type(TString title, TString description, @Nullable List<Entity> entityList,@Nullable List<Attribute> attributes) {
        this.title = title;
        this.description = description;
        this.entityList = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }
}
