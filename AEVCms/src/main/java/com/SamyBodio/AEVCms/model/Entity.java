package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.Jsonconverter;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@jakarta.persistence.Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@jakarta.persistence.Entity
public class Entity extends SuperEntity{


    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "entityType_id",
            referencedColumnName = "id"
    )
    private Entity_Type entityType;

    @JsonIgnore
    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "entityList"
    )
    private List<Attribute> attributeList = new ArrayList<>();

    protected Entity(String slug, TString title, TString description, User createBy, User updateBy, User deleteBy) {
        this.slug = slug;
        this.title = title;
        this.description = description;
        this.createAt = LocalDate.now();
        this.createBy = createBy;
        this.updateAt = LocalDate.now();
        this.updateBy = updateBy;
        this.deleteAt = LocalDate.now();
        this.deleteBy = deleteBy;
    }

}
