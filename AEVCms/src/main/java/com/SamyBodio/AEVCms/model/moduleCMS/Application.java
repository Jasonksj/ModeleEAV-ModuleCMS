package com.SamyBodio.AEVCms.model.moduleCMS;


import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.SamyBodio.AEVCms.model.Entity;

import java.util.List;

@jakarta.persistence.Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Application extends Entity {
    private String logo;
    private String slogan;
    //private Attribute[] attributes;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "view_id",
            referencedColumnName = "_Id"
    )
    private List<View> viewList;

    public Application(String slug, TString title, TString description, User createBy, User updateBy, User deleteBy, String logo, String slogan) {
        super(slug, title, description, createBy, updateBy, deleteBy);
        this.logo = logo;
        this.slogan = slogan;
    }
}
/*---------samy bodio = le best salut jason! contin represente bien ;lesrelations---------*/