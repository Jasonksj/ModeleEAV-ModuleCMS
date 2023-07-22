package com.SamyBodio.AEVCms.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class TString4 {
    private String French4;
    private String English4;

    public TString4() {
    }

    public TString4(String french, String english) {
        French4 = french;
        English4 = english;
    }

}
