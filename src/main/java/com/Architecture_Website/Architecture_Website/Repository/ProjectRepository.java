package com.Architecture_Website.Architecture_Website.Repository;

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

}
