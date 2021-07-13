package com.example.meetingroombooking.security;

import com.example.meetingroombooking.model.entity.User;
import com.example.meetingroombooking.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DataUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public DataUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("wrong_credentials"));

        return new DataUserDetails(user);
    }
}
