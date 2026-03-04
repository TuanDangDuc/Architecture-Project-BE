package com.Architecture_Website.Architecture_Website.Controller;

import com.Architecture_Website.Architecture_Website.Model.ProjectEntity;
import com.Architecture_Website.Architecture_Website.Request.ProjectRequest;
import com.Architecture_Website.Architecture_Website.Request.UpdateProjectRequest;
import com.Architecture_Website.Architecture_Website.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectEntity> createProject(@RequestBody ProjectRequest request) {
        return ResponseEntity.ok(projectService.createProject(request));
    }

    // use for CUSTOMER
    @GetMapping
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    // use for ADMIN
    @GetMapping("/{id}")
    public List<ProjectEntity> getProjectByAdminId(
            @PathVariable UUID id
    ) {
        return projectService.getAllProjectByAdminId(id);
    }

    @PutMapping
    public ResponseEntity<?> updateProject(@RequestBody UpdateProjectRequest request) {
        projectService.update(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProjectById(@PathVariable UUID id) {
        projectService.deleById(id);
        return ResponseEntity.ok().build();
    }

    // filter by subCategory
    @GetMapping("/category/{id}")
    public List<ProjectEntity> getProjectBySubCategoryId(
            @PathVariable UUID id
    ) {
        return projectService.getProjectBySubCategoryId(id);
    }
}
