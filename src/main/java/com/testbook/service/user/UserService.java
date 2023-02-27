package com.testbook.service.user;

import com.testbook.domain.user.User;
import com.testbook.domain.user.UserRepository;
import com.testbook.web.dto.user.UserListResponseDto;
import com.testbook.web.dto.user.UserResponseDto;
import com.testbook.web.dto.user.UserSaveRequestDto;
import com.testbook.web.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto userSaveRequestDto) {

        return userRepository.save(userSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id = " + id));

        user.update(userUpdateRequestDto.getName(), userUpdateRequestDto.getEmail());

        return id;
    }

    @Transactional
    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id = " + id));

        return new UserResponseDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id = " + id));

        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
    public List<UserListResponseDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserListResponseDto::new)
                .collect(Collectors.toList());
    }
}
