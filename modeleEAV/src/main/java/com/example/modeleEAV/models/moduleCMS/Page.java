package com.example.modeleEAV.models.moduleCMS;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Page extends View {
    private PageRegion[] regions;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "component_id",
            referencedColumnName = "id"
    )
    private List<Component> componentList;


    public Page(String title, String description) {
        super(title, description);
    }/*code-tu reve?-*/

    public Page(String slug, String title, String description) {
        super(slug, title, description);
    }
}
