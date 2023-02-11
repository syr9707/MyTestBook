package com.testbook.web.dto.user;

import com.testbook.domain.user.User;
import lombok.Getter;

@Getter
public class UserListResponseDto {

    private Long id;
    private String name;
    private String email;
    private String password;

    public UserListResponseDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
    }

}
