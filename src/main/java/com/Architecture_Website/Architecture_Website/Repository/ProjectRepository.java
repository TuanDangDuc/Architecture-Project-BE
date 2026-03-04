package com.Architecture_Website.Architecture_Website.Repository;

import com.Architecture_Website.Architecture_Website.Model.Enum.Status;
import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Model.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {

    @Query("select a from ProjectEntity a where a.owner.id = :id")
    public List<ProjectEntity> getProjectByAdminId(UUID id);

    @Query("select a from ProjectEntity a where a.status = :st")
    public List<ProjectEntity> getAll(Status st);

    @Modifying
    @Transactional
    @Query("update ProjectEntity a set a.name = :#{#b.name}," +
            "a.area = :#{#b.area}," +
            "a.constructionCost = :#{#b.constructionCost}," +
            "a.style = :#{#b.style}," +
            "a.titleImage = :#{#b.titleImage}," +
            "a.type = :#{#b.type}," +
            "a.slug = :#{#b.slug}," +
            "a.content = :#{#b.content}," +
            "a.status = :#{#b.status}," +
            "a.category = :#{#b.category} where a.id = :#{#b.id}")
    public void update(ProjectEntity b);

    @Query("select a from ProjectEntity a where a.category.id = :id")
    public List<ProjectEntity> getProjectBySubCategoryId(UUID id);
}
