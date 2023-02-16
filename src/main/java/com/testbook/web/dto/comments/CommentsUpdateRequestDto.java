package com.testbook.web.dto.comments;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsUpdateRequestDto {

    private String comment;

    @Builder
    public CommentsUpdateRequestDto(String comment) {
        this.comment = comment;
    }

}
