package com.example.modeleEAV.models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributSetDTO extends EntityDTO{
    private String titleSet;
    private String descriptionSet;
    private boolean shareable;


    public AttributSetDTO(String slug, String title, String description, String titleSet, String descriptionSet, boolean shareable) {
        super(slug, title, description);
        this.titleSet = titleSet;
        this.descriptionSet = descriptionSet;
        this.shareable = shareable;
    }
}
