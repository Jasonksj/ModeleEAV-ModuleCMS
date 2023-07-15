package com.example.modeleEAV.models.utilitiesEAV;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@javax.persistence.Entity
@Table
@Getter
@Setter
public class Attribute extends Entity {

    private AttributeType type;
    private boolean requiredValue;
    private boolean multipleValues;
    private boolean freezeValues;
    private boolean overriden;
    private boolean shareable;
    private boolean shared;
    private boolean measurable;
    private boolean isEntityDedicated;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "attributeSet_id",
            referencedColumnName = "id"
    )
    private AttributeSet attributeSet;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "attribute_id",
            referencedColumnName = "id"
    )
    private List<AttributeValue> predefinedValues;

    public Attribute() {
        super(new String(), new String());
    }

    public Attribute(String title, String description) {
        super(title, description);
    }

    public Attribute(String title, String description, AttributeType type, boolean requiredValue, boolean multipleValues, boolean freezeValues, boolean overriden, boolean shareable, boolean shared, boolean measurable, boolean isEntityDedicated) {
        super(title, description);
        this.type = type;
        this.requiredValue = requiredValue;
        this.multipleValues = multipleValues;
        this.freezeValues = freezeValues;
        this.overriden = overriden;
        this.shareable = shareable;
        this.shared = shared;
        this.measurable = measurable;
        this.isEntityDedicated = isEntityDedicated;
        this.predefinedValues = new ArrayList<>();
    }

    public Attribute(String slug, String title, String description, AttributeType type, boolean requiredValue, boolean multipleValues, boolean freezeValues, boolean overriden, boolean shareable, boolean shared, boolean measurable, boolean isEntityDedicated, AttributeSet attributeSet) {
        super(slug, title, description);
        this.type = type;
        this.requiredValue = requiredValue;
        this.multipleValues = multipleValues;
        this.freezeValues = freezeValues;
        this.overriden = overriden;
        this.shareable = shareable;
        this.shared = shared;
        this.measurable = measurable;
        this.isEntityDedicated = isEntityDedicated;
        this.attributeSet = attributeSet;
    }

    public void addValuesInAttribute(AttributeValue value){
        this.predefinedValues.add(value);
    }
}
