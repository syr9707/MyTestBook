package com.testbook.service.posts;

import com.testbook.domain.posts.PostsRepository;
import com.testbook.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto) {

        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

}
