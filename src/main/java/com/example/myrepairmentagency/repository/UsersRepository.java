package com.example.myrepairmentagency.repository;

import com.example.myrepairmentagency.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

//    @Query("SELECT user FROM User user WHERE user.username = ?1")
//    Optional<User> findByUsername(@NonNull String username);

    @Query("UPDATE User user SET user.balance = ?1 where user.email = ?2")
    @Modifying
    void updateBalance(Double balance, String email);

    User findByUsername(String username);

}
