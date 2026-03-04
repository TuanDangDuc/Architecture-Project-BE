package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Model.ProjectEntity;
import com.Architecture_Website.Architecture_Website.Model.VideoEntity;
import com.Architecture_Website.Architecture_Website.Repository.AccountRepository;
import com.Architecture_Website.Architecture_Website.Repository.ProjectRepository;
import com.Architecture_Website.Architecture_Website.Repository.VideoRepository;
import com.Architecture_Website.Architecture_Website.Request.UpdateVideoRequest;
import com.Architecture_Website.Architecture_Website.Request.VideoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;
    private final ProjectRepository projectRepository;
    private final AccountRepository accountRepository;

    public VideoEntity addVideoToProject(VideoRequest request) {
        ProjectEntity project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        VideoEntity video = VideoEntity.builder()
                .title(request.title())
                .project(project)
                .url(request.url())
                .thumbnailUrl(request.thumbnailUrl())
                .owner(accountRepository.getReferenceById(request.adminId()))
                .build();

        return videoRepository.save(video);
    }

    public void deleteById(UUID id) {
        videoRepository.deleteById(id);
    }

    public void update(UpdateVideoRequest request) {
        VideoEntity video = VideoEntity.builder()
                .id(request.id())
                .title(request.title())
                .url(request.url())
                .thumbnailUrl(request.thumbnailUrl())
                .build();

        videoRepository.update(video);
    }

    public List<VideoEntity> getAllVideos() {
        return videoRepository.findAll();
    }

    public VideoEntity getVideoById(UUID id) {
        return videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
    }
}
