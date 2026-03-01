package com.Architecture_Website.Architecture_Website.Mapper;

import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Model.ProjectEntity;
import com.Architecture_Website.Architecture_Website.Repository.ProjectRepository;
import com.Architecture_Website.Architecture_Website.Request.ImageRequest;
import com.Architecture_Website.Architecture_Website.Response.ImageResponse;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
@RequiredArgsConstructor
public class ImageMapper {
    private final ProjectRepository projectRepository;

    public ImageResponse toImageResponse(ImageEntity entity) {
        return ImageResponse.builder()
                .id(entity.getId())
                .url(entity.getUrl())
                .build();
    }

    public ImageEntity toImageEntity(ImageRequest imageRequest) {
        ProjectEntity prj = projectRepository.getReferenceById(imageRequest.projectId());
        return ImageEntity.builder()
                .url(imageRequest.url())
                .project(prj)
                .build();
    }
}
