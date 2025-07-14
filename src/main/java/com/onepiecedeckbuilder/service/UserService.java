package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.User;
import com.onepiecedeckbuilder.entity.UserEntity;
import com.onepiecedeckbuilder.mapper.UserMapper;
import com.onepiecedeckbuilder.repository.UserRepository;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public User saveUserIfNotExists(User user) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(
            user.getMail()
        );
        return userMapper.toDto(
            optionalUserEntity.orElseGet(() -> {
                user.setCreationDate(LocalDate.now(ZoneOffset.UTC));
                return userRepository.saveAndFlush(userMapper.toEntity(user));
            })
        );
    }

    public User getConnectedUser() {
        String connectedMail = SecurityContextHolder.getContext()
            .getAuthentication()
            .getName();
        if (connectedMail.equals("anonymousUser")) {
            return null;
        }
        return User.builder().mail(connectedMail).build();
    }
}
