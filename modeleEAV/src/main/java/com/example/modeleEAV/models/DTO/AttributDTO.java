package com.example.modeleEAV.models.DTO;

import com.example.modeleEAV.models.Types.TString;
import com.example.modeleEAV.models.utilitiesEAV.AttributeType;
import lombok.Getter;
import lombok.Setter;
/*--------------------bodio -----------------est ----------la */
@Getter
@Setter
public class AttributDTO extends EntityDTO{
    private AttributeType type;
    private boolean requiredValue;
    private boolean multipleValues;
    private boolean freezeValues;
    private boolean overriden;
    private boolean shareable;
    private boolean shared;
    private boolean measurable;
    private boolean isEntityDedicated;


    public AttributDTO(String slug, String title, String description, AttributeType type, boolean requiredValue, boolean multipleValues, boolean freezeValues, boolean overriden, boolean shareable, boolean shared, boolean measurable, boolean isEntityDedicated) {
        super(slug, title, description);
        this.type = type;
        this.requiredValue = requiredValue;
        this.multipleValues = multipleValues;
        this.freezeValues = freezeValues;
        this.overriden = overriden;
        this.shareable = shareable;
        this.shared = shared;
        this.measurable = measurable;
        this.isEntityDedicated = isEntityDedicated;
    }
}
