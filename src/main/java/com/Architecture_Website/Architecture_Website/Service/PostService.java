package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Mapper.PostMapper;
import com.Architecture_Website.Architecture_Website.Model.Enum.Status;
import com.Architecture_Website.Architecture_Website.Repository.PostRepository;
import com.Architecture_Website.Architecture_Website.Request.PostRequest;
import com.Architecture_Website.Architecture_Website.Response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public void save(PostRequest request) {
        postRepository.save(postMapper.toPostEntity(request));
    }

    public List<PostResponse> getAllPosts( UUID id ) {
        return postRepository.getAllPost(id)
                .stream()
                .map(postMapper::toPostResponse)
                .toList();
    }

    public void deleteByid(UUID id) {
        postRepository.deleteById(id);
    }

    public void update(PostRequest request) {
        postRepository.update(postMapper.toPostEntity(request));
    }

    public List<PostResponse> get() {
        Status st = Status.ACTIVE;
        return postRepository.get(st);
    }


//
//    public void update(PostUpdateRequest request) {
//        PostEntity ps = postMapper.to
//        postRepository
//    }
}
