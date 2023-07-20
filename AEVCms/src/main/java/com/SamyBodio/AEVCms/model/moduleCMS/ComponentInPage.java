package com.SamyBodio.AEVCms.model.moduleCMS;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class ComponentInPage extends Component {
    private PageRegion region;

    public ComponentInPage(String title, String description) {
        super(title, description);
    }

    public ComponentInPage(String slug, String title, String description) {
        super(slug, title, description);
    }
}
