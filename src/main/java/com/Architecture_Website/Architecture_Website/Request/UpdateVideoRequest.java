package com.Architecture_Website.Architecture_Website.Request;

import jakarta.persistence.Column;

import java.util.UUID;

public record UpdateVideoRequest(
                UUID id,
                String title,
                @Column(columnDefinition = "TEXT") String url,
                @Column(columnDefinition = "TEXT") String thumbnailUrl,
                String youtubeId,
                String category,
                String duration,
                @Column(columnDefinition = "TEXT")
                String linkUrl
) {
}
