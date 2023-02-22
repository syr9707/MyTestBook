package com.testbook.web;

import com.testbook.service.comments.CommentsService;
import com.testbook.service.user.UserService;
import com.testbook.web.dto.comments.CommentsSaveRequestDto;
import com.testbook.web.dto.comments.CommentsUpdateRequestDto;
import com.testbook.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentsApiController {

    private final CommentsService commentsService;

    @PostMapping("/api/v1/posts/{postId}/comments/{userId}")
    public Long save(@RequestBody CommentsSaveRequestDto commentsSaveRequestDto,
                     @PathVariable("postId") Long postId,
                     @PathVariable("userId") Long userId) {

        return commentsService.save(commentsSaveRequestDto, userId, postId);
    }

//    @PutMapping("/api/v1/posts/{postId}/comments/{userId}")
//    public Long update(@RequestBody CommentsUpdateRequestDto commentsUpdateRequestDto,
//                       @PathVariable("postId") Long postId,
//                       @PathVariable("userId") Long userId) {
//
//
//    }

}
