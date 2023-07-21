package com.SamyBodio.AEVCms.model.moduleCMS;

import com.SamyBodio.AEVCms.model.Entity;
import com.SamyBodio.AEVCms.model.entity.Str.TString2;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@jakarta.persistence.Entity
@Table
@Getter
@Setter
public class PageRegion extends Entity {
    public PageRegion() {
    }

    public PageRegion(String slug, TString title, TString2 description, User createBy, User updateBy, User deleteBy) {
        super(slug, title, description, createBy, updateBy, deleteBy);
    }


}