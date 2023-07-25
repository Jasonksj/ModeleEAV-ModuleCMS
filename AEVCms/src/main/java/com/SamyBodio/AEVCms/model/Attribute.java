package com.SamyBodio.AEVCms.model;


import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@jakarta.persistence.Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Attribute extends SuperEntity {
    private AttributeType type;
    private Boolean herited;
    private Boolean requiredValue;
    private Boolean multipleValues = true;
    private Boolean freezeValues = true;
    private Boolean overriden = true;
    private Boolean shareable = true;
    private Boolean shared = true;
    private Boolean measurable;
    private Boolean IsEntityDedicated;

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "AttributeSet_Id",
            referencedColumnName = "_Id"
    )
    private AttributeSet attributeSet;

    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "AttributeValues_Id",
            referencedColumnName = "_Id"
    )
    @ToString.Exclude
    private List<AttributeValue> definedValues = new ArrayList<>();


    @JsonIgnore
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "Attribute_Entity",
            joinColumns = @JoinColumn(name = "attribute_id",referencedColumnName = "_Id"),
            inverseJoinColumns = @JoinColumn(name = "entity_Id",referencedColumnName = "_Id")
    )
    @ToString.Exclude
    private List<Entity> entityList = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "attribute_entity_type",
            joinColumns = @JoinColumn(name = "attribute_id",referencedColumnName = "_Id"),
            inverseJoinColumns = @JoinColumn(name = "entity_type_id",referencedColumnName = "id")
    )
    @ToString.Exclude
    private List<Entity_Type> entityTypes = new ArrayList<>();


    private boolean IsRequired;

    public Attribute(@Nullable String slug, @Nullable User createBy, @Nullable User updateBy, @Nullable User deleteBy, TString title,
                     TString description, AttributeType type, Boolean herited, Boolean requiredValue, Boolean multipleValues,
                     Boolean freezeValues, Boolean overriden, Boolean shareable, Boolean shared, Boolean measurable,
                     Boolean isEntityDedicated, AttributeSet attributeSet, boolean isRequired) {
        super(slug, createBy, updateBy, deleteBy, title, description);
        this.type = type;
        this.herited = herited;
        this.requiredValue = requiredValue;
        this.multipleValues = multipleValues;
        this.freezeValues = freezeValues;
        this.overriden = overriden;
        this.shareable = shareable;
        this.shared = shared;
        this.measurable = measurable;
        IsEntityDedicated = isEntityDedicated;
        this.attributeSet = attributeSet;
        IsRequired = isRequired;
    }

    public void addPredifinedValues(List<AttributeValue> attributeValue){
        this.definedValues.addAll(attributeValue);
    }
}
