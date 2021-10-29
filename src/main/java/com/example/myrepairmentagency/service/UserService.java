package com.example.myrepairmentagency.service;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.entity.RoleType;
import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.repository.UsersRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService implements UserDetailsService {
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

    public Optional<User> findByUsername(UserDTO userDTO) {
        //TODO check for user availability. password check
        return usersRepository.findByUsername(userDTO.getUsername());
    }

    public void saveNewUser(User user) {
        //TODO inform the user about the replay email
        // TODO exception to endpoint
        try {
            user.setRole(RoleType.USER);
            usersRepository.save(user);
        } catch (Exception ex){
            log.info("{Почтовый адрес уже существует}");
        }
    }

    @ModelAttribute("id")
    public void updateBalance(User user, double sum) {
        user.setBalance(user.getBalance() + sum);
        usersRepository.save(user);
    }

    @Transactional
    @ModelAttribute("id")
    public void putMoney(User user, double sum) {
        double currentBalance = user.getBalance();
        currentBalance += sum;
        user.setBalance(currentBalance);
        usersRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        usersRepository.findByUsername(username);
        return User.builder()
                .username(username)
                .password(encoder.encode("password"))
                .role(RoleType.USER)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
    }

//    protected PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(12);
//    }
}
