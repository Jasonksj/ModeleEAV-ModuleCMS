package com.SamyBodio.AEVCms.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class TString3 {
    private String French3;
    private String English3;

    public TString3() {
    }

    public TString3(String french, String english) {
        French3 = french;
        English3 = english;
    }

}
