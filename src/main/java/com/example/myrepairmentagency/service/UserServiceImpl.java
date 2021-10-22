package com.example.myrepairmentagency.service;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UsersService {
    final UsersRepository userRepository;
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public void registerUser(UserDTO userDTO) {

    }

    @Override
    public User findUserById(Long id) {
        for(User user:getAllUsers()){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        for(User user:getAllUsers()){
            if(user.getEmail() == email){
                return user;
            }
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        int index = getAllUsers().indexOf(user);
        getAllUsers(). add(index,user);
    }

    @Override
    public void deleteUserById(Long id) {
        Iterator<User> iterator = getAllUsers().iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
            }
        }

    }
}
