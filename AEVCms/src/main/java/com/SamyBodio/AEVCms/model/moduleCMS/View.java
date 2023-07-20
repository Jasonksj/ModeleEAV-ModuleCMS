package com.SamyBodio.AEVCms.model.moduleCMS;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class View extends Application{
    private Attribute[] attributes;


    public View(String title, String description) {
        super(title, description);
    }

    public View(String slug, String title, String description) {
        super(slug, title, description);
    }
}
