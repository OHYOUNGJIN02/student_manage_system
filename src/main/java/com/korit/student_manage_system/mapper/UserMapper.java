package com.korit.student_manage_system.mapper;

import com.korit.student_manage_system.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper

public interface UserMapper {
    void addUser(User user);
    Optional<User> getUserByUsername(String username);
    Optional<User> signup(User user);
    List<User> getAllUsers();
    int removeStudent(Integer userId);
    int changePassword(Integer userId, String newPassword);
    Optional<User> getUserById(Integer userId);
}
