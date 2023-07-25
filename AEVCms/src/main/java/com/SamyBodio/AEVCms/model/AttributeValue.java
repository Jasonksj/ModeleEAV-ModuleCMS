package com.SamyBodio.AEVCms.model;


import com.SamyBodio.AEVCms.model.entity.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@ToString
@Getter
@Setter
@jakarta.persistence.Entity
public class AttributeValue extends SuperEntity {
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

    public AttributeValue(@Nullable String slug, @Nullable User createBy, @Nullable User updateBy, @Nullable User deleteBy, TString title, TString description, String value, Boolean validated, TString suffix, TString symbol, Attribute attribute) {
        super(slug, createBy, updateBy, deleteBy, title, description);
        this.value = value;
        this.validated = validated;
        this.suffix = suffix;
        this.symbol = symbol;
        this.attribute = attribute;
    }
}
