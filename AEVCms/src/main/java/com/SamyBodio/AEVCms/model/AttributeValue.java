package com.SamyBodio.AEVCms.model;


import com.SamyBodio.AEVCms.model.entity.Str.TString2;
import com.SamyBodio.AEVCms.model.entity.Str.TString3;
import com.SamyBodio.AEVCms.model.entity.Str.TString4;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@jakarta.persistence.Entity
public class AttributeValue extends Entity {
    private String value;
    private Boolean validated;
    @Embedded
    private TString3 suffix;
    @Embedded
    private TString4 symbol;

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "attribute_id",
            referencedColumnName = "_Id"
    )
    private Attribute attribute;

    public AttributeValue(String slug, TString title, TString2 description, User createBy, User updateBy, User deleteBy,
                          String value, Boolean validated, TString3 suffix, TString4 symbol) {
        super(slug, title, description, createBy, updateBy, deleteBy);
        this.value = value;
        this.validated = validated;
        this.suffix = suffix;
        this.symbol = symbol;
    }
}
