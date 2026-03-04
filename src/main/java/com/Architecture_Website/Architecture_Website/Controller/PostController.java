package com.Architecture_Website.Architecture_Website.Controller;

import com.Architecture_Website.Architecture_Website.Request.PostRequest;
import com.Architecture_Website.Architecture_Website.Response.PostResponse;
import com.Architecture_Website.Architecture_Website.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(
            @RequestBody PostRequest postRequest
    ){
        postService.save(postRequest);
        return ResponseEntity.ok().build();
    }

    // use for ADMIN
    @GetMapping("/{id}")
    public List<PostResponse> getAllPosts(
            @PathVariable UUID id
    ){
        return postService.getAllPosts(id);
    }

    // use for CUSTOMER
    @GetMapping()
    public List<PostResponse> getPostForUser(){
        return postService.get();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePost(@PathVariable UUID id){
        postService.deleteByid(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> updatePost(
        @RequestBody PostRequest request
    ) {
        postService.update(request);
        return ResponseEntity.ok().build();
    }

}
