package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@jakarta.persistence.Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AttributeSet extends SuperEntity {
    private String titleFr;
    private String titleEn;
    private String descriptionFr;
    private String descriptionEn;
    private Boolean shareable;

    @OneToMany
    private List<Attribute> attributes = new ArrayList<>();

    public AttributeSet(String slug,
                       String title,
                       String description,
                       User createBy,
                       User updateBy,
                       User deleteBy,
                       String titleFr,
                       String titleEn,
                       String descriptionFr,
                       String descriptionEn,
                       Boolean shareable) {
        super(slug,title,description,createBy,updateBy,deleteBy);
        this.titleFr = titleFr;
        this.titleEn = titleEn;
        this.descriptionFr = descriptionFr;
        this.descriptionEn = descriptionEn;
        this.shareable = shareable;
    }
}
