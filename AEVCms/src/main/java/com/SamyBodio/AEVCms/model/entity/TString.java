package com.SamyBodio.AEVCms.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class TString {
    private String French;
    private String English;

    public TString() {
    }

    public TString(String french, String english) {
        French = french;
        English = english;
    }

}
