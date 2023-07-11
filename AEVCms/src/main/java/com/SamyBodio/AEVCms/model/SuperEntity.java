package com.SamyBodio.AEVCms.model;

import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID _Id= UUID.randomUUID();

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

    public SuperEntity(String slug, String title, String description, User createBy, User updateBy, User deleteBy) {
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
