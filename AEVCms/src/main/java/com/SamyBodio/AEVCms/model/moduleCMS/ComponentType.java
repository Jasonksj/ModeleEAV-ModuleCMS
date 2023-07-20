package com.SamyBodio.AEVCms.model.moduleCMS;


import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeSet;
import com.example.modeleEAV.models.utilitiesEAV.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@jakarta.persistence.Entity
@Table
@Getter
@Setter
public class ComponentType extends Entity {
    private AttributeSet attributeSets;
    private Attribute[] attributes;
    private String title;
    private String description;
    private List<Component> componentList;

    public ComponentType(String title, String description) {
        super(title, description);
    }

    public ComponentType(String slug, String title, String description) {
        super(slug, title, description);
    }
}
