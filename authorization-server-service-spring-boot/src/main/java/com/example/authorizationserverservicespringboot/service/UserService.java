package com.example.authorizationserverservicespringboot.service;


import com.example.authorizationserverservicespringboot.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        return this.userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
                ()-> new RuntimeException("Username or Email not Found!")
        );
    }
}
