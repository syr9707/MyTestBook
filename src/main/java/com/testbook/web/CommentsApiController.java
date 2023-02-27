package com.testbook.web;

import com.testbook.service.comments.CommentsService;
import com.testbook.service.user.UserService;
import com.testbook.web.dto.comments.CommentsListResponseDto;
import com.testbook.web.dto.comments.CommentsResponseDto;
import com.testbook.web.dto.comments.CommentsSaveRequestDto;
import com.testbook.web.dto.comments.CommentsUpdateRequestDto;
import com.testbook.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentsApiController {

    private final CommentsService commentsService;

    @PostMapping("/api/v1/posts/{postId}/comments")
    public Long save(@RequestBody CommentsSaveRequestDto commentsSaveRequestDto,
                     @PathVariable("postId") Long postId) {

        return commentsService.save(commentsSaveRequestDto,  postId);
    }

    @PutMapping("/api/v1/posts/{postId}/comments/{commentId}")
    public Long update(@PathVariable("postId") Long postId,
                       @PathVariable("commentId") Long commentId,
                       @RequestBody CommentsUpdateRequestDto dto) {

        return commentsService.update(postId, dto, commentId);
    }

    /* 댓글 보기 */
    @GetMapping("/api/v1/posts/{postId}/comments/{commentId}")
    public CommentsResponseDto findById(@PathVariable("postId") Long postId,
                                        @PathVariable("commentId") Long commentId) {

        return commentsService.findById(postId, commentId);
    }

    /* 댓글 삭제 */
    @DeleteMapping("/api/v1/posts/{postId}/comments/{commentId}")
    public Long delete(@PathVariable("postId") Long postId,
                       @PathVariable("commentId") Long commentId) {

        commentsService.delete(postId, commentId);

        return commentId;
    }

        /* 게시물 댓글 리스트 보기 */
//    @GetMapping("/api/v1/posts/{postId}/comments")
//    public List<CommentsListResponseDto> findAllComment() {
//
//    }

}
