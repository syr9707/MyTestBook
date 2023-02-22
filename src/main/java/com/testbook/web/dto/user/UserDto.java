package com.testbook.web.dto.user;

import com.testbook.domain.user.Role;
import com.testbook.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String username;
    private String password;
    private String nickname;
    private String email;
    private Role role;

    // DTO -> Entity
    public User toEntity() {
        User user = User.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .role(role.USER)
                .build();

        return user;
    }

}
