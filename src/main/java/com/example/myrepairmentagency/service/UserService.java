package com.example.myrepairmentagency.service;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.dto.UsersDTO;
import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.repository.UsersRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService{
    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsers() {
        //TODO checking for an empty user list
        return usersRepository.findAll();
    }

    public Optional<User> findByUserLogin(UserDTO userDTO) {
        //TODO check for user availability. password check
        return usersRepository.findByEmail(userDTO.getEmail());
    }

    public Optional<User> findByUserId(Long id) {
        //TODO check for user availability. password check
        return usersRepository.findById(id);
    }

    public void saveNewUser(User user) {
        //TODO inform the user about the replay email
        // TODO exception to endpoint
        try {
            usersRepository.save(user);
        } catch (Exception ex){
            log.info("{Почтовый адрес уже существует}");
        }
    }

}
