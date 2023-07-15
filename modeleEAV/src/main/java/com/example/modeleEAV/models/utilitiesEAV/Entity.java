package com.example.modeleEAV.models.utilitiesEAV;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class Entity {
    @Id
    @SequenceGenerator(
            name = "entity_sequence",
            sequenceName = "entity_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entity_sequence"
    )
    protected Long id;
    //protected UUID id = UUID.randomUUID();
    protected String slug;
    protected String title;
    protected String description;
    protected String createdAt = new Date().toString();
    protected UUID createdBy;
    protected String updatedAt = new Date().toString();
    protected UUID updatedBy;
    protected String deletedAt = new Date().toString();
    protected UUID deletedBy;

    public Entity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Entity( String slug, String title, String description) {
        this.slug = slug;
        this.title = title;
        this.description = description;
    }
}
