package com.Architecture_Website.Architecture_Website.Request;

import jakarta.persistence.Column;

import java.util.UUID;

public record ImageRequest(
        @Column(columnDefinition = "TEXT")
        String url,
        UUID projectId
) {
}
