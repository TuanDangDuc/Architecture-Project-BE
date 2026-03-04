package com.Architecture_Website.Architecture_Website.Repository;

import com.Architecture_Website.Architecture_Website.Model.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, UUID> {

    @Modifying
    @Transactional
    @Query("update VideoEntity a set a.title = :#{#video.title}," +
            "a.url = :#{#video.url}, " +
            "a.thumbnailUrl = :#{#video.thumbnailUrl} where a.id = :#{#video.id}")
    public void update(VideoEntity video);
}
