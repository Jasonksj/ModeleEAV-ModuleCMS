package com.example.modeleEAV.models.utilitiesEAV;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class AttributeOption extends Attribute {
    private boolean isRequired;

    public AttributeOption(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public AttributeOption(String title, String description, boolean isRequired) {
        super(title, description);
        this.isRequired = isRequired;
    }

    public AttributeOption(String title, String description, AttributeType type, boolean requiredValue, boolean multipleValues, boolean freezeValues, boolean overriden, boolean shareable, boolean shared, boolean measurable, boolean isEntityDedicated, boolean isRequired) {
        super(title, description, type, requiredValue, multipleValues, freezeValues, overriden, shareable, shared, measurable, isEntityDedicated);
        this.isRequired = isRequired;
    }
}
