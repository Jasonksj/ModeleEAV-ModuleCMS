package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@jakarta.persistence.Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID _Id;

    private String slug;

    private String title;

    private String description;

    private LocalDate createAt;

    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    private User createBy;

    private LocalDate updateAt;

    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    private User updateBy;

    private LocalDate deleteAt;
    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    private User deleteBy;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name="Entity_Attribute",
            joinColumns = @JoinColumn(name = "_Id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id",
                    referencedColumnName = "_Id")
    )
    private List<Attribute> attributes = new ArrayList<>();

    public Entity(String slug, String title, String description, User createBy, User updateBy, User deleteBy) {
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
}
