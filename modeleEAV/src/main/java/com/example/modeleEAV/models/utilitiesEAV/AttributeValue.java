package com.example.modeleEAV.models.utilitiesEAV;

import lombok.*;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@javax.persistence.Entity
@Table
@Getter
@Setter
public class AttributeValue extends Entity {
    private String value;
    private boolean validated;
    private String suffix;
    private String symbol;

    @ManyToOne
    private Attribute attribute;


    public AttributeValue(String title, String description) {
        super(title, description);
    }

    public AttributeValue(String title, String description, String value, boolean validated, String suffix, String symbol) {
        super(title, description);
        this.value = value;
        this.validated = validated;
        this.suffix = suffix;
        this.symbol = symbol;
    }

    public AttributeValue(String title, String description, String value) {
        super(title, description);
        this.value = value;
    }

    public AttributeValue() {
        super(new String(), new String());
    }
}
