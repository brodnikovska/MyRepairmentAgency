package com.example.myrepairmentagency.entity;

import com.example.myrepairmentagency.annotation.ValidPassword;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
@Table(name="userslist",
        uniqueConstraints={@UniqueConstraint(columnNames={"email", "username"})})
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private BigDecimal balance;

    @Override
    public Collection<RoleType> getAuthorities() {
        return Arrays.asList(RoleType.values());
    }

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
