package com.SamyBodio.AEVCms.model.moduleCMS;

import com.SamyBodio.AEVCms.model.Entity;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@jakarta.persistence.Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class ComponentType extends Entity {
    //private AttributeSet attributeSets;
    //private Attribute[] attributes;
    private TString title;
    private TString description;
    //private List<Component> componentList;


    public ComponentType(String slug, TString title, TString description, User createBy, User updateBy, User deleteBy, TString title1, TString description1) {
        super(slug, title, description, createBy, updateBy, deleteBy);
        this.title = title1;
        this.description = description1;
    }
}
