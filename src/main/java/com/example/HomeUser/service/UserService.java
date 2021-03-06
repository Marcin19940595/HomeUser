
package com.example.HomeUser.service;

import com.example.HomeUser.model.User;
import com.example.HomeUser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();

    }
    public void saveUsers(User user){
        userRepository.save(user);
    }

    public boolean delete(Long id) {
        userRepository.deleteById(id);
        return Boolean.parseBoolean(null);
    }
}