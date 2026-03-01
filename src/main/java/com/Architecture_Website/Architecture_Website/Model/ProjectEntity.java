package com.Architecture_Website.Architecture_Website.Model;

import com.Architecture_Website.Architecture_Website.Model.Enum.Style;
import com.Architecture_Website.Architecture_Website.Model.Enum.Type;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Integer area;
    private Float constructionCost;
    @Enumerated(EnumType.STRING)
    private Style style;
    @Column(columnDefinition = "TEXT")
    private String titleImage;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(columnDefinition = "TEXT")
    private String slug;
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JsonBackReference
    private AccountEntity owner;

    @OneToMany(
            mappedBy = "project"
    )
    @JsonManagedReference
    private Set<VideoEntity> videos;

    @ManyToOne
    @JsonBackReference
    private CategoryEntity category;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private Set<ImageEntity> images;

}
