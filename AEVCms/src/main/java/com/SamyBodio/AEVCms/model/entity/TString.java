package com.SamyBodio.AEVCms.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TString {
    private String Fr;
    private String En;

    public TString() {
    }

    public TString(String french, String english) {
        Fr = french;
        En = english;
    }

}
