package kpfu.itis.sem.service;


import kpfu.itis.sem.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface UserService {

    void signUp(String login, String password);

    UserEntity getUserById(UUID id);

    Optional<UserEntity> findUserByName(String login);

}
