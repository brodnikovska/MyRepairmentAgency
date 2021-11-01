package com.example.myrepairmentagency.service;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.entity.RoleType;
import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.passay.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
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

    @Transactional
    public void saveNewUser(User user) {
        //TODO inform the user about the replay email
        // TODO exception to endpoint
        try {
            user.setRoles(RoleType.USER.name());
            user.setBalance(BigDecimal.ZERO);
            usersRepository.save(user);
        } catch (Exception ex){
            log.info("{Почтовый адрес уже существует}");
        }
    }

//    @ModelAttribute("id")
//    public void updateBalance(User user, double sum) {
//        user.setBalance(user.getBalance() + sum);
//        usersRepository.save(user);
//    }

//    @Transactional
//    @ModelAttribute("id")
//    public void putMoney(User user, double sum) {
//        double currentBalance = user.getBalance();
//        currentBalance += sum;
//        user.setBalance(currentBalance);
//        usersRepository.save(user);
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return User.builder()
//                .username("user")
//                .password("user")
//                .role(RoleType.USER)
//                .build();
//    }

    //protected PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(12);
//    }

    public boolean passwordIsValid(String password) {
        List<Rule> rules = new ArrayList<>();
        //Rule 1: Password length should be in between
        //8 and 16 characters
        rules.add(new LengthRule(8, 16));
        //Rule 2: No whitespace allowed
        rules.add(new WhitespaceRule());
        //Rule 3.a: At least one Upper-case character
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
        //Rule 3.b: At least one Lower-case character
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
        //Rule 3.c: At least one digit
        rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        //Rule 3.d: At least one special character
        rules.add(new CharacterRule(EnglishCharacterData.Special, 1));
        PasswordValidator validator = new PasswordValidator(rules);
        PasswordData passwordData = new PasswordData(password);
        RuleResult result = validator.validate(passwordData);
        if(result.isValid()){
            return true;
        } else {
            return false;
        }
    }
}
