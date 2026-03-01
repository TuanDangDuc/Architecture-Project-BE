package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Model.CategoryEntity;
import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Model.ProjectEntity;
import com.Architecture_Website.Architecture_Website.Repository.CategoryRepository;
import com.Architecture_Website.Architecture_Website.Repository.ProjectRepository;
import com.Architecture_Website.Architecture_Website.Request.ProjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final CategoryRepository categoryRepository;

    public ProjectEntity createProject(ProjectRequest request) {
        CategoryEntity category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        ProjectEntity project = ProjectEntity.builder()
                .name(request.name())
                .area(request.area())
                .constructionCost(request.constructionCost())
                .style(request.style())
                .titleImage(request.titleImage())
                .type(request.type())
                .slug(request.slug())
                .content(request.content())
                .category(category)
                .build();

        return projectRepository.save(project);
    }

    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    public ProjectEntity getProjectById(UUID id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

}
