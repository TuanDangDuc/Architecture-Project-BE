package com.Architecture_Website.Architecture_Website.Repository;

import com.Architecture_Website.Architecture_Website.Model.Enum.Status;
import com.Architecture_Website.Architecture_Website.Model.PostEntity;
import com.Architecture_Website.Architecture_Website.Response.PostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, UUID> {
    @Query("select a from PostEntity a where a.account.id = :id")
    public List<PostEntity> getAllPost(UUID id);


    @Modifying
    @Transactional
    @Query("""
        update PostEntity a 
        set a.title = :#{#b.title},
            a.viewQuantity = :#{#b.viewQuantity},
            a.titleImage = :#{#b.titleImage},
            a.content = :#{#b.content},
            a.status = :#{#b.status},
            a.slug = :#{#b.slug},
            a.description = :#{#b.description}
        where a.id = :#{#b.id}
    """)
    void update(PostEntity b);

    @Query("select a from PostEntity a where a.status = :st")
    public List<PostResponse> get(Status st);
}
