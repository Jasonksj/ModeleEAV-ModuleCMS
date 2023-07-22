package com.SamyBodio.AEVCms.model;


import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.TString2;
import com.SamyBodio.AEVCms.model.entity.User;
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
@EqualsAndHashCode
public class Attribute extends Entity {
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
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "AttributeSet_Id",
            referencedColumnName = "_Id"
    )
    private AttributeSet attributeSet;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "AttributeValues_Id",
            referencedColumnName = "_Id"
    )
    private List<AttributeValue> definedValues;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "AttributeValues_Id",
            referencedColumnName = "_Id"
    )
    private List<Entity_Type> entityTypeList;


    private boolean IsRequired;
    public Attribute(String slug,
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
        this.herited = herited;
        this.requiredValue = requiredValue;
        this.measurable = measurable;
        this.IsEntityDedicated = isEntityDedicated;
    }

    public void addPredifinedValues(List<AttributeValue> attributeValue){
        this.definedValues.addAll(attributeValue);
    }
}
