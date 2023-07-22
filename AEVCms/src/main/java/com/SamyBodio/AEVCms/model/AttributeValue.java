package com.SamyBodio.AEVCms.model;


import com.SamyBodio.AEVCms.model.entity.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@jakarta.persistence.Entity
public class AttributeValue extends Entity {
    private String value;
    private Boolean validated;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Convert(converter = Jsonconverter.class)
    private TString suffix;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Convert(converter = Jsonconverter.class)
    private TString symbol;

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "attribute_id",
            referencedColumnName = "_Id"
    )
    private Attribute attribute;

    public AttributeValue(String slug, TString title, TString description, User createBy, User updateBy, User deleteBy,
                          String value, Boolean validated, TString suffix, TString symbol) {
        super(slug, title, description, createBy, updateBy, deleteBy);
        this.value = value;
        this.validated = validated;
        this.suffix = suffix;
        this.symbol = symbol;
    }
}
