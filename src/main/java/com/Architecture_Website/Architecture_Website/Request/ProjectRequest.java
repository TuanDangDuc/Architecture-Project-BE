package com.Architecture_Website.Architecture_Website.Request;

import com.Architecture_Website.Architecture_Website.Model.Enum.Style;
import com.Architecture_Website.Architecture_Website.Model.Enum.Type;
import java.util.UUID;

public record ProjectRequest(
                String name,
                Integer area,
                Float constructionCost,
                Style style,
                String titleImage,
                Type type,
                String slug,
                String content,
                UUID categoryId
) {
}
