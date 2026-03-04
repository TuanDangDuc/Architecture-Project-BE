package com.Architecture_Website.Architecture_Website.Model;

import com.Architecture_Website.Architecture_Website.Model.Enum.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    @CreationTimestamp
    @Column(
        updatable = false
    )
    private LocalDateTime uploadAt;
    private Integer viewQuantity;
    private String titleImage;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(columnDefinition = "TEXT")
    private String slug;
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JsonBackReference
    private AccountEntity account;

    @OneToMany(
            mappedBy = "post"
    )
    @JsonManagedReference
    private List<VideoEntity> video;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<ImageEntity> image;

}
