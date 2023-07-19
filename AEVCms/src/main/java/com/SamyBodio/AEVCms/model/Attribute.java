package com.SamyBodio.AEVCms.model;


import com.SamyBodio.AEVCms.model.entity.Str.TString2;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@jakarta.persistence.Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Attribute extends SuperEntity {
    private AttributeType type;
    private Long identifier;
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
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "AttributeSet_Id",
            referencedColumnName = "_Id"
    )
    private AttributeSet attributeSet;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "attribute"
    )
    private List<AttributeValue> definedValues;

    @ManyToMany(mappedBy = "attributes", cascade = CascadeType.ALL)
    private List<Entity> entities;

    private boolean IsRequired;
    public Attribute(String slug,
                     Long identifier,
                     TString title,
                     TString2 description,
                     User createBy,
                     User updateBy,
                     User deleteBy,
                     AttributeType type,
                     Boolean herited,
                     Boolean requiredValue,
                     Boolean measurable,
                     Boolean isEntityDedicated) {
        super(slug,title,description,createBy,updateBy,deleteBy);
        this.type = type;
        this.identifier = identifier;
        this.herited = herited;
        this.requiredValue = requiredValue;
        this.measurable = measurable;
        this.entities= new ArrayList<>();
        IsEntityDedicated = isEntityDedicated;
    }

    public void addPredifinedValues(List<AttributeValue> attributeValue){
        this.definedValues.addAll(attributeValue);
    }
    public void addEntity(Entity entity){
        this.entities.add(entity);
    }
}
