package com.SamyBodio.AEVCms.model.moduleCMS;

import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Component extends View{
    //private Attribute[] attributes;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "page_id",
            referencedColumnName = "_Id"
    )
    private Page page;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "sous_component_id",
            referencedColumnName = "_Id"
    )
    private List<Component> componentList;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "component_id",
            referencedColumnName = "_Id"
    )
    private Component component;

    public Component(String slug, TString title, TString description, User createBy, User updateBy, User deleteBy, String logo, String slogan) {
        super(slug, title, description, createBy, updateBy, deleteBy, logo, slogan);
    }


//Dans un composant il peut avoir plusieur composents nor ? oui normalement

}
