package com.example.myrepairmentagency.entity;

import com.example.myrepairmentagency.annotation.ValidPassword;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name="userslist",
        uniqueConstraints={@UniqueConstraint(columnNames={"email", "username"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotEmpty(message = "Username should not be empty")
    @Size(min = 2, max = 30, message = "Username should be between 2 and 30 characters")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String firstName;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 30, message = "Surname should be between 2 and 30 characters")
    private String lastName;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @ValidPassword
    private String password;

    private String roles;
    private BigDecimal balance;
}
