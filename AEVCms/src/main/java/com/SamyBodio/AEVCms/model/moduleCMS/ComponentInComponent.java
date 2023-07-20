package com.SamyBodio.AEVCms.model.moduleCMS;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class ComponentInComponent extends Component {
    public ComponentInComponent(String title, String description) {
        super(title, description);
    }

    public ComponentInComponent(String slug, String title, String description) {
        super(slug, title, description);
    }
}
