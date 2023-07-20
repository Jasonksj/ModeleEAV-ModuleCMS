package com.example.modeleEAV.models.utilitiesEAV;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@jakarta.persistence.Entity
@Table
@Getter
@Setter
public class AttributeSet extends Entity{
    private String titleSet;
    private String descriptionSet;
    private boolean shareable;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "attributeSet_id",
            referencedColumnName = "id"
    )
    private List<Attribute> attributes;

    public AttributeSet(String title, String description) {
        super(title, description);
    }

    public AttributeSet() {
        super(new String(), new String());
    }

    public AttributeSet(String title, String description, String titleSet, String descriptionSet, boolean shareable, List<Attribute> attributes) {
        super(title, description);
        this.titleSet = titleSet;
        this.descriptionSet = descriptionSet;
        this.shareable = shareable;
        this.attributes = attributes;
    }

    public AttributeSet(String titleSet, String descriptionSet, boolean shareable, List<Attribute> attributes) {
        super(new String(), new String());
        this.titleSet = titleSet;
        this.descriptionSet = descriptionSet;
        this.shareable = shareable;
        this.attributes = attributes;
    }

    public AttributeSet(String title, String description,String titleSet, String descriptionSet, boolean shareable) {
        super(title, description);
        this.titleSet = titleSet;
        this.descriptionSet = descriptionSet;
        this.shareable = shareable;
    }
}
