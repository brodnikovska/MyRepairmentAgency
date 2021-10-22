package com.example.myrepairmentagency.service;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.entity.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
    void registerUser(UserDTO userDTO);
    void createUser(User user);
    void update(User user);
    User findUserById(Long id);
    void deleteUserById(Long id);
    User findUserByEmail(String email);
}
