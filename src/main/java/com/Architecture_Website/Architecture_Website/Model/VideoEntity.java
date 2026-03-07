package com.Architecture_Website.Architecture_Website.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String url;
    @Column(columnDefinition = "TEXT")
    private String thumbnailUrl;
    private String youtubeId;
    private String category;
    private String duration;
    @Column(columnDefinition = "TEXT")
    String linkUrl;
    @Builder.Default
    private Integer views = 0;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonBackReference
    private AccountEntity owner;

    @ManyToOne
    @JsonBackReference
    private PostEntity post;

    @ManyToOne
    @JsonBackReference
    private ProjectEntity project;
}
