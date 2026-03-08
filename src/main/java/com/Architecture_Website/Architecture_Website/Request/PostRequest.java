package com.Architecture_Website.Architecture_Website.Request;

import com.Architecture_Website.Architecture_Website.Model.Enum.Status;
import com.Architecture_Website.Architecture_Website.Model.PostEntity;
import jakarta.persistence.Column;

import java.util.UUID;

public record PostRequest(
        UUID id,
        String title,
        Integer viewQuantity,
        @Column(columnDefinition = "TEXT")
        String titleImage,
        @Column(columnDefinition = "TEXT")
        String content,
        Status status,
        String slug,
        @Column(columnDefinition = "TEXT")
        String description,
        UUID accountId
) {

}
