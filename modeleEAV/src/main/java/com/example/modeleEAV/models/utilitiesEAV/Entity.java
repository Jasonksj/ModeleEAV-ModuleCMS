package com.example.modeleEAV.models.utilitiesEAV;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class Entity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID,
            generator = "entity_sequence"
    )
    protected UUID id;
    protected String slug;
    protected String title;
    protected String description;
    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    protected Date createdAt = new Date();
    protected UUID createdBy = UUID.randomUUID();
    @Temporal(TemporalType.DATE)
    protected Date updatedAt = new Date();
    protected UUID updatedBy = UUID.randomUUID();
    @Temporal(TemporalType.DATE)
    protected Date deletedAt = new Date();
    protected UUID deletedBy = UUID.randomUUID();

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
