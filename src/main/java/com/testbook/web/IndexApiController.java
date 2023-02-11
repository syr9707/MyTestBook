package com.testbook.web;

import com.testbook.service.posts.PostsService;
import com.testbook.web.dto.posts.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public List<PostsListResponseDto> index() {

        return postsService.findAllDesc();
    }

}
