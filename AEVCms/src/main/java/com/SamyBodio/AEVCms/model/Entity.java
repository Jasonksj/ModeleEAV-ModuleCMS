package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.Jsonconverter;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

//@jakarta.persistence.Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@MappedSuperclass
public abstract class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID _Id;

    protected String slug;

    @Column(columnDefinition = "json")
    @Convert(converter = Jsonconverter.class)
    protected TString title;
    @Column(columnDefinition = "json")
    @Convert(converter = Jsonconverter.class)
    protected TString description;

    @Temporal(TemporalType.DATE)
    protected LocalDate createAt;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    protected User createBy;

    @Temporal(TemporalType.DATE)
    protected LocalDate updateAt;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    protected User updateBy;

    @Temporal(TemporalType.DATE)
    protected LocalDate deleteAt;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    protected User deleteBy;


    protected Entity(String slug, TString title, TString description, User createBy, User updateBy, User deleteBy) {
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
