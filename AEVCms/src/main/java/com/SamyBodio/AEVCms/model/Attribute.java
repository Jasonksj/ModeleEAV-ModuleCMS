package com.SamyBodio.AEVCms.model;


import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@jakarta.persistence.Entity
@ToString
@Getter
@Setter
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
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private User user;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private AttributeSet attributeSet;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "attribute_id",referencedColumnName = "_id")
    @ToString.Exclude
    private List<AttributeValue> definedValues = new ArrayList<>();

    @ManyToMany(mappedBy = "attributes", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Entity> entities;
    public Attribute(String slug,
                     String title,
                     String description,
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
        this.entities= new ArrayList<>();
        IsEntityDedicated = isEntityDedicated;
    }

    public void addPredifinedValues(AttributeValue attributeValue){
        this.definedValues.add(attributeValue);
    }
    public void addEntity(Entity entity){
        this.entities.add(entity);
    }
}
