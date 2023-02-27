package com.testbook.web.dto.comments;

import com.testbook.domain.comments.Comments;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentsListResponseDto {

    private Long id;
//    private Long userId;
    private Long postsId;
    private String comment;
    private LocalDateTime modifiedDate;

    public CommentsListResponseDto(Comments entity) {
        this.id = entity.getId();
//        this.userId = entity.getUser().getId();
        this.postsId = entity.getPosts().getId();
        this.comment = entity.getComment();
        this.modifiedDate = entity.getModifiedDate();
    }

}
