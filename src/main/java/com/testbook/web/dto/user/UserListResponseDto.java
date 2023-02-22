package com.testbook.web.dto.user;

import com.testbook.domain.user.User;
import lombok.Getter;

@Getter
public class UserListResponseDto {

    private Long id;
    private String username;
    private String email;
    private String password;

    public UserListResponseDto(User entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
    }

}
