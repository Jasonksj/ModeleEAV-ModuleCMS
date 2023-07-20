package com.example.modeleEAV.models.DTO;

import com.example.modeleEAV.models.utilitiesEAV.AttributeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntityDTO {
    private String slug;
    private String title;
    private String description;
}
