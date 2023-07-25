package com.SamyBodio.AEVCms.model.moduleCMS;

import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ContentType extends Component {

    public ContentType(String slug, TString title, TString description, User createBy, User updateBy, User deleteBy, String logo, String slogan) {
        super(slug, title, description, createBy, updateBy, deleteBy, logo, slogan);
    }
}
