package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.Jsonconverter;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID _Id;

    protected String slug;

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

    @Column(columnDefinition = "json")
    @Convert(converter = Jsonconverter.class)
    protected TString title;

    @Column(columnDefinition = "json")
    @Convert(converter = Jsonconverter.class)
    protected TString description;

    protected SuperEntity(@Nullable String slug,@Nullable User createBy,
                       @Nullable User updateBy, @Nullable User deleteBy,
                       TString title, TString description) {
        this.slug = slug;
        this.createAt = LocalDate.now();
        this.createBy = createBy;
        this.updateAt = LocalDate.now();
        this.updateBy = updateBy;
        this.deleteAt = LocalDate.now();
        this.deleteBy = deleteBy;
        this.title = title;
        this.description = description;
    }
}
