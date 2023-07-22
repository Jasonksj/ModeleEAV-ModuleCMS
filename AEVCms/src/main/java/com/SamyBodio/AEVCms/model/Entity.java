package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.Jsonconverter;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.TString2;
import com.SamyBodio.AEVCms.model.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@jakarta.persistence.Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID _Id;

    private String slug;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Converter(converter = Jsonconverter.class)
    //merci
    private TString title;
    @Embedded
    @Column(columnDefinition = "json")
    private TString2 description;

    @Temporal(TemporalType.DATE)
    private LocalDate createAt;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private User createBy;

    @Temporal(TemporalType.DATE)
    private LocalDate updateAt;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private User updateBy;

    @Temporal(TemporalType.DATE)
    private LocalDate deleteAt;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private User deleteBy;


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

}
