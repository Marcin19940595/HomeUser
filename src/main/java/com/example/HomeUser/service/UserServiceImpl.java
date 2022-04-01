package com.example.HomeUser.service;

import com.example.HomeUser.controller.dto.UserRegistrationDto;
import com.example.HomeUser.model.Role;
import com.example.HomeUser.model.User;
import com.example.HomeUser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;

@Service
public class UserServiceImpl extends UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save (UserRegistrationDto userRegistrationDto){
        User user = new User(userRegistrationDto.getName(),
                userRegistrationDto.getEmail(),
                passwordEncoder.encode(userRegistrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
        userRepository.save(user);
        return user;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
        }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()) ;
    }
    public void updateUser(User user){
        userRepository.deleteById(user.getId());
        userRepository.save(user);
    }
    @Override
    public User getUserByName(String name){
        User user;
        user = userRepository.findByName(name);
        return user;
    }
    @Override
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}