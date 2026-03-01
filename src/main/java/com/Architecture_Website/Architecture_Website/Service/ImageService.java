package com.Architecture_Website.Architecture_Website.Service;
import com.Architecture_Website.Architecture_Website.Mapper.ImageMapper;
import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Repository.ImageRepository;
import com.Architecture_Website.Architecture_Website.Response.ImageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public void addImage(List<ImageEntity> list) {
        imageRepository.saveAll(list);
    }

    public List<ImageResponse> getImagesByProjectId(UUID projectId) {
        return imageRepository.getImageEntitiesByProjectId(projectId)
                .stream()
                .map(imageMapper::toImageResponse)
                .toList();
    }

    public void deleteById(UUID id) {
        imageRepository.deleteById(id);
    }
}
