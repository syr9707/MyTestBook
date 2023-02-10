package com.testbook.web;

import com.testbook.service.posts.PostsService;
import com.testbook.web.dto.PostsResponseDto;
import com.testbook.web.dto.PostsSaveRequestDto;
import com.testbook.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // 1
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto postsSaveRequestDto) {  // 2

        return postsService.save(postsSaveRequestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto) {

        return postsService.update(id, postsUpdateRequestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {

        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);

        return id;
    }

}
