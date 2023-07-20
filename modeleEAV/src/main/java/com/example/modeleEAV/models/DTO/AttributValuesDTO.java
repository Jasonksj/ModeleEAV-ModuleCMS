package com.example.modeleEAV.models.DTO;

import com.example.modeleEAV.models.Types.TString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributValuesDTO extends EntityDTO {
    private String value;
    private boolean validated;
    private String suffix;
    private String symbol;

    public AttributValuesDTO(String slug, String title, String description, String value, boolean validated, String suffix, String symbol) {
        super(slug, title, description);
        this.value = value;
        this.validated = validated;
        this.suffix = suffix;
        this.symbol = symbol;
    }
}
