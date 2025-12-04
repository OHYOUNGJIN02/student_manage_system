package com.korit.student_manage_system.repository;

import com.korit.student_manage_system.entity.User;
import com.korit.student_manage_system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class UserRepository {
    @Autowired
    UserMapper userMapper;

    public Optional<User> getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
    public Optional<User> addUser(User user) {
        try {
            userMapper.addUser(user);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
        return Optional.of(user);
    }
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public Optional<User> removeUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }


    public Optional<User> getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }


    public int modifyPassword(Integer userId, String newPassword) {
        return userMapper.changePassword(userId, newPassword);
    }

    public int removeStudent(Integer userId) {
        return userMapper.removeStudent(userId);
    }
}
