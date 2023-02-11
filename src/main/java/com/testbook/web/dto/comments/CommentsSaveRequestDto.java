package com.testbook.web.dto.comments;

import com.testbook.domain.comments.Comments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {

    private String comments;
    private String name;

    @Builder
    public CommentsSaveRequestDto(String comments, String name) {
        this.comments = comments;
        this.name = name;
    }

    public Comments toEntity() {
        return Comments.builder()
                .comment(comments)
                .author(name)
                .build();
    }

}
