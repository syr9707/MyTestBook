package com.testbook.domain.user;

import com.testbook.domain.BaseTimeEntity;
import com.testbook.domain.comments.Comments;
import com.testbook.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Posts> postsList;

    @OneToMany(mappedBy = "user")
    private List<Comments> commentsList;

    @Builder
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
