package com.Architecture_Website.Architecture_Website.Mapper;

import com.Architecture_Website.Architecture_Website.Model.PostEntity;
import com.Architecture_Website.Architecture_Website.Repository.AccountRepository;
import com.Architecture_Website.Architecture_Website.Repository.PostRepository;
import com.Architecture_Website.Architecture_Website.Request.PostRequest;
import com.Architecture_Website.Architecture_Website.Response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostMapper {
    private final AccountRepository accountRepository;

    public PostResponse toPostResponse(PostEntity postEntity) {
        return PostResponse.builder()
                .title(postEntity.getTitle())
                .viewQuantity(postEntity.getViewQuantity())
                .titleImage(postEntity.getTitleImage())
                .content(postEntity.getContent())
                .status(postEntity.getStatus())
                .description(postEntity.getDescription())
                .slug(postEntity.getSlug())
                .build();
    }

    public PostEntity toPostEntity(PostRequest request) {
        return PostEntity.builder()
                .id(request.id())
                .title(request.title())
                .viewQuantity(request.viewQuantity())
                .titleImage(request.titleImage())
                .content(request.content())
                .status(request.status())
                .description(request.description())
                .slug(request.slug())
                .description(request.description())
                .account(accountRepository.getReferenceById(request.accountId()))
                .build();
    }
}
