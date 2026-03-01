package com.Architecture_Website.Architecture_Website.Controller;

import com.Architecture_Website.Architecture_Website.Mapper.ImageMapper;
import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Request.ImageRequest;
import com.Architecture_Website.Architecture_Website.Response.ImageResponse;
import com.Architecture_Website.Architecture_Website.Service.ImageService;
import com.Architecture_Website.Architecture_Website.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    private final ImageMapper imageMapper;

    @PostMapping
    public ResponseEntity<?> addImage(@RequestBody List<ImageRequest> imageRequest){
        imageService.addImage(imageRequest.stream()
                .map(imageMapper::toImageEntity)
                .toList());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{projectId}")
    public List<ImageResponse> getImage(
            @PathVariable UUID projectId
    ) {
        return imageService.getImagesByProjectId(projectId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(
            @PathVariable UUID id
    ) {
        imageService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
