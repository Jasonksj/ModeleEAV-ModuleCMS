package com.example.modeleEAV.models.moduleCMS;


import com.example.modeleEAV.models.utilitiesEAV.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@jakarta.persistence.Entity
@Table
@Getter
@Setter
public class PageRegion extends Entity {

    public PageRegion(String title, String description) {
        super(title, description);
    }

    public PageRegion(String slug, String title, String description) {
        super(slug, title, description);
    }
}