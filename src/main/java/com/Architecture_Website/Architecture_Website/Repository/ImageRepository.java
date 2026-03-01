package com.Architecture_Website.Architecture_Website.Repository;

import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Response.ImageResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, UUID> {
    @Query("select a from ImageEntity a where a.project.id = :projectId")
    List<ImageEntity> getImageEntitiesByProjectId(UUID projectId);
}
