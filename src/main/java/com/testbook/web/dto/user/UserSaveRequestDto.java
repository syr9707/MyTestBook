package com.testbook.web.dto.user;

import com.testbook.domain.user.Role;
import com.testbook.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String username;
    private String email;
    private String password;

    private Role role;

    @Builder
    public UserSaveRequestDto(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User toEntity() {
        return User.builder()
                .username(username)
                .email(email)
                .password(password)
                .role(role)
                .build();
    }

}
