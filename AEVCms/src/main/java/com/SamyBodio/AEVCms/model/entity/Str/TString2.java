package com.SamyBodio.AEVCms.model.entity.Str;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class TString2 {
    private String French2;
    private String English2;

    public TString2() {
    }

    public TString2(String french, String english) {
        French2 = french;
        English2 = english;
    }

}
