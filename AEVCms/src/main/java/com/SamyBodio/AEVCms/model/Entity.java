package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.Str.TString2;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@jakarta.persistence.Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Entity_Id=UUID.randomUUID();

    private String slug;

    @Embedded
    private TString title;

    @Embedded
    private TString2 description;

    private LocalDate createAt;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private User createBy;

    private LocalDate updateAt;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private User updateBy;

    private LocalDate deleteAt;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private User deleteBy;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name="Entity_Attribute",
            joinColumns = @JoinColumn(name = "Entity_Id",
            referencedColumnName = "Entity_Id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id",
                    referencedColumnName = "_Id")
    )
    private List<Attribute> attributes;

    public Entity(String slug, TString title, TString2 description, User createBy, User updateBy, User deleteBy) {
        this.slug = slug;
        this.title = title;
        this.description = description;
        this.createAt = LocalDate.now();
        this.createBy = createBy;
        this.updateAt = LocalDate.now();
        this.updateBy = updateBy;
        this.deleteAt = LocalDate.now();
        this.deleteBy = deleteBy;
    }
    public void addAttribute(Attribute attribute){
        if (attributes == null) attributes = new ArrayList<>();
        attributes.add(attribute);
    }
}
