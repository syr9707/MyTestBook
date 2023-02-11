package com.testbook.web;

import com.testbook.domain.user.UserRepository;
import com.testbook.service.user.UserService;
import com.testbook.web.dto.user.UserListResponseDto;
import com.testbook.web.dto.user.UserResponseDto;
import com.testbook.web.dto.user.UserSaveRequestDto;
import com.testbook.web.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto userSaveRequestDto) {

        return userService.save(userSaveRequestDto);
    }

    @PutMapping("/api/v1/user/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserUpdateRequestDto userUpdateRequestDto) {

        return userService.update(id, userUpdateRequestDto);
    }

    // 단일 회원 정보 조회 (마이페이지)
    @GetMapping("/api/v1/user/{id}")
    public UserResponseDto findById(@PathVariable Long id) {

        return userService.findById(id);
    }

    @DeleteMapping("/api/v1/user/{id}")
    public Long delete(@PathVariable Long id) {
        userService.delete(id);

        return id;
    }

    // 회원 정보 전체 조회 (관리자 페이지)
    @GetMapping("/api/v1/user/all")
    public List<UserListResponseDto> userList() {

        return userService.findAll();
    }

}
