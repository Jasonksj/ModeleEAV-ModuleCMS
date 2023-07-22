package com.SamyBodio.AEVCms.model.moduleCMS;

import com.SamyBodio.AEVCms.model.Attribute;
import com.SamyBodio.AEVCms.model.entity.TString2;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;


@Entity
@Table
@Getter
@Setter
public class Page extends View {
    //private PageRegion[] regions;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "component_id",
            referencedColumnName = "_Id"
    )
    private List<Component> componentList;


    public Page(String slug, TString title, TString description, User createBy, User updateBy, User deleteBy, String logo, String slogan) {
        super(slug, title, description, createBy, updateBy, deleteBy, logo, slogan);
    }
}
