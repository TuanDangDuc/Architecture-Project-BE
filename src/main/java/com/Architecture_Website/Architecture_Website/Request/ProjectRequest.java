package com.Architecture_Website.Architecture_Website.Request;

import com.Architecture_Website.Architecture_Website.Model.Enum.Status;
import com.Architecture_Website.Architecture_Website.Model.Enum.Style;
import com.Architecture_Website.Architecture_Website.Model.Enum.Type;
import jakarta.persistence.Column;
import org.aspectj.lang.annotation.control.CodeGenerationHint;

import java.util.UUID;

public record ProjectRequest(
                String name,
                Integer area,
                Float constructionCost,
                Style style,
                String titleImage,
                Type type,
                @Column(columnDefinition = "TEXT")
                String slug,
                @Column(columnDefinition = "TEXT")
                String content,
                Status status,
                UUID categoryId,
                UUID adminId
) {
}
