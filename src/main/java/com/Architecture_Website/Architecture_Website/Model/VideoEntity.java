package com.Architecture_Website.Architecture_Website.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
