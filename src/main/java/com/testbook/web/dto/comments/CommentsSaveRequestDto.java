package com.testbook.web.dto.comments;

import com.testbook.domain.comments.Comments;
import com.testbook.domain.posts.Posts;
import com.testbook.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {

    private String comment;
    private User user;
    private Posts posts;

    @Builder
    public CommentsSaveRequestDto(String comment, User user, Posts posts) {
        this.comment = comment;
        this.user = user;
        this.posts = posts;
    }

    public Comments toEntity() {
        return Comments.builder()
                .comment(comment)
                .user(user)
                .posts(posts)
                .build();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

}
