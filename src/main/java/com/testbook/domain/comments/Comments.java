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
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    private String author; // 댓글 작성자

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 댓글 작성자

    @Builder
    public Comments(String comment, String author) {
        this.comment = comment;
        this.author = author;
    }

    public void update(String comment) {
        this.comment = comment;
    }

}
