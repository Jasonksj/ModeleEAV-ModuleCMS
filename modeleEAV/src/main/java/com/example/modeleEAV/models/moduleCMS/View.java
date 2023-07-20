package com.example.modeleEAV.models.moduleCMS;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
