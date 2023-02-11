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
    @Column(name = "user_id")
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

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role.ADMIN;
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
