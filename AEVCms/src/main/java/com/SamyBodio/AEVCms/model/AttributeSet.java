package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.*;
import com.SamyBodio.AEVCms.model.entity.Str.TString2;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@jakarta.persistence.Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(
        name = "AttributeSet"
)
public class AttributeSet extends SuperEntity {

    private Boolean shareable;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "attributeSet"
    )
    private List<Attribute> attributes = new ArrayList<>();

    public AttributeSet(String slug,
                       @Nullable User createBy,
                       @Nullable User updateBy,
                       @Nullable User deleteBy,
                       TString title,
                       TString2 description,
                       Boolean shareable) {
        super(slug,title,description,createBy,updateBy,deleteBy);
        this.shareable = shareable;
    }
}
