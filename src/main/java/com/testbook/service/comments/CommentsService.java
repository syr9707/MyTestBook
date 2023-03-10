package com.testbook.service.comments;

import com.testbook.domain.comments.Comments;
import com.testbook.domain.comments.CommentsRepository;
import com.testbook.domain.posts.Posts;
import com.testbook.domain.posts.PostsRepository;
import com.testbook.domain.user.User;
import com.testbook.domain.user.UserRepository;
import com.testbook.web.dto.comments.CommentsListResponseDto;
import com.testbook.web.dto.comments.CommentsResponseDto;
import com.testbook.web.dto.comments.CommentsSaveRequestDto;
import com.testbook.web.dto.comments.CommentsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentsService {

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Long save(CommentsSaveRequestDto commentsSaveRequestDto, Long postId) {
        // 엔티티 조회
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("해당 회원 없습니다. userId = " + userId));

        Posts posts = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. postId = " + postId));

//        commentsSaveRequestDto.setUser(user);
        commentsSaveRequestDto.setPosts(posts);

        Comments comments = commentsSaveRequestDto.toEntity();
        commentsRepository.save(comments);

        return comments.getId();
    }

    @Transactional
    public Long update(Long postId, CommentsUpdateRequestDto commentsUpdateRequestDto, Long commentId) {
        Posts posts = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. postId = " + postId));

        Comments comments = commentsRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id = " + commentId));

        comments.update(commentsUpdateRequestDto.getComment());

        return commentId;
    }

    @Transactional
    public CommentsResponseDto findById(Long postId, Long commentId) {
        Posts posts = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. postId = " + postId));

        Comments entity = commentsRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id = " + commentId));

        return new CommentsResponseDto(entity);
    }

    @Transactional
    public void delete(Long postId, Long commentId) {
        Posts posts = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. postId = " + postId));

        Comments comments = commentsRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id = " + commentId));

        commentsRepository.delete(comments);
    }

    @Transactional(readOnly = true)
    public List<CommentsListResponseDto> findAll() {
        return commentsRepository.findAll().stream()
                .map(CommentsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
