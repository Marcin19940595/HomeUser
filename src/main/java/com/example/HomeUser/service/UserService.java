
package com.example.HomeUser.service;

import com.example.HomeUser.controller.dto.UserRegistrationDto;
import com.example.HomeUser.model.User;
import com.example.HomeUser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    public void saveUsers(User user) {
        userRepository.save(user);
    }

    public boolean delete(Long id) {
        userRepository.deleteById(id);
        return Boolean.parseBoolean(null);
    }

    public User save(UserRegistrationDto registrationDto) {
        return null;
    }

    public abstract UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public abstract User getUserByName(String name);

    public abstract User getUserByEmail(String email);
}