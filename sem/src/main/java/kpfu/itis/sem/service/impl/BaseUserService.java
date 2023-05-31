package kpfu.itis.sem.service.impl;

import kpfu.itis.sem.entity.UserEntity;
import kpfu.itis.sem.repository.UserRepository;
import kpfu.itis.sem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class BaseUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void signUp(String login, String password) {
        UserEntity user = UserEntity.builder()
                .login(login)
                .hashPassword(passwordEncoder.encode(password))
                .role(UserEntity.Role.USER)
                .state(UserEntity.State.ACTIVE)
                .build();
            userRepository.save(user);
    }

    @Override
    public UserEntity getUserById(UUID id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public Optional<UserEntity> findUserByName(String login) {
        return userRepository.findByLogin(login);
    }
}
