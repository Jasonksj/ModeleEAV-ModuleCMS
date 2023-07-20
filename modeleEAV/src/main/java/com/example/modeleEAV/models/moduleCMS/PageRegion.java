package com.example.modeleEAV.models.moduleCMS;


import com.example.modeleEAV.models.utilitiesEAV.Entity;

import java.util.Date;

public class PageRegion extends Entity {

    public PageRegion(String title, String description) {
        super(title, description);
    }

    public PageRegion(String slug, String title, String description) {
        super(slug, title, description);
    }
}