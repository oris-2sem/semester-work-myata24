package kpfu.itis.sem.security.details;

import kpfu.itis.sem.entity.UserEntity;
import kpfu.itis.sem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("customUserDetailsService")
@RequiredArgsConstructor
public class BaseUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        return new BaseUserDetails(user);
    }
}
