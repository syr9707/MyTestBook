package com.testbook.service.user;

import com.testbook.domain.user.UserRepository;
import com.testbook.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto userSaveRequestDto) {

        return userRepository.save(userSaveRequestDto.toEntity()).getId();
    }

}
