package com.example.modeleEAV.models.moduleCMS;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class Component extends View{
    private Attribute[] attributes;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "page_id",
            referencedColumnName = "id"
    )
    private Page page;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "sous_component_id",
            referencedColumnName = "id"
    )
    private List<Component> componentList;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "component_id",
            referencedColumnName = "id"
    )
    private Component component;
//Dans un composant il peut avoir plusieur composents nor ? oui normalement
    public Component(String title, String description) {
        super(title, description);
    }

    public Component(String slug, String title, String description) {
        super(slug, title, description);
    }
}
