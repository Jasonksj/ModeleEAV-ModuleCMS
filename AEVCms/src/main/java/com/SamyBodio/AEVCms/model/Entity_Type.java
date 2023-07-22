package com.SamyBodio.AEVCms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
//gar tu vas commencer a me gener ??? le faite que tu remettent les typ
// eT String  Tu voulais que jarrange le code nor ?Que ca compile ok
//Work sans compiler !!!!!
//Pour la compilation on va arranger le code avant! de compiler sinon on va se gener mutuellement
@jakarta.persistence.Entity
@Table
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Entity_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "et")
    @SequenceGenerator(name = "et", sequenceName = "et", allocationSize = 1)
    private Long id;
    private String name;
    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "Attribute_Id",
            referencedColumnName = "_Id"
    )
    private Attribute attribute;
}
