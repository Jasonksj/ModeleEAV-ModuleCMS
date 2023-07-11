package com.SamyBodio.AEVCms.model;


import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@jakarta.persistence.Entity
public class AttributeValue extends SuperEntity {
    private String value;
    private Boolean validated;
    private String suffixFr;
    private String suffixEn;
    private String symbolFr;
    private String symbolEn;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private Attribute attribute;
    public AttributeValue(String slug,
                          String title,
                          String description,
                          User createBy,
                          User updateBy,
                          User deleteBy,
                          String value,
                          Boolean validated,
                          String suffixFr,
                          String suffixEn,
                          String symbolFr,
                          String symbolEn) {
        super(slug,title,description,createBy,updateBy,deleteBy);
        this.value = value;
        this.validated = validated;
        this.suffixFr = suffixFr;
        this.suffixEn = suffixEn;
        this.symbolFr = symbolFr;
        this.symbolEn = symbolEn;
    }
}
