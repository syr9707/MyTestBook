package com.testbook.web.dto.comments;

import com.testbook.domain.comments.Comments;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentsResponseDto {

    private Long id;
    private Long userId;
    private Long postsId;
    private String comment;

    public CommentsResponseDto(Comments entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.postsId = entity.getPosts().getId();
        this.comment = entity.getComment();
    }

}
