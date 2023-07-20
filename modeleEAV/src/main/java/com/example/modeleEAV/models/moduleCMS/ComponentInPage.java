package com.example.modeleEAV.models.moduleCMS;

public class ComponentInPage extends Component {
    private PageRegion region;

    public ComponentInPage(String title, String description) {
        super(title, description);
    }

    public ComponentInPage(String slug, String title, String description) {
        super(slug, title, description);
    }
}
