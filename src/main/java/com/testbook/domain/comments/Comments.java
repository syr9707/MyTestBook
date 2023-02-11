package com.testbook.domain.comments;

import com.testbook.domain.BaseTimeEntity;
import com.testbook.domain.posts.Posts;
import com.testbook.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_id")
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;


    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 댓글 작성자

//    private String author = user.getName(); // 댓글 작성자

    @Builder
    public Comments(String comment, User user, Posts posts) {
        this.comment = comment;
        this.user = user;
        this.posts = posts;
    }

    public void update(String comment) {
        this.comment = comment;
    }

}
