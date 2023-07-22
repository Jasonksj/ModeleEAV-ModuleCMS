package com.SamyBodio.AEVCms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TString {
    private String Fr;
    private String En;

    public TString(String french, String english) {
        Fr = french;
        En = english;
    }

}
