package com.example.modeleEAV.models.moduleCMS;


import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Date;
import java.util.List;

@jakarta.persistence.Entity
@Table
@Getter
@Setter
public class Application extends Entity {
    private Image logo;
    private String slogan;
    private Attribute[] attributes;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "view_id",
            referencedColumnName = "id"
    )
    private List<View> viewList;

    public Application(String title, String description) {
        super(title, description);
    }

    public Application(String slug, String title, String description) {
        super(slug, title, description);
    }
}
/*---------samy bodio = le best salut jason! contin represente bien ;lesrelations---------*/