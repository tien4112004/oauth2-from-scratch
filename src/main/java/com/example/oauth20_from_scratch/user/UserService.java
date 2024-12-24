package com.example.oauth20_from_scratch.user;

import com.example.oauth20_from_scratch.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var addedUser = userRepository.save(user);
        return addedUser;
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}