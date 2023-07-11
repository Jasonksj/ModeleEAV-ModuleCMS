package com.example.modeleEAV.models.utilitiesEAV;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@javax.persistence.Entity
@Table
@Getter
@Setter
public class AttributeSet extends Entity{
    private String titleSet;
    private String descriptionSet;
    private boolean shareable;
    @ToString.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Attribute> attributes = new ArrayList<>();

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
