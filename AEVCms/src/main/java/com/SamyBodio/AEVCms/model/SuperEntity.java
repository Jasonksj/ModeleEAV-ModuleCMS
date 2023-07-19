package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.Str.TString2;
import com.SamyBodio.AEVCms.model.entity.TString;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID _Id= UUID.randomUUID();

    private String slug;
    @Column(unique = true)
    @Embedded
    private TString title;

    private TString2 description;

    private LocalDate createAt;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "create_By",
            referencedColumnName = "id"
    )
    private User createBy;

    private LocalDate updateAt;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "update_By",
            referencedColumnName = "id"
    )
    private User updateBy;

    private LocalDate deleteAt;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "delete_By",
            referencedColumnName = "id"
    )
    private User deleteBy;

    protected SuperEntity(String slug, TString title, TString2 description, User createBy, User updateBy, User deleteBy) {
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
