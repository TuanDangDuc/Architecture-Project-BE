package com.Architecture_Website.Architecture_Website.Request;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.UUID;

public record VideoRequest(
                String title,
                @Column(columnDefinition = "TEXT") String url,
                @Column(columnDefinition = "TEXT") String thumbnailUrl,
                String youtubeId,
                String category,
                String duration,
                UUID projectId,
                UUID adminId,
                @Column(columnDefinition = "TEXT")
                String linkUrl
) {
}
