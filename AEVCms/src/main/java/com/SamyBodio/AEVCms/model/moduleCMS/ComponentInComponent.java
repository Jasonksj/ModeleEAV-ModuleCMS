package com.SamyBodio.AEVCms.model.moduleCMS;

import com.SamyBodio.AEVCms.model.Attribute;
import com.SamyBodio.AEVCms.model.entity.Str.TString2;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class ComponentInComponent extends Component {

    public ComponentInComponent(String slug, TString title, TString2 description, User createBy, User updateBy, User deleteBy, String logo, String slogan) {
        super(slug, title, description, createBy, updateBy, deleteBy, logo, slogan);
    }
}
