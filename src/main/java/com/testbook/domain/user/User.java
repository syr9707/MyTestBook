package com.testbook.domain.user;

import com.testbook.domain.BaseTimeEntity;
import com.testbook.domain.comments.Comments;
import com.testbook.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Column(nullable = false, length = 30, unique = true)
    private String username; // 아이디

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Posts> postsList;

    @OneToMany(mappedBy = "user")
    private List<Comments> commentsList;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String username, String email, String password, Role role, String nickname) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role.ADMIN;
        this.nickname = nickname;
    }

    // 회원 정보 수정
    public void update(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public String getRoleValue() {
        return this.role.getValue();
    }

}
