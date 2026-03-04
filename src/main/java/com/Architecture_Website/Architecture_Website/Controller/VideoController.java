package com.Architecture_Website.Architecture_Website.Controller;

import com.Architecture_Website.Architecture_Website.Model.VideoEntity;
import com.Architecture_Website.Architecture_Website.Request.UpdateVideoRequest;
import com.Architecture_Website.Architecture_Website.Request.VideoRequest;
import com.Architecture_Website.Architecture_Website.Service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/video")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @PostMapping()
    public ResponseEntity<VideoEntity> addVideoToProject(@RequestBody VideoRequest request) {
        return ResponseEntity.ok(videoService.addVideoToProject(request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<VideoEntity> deleteVideoFromProject(
            @PathVariable UUID id) {
        videoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<VideoEntity> updateVideo(
            @RequestBody UpdateVideoRequest request) {
        videoService.update(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<VideoEntity>> getAllVideos() {
        return ResponseEntity.ok(videoService.getAllVideos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoEntity> getVideoById(@PathVariable UUID id) {
        return ResponseEntity.ok(videoService.getVideoById(id));
    }
}
