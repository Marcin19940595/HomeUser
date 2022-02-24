package com.example.HomeUser.repository;

import com.example.HomeUser.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryRepository implements UserRepository {
    Map<String, User> users = new HashMap<>();

    @Override
    public void createuser(String name, String surname) {
        users.put(name,new User(name,surname));
    }

    @Override
    public Collection<User> getAllUsers() {
        return users.values();
    }

    @Override
    public User getUser(String name) {
        return users.get(name);
    }

    @Override
    public void removeUser(String name) {
        users.remove(name);
    }

    @Override
    public void build() {
        createuser("Marcin","Gruda");
    }

    @Override
    public void createuser(User user) {
        users.put(user.getName(),user);
    }

}
