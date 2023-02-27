package com.testbook.web.dto.posts;

import com.testbook.domain.posts.Posts;
import com.testbook.web.dto.comments.CommentsListResponseDto;
import com.testbook.web.dto.comments.CommentsResponseDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    private List<CommentsListResponseDto> comments;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.comments = entity.getCommentsList().stream()
                .map(CommentsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
