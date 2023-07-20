package com.example.modeleEAV.models.moduleCMS;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
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
