package com.example.myrepairmentagency.entity;


import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "user",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    @NotEmpty(message = "Username should not be empty")
    @Size(min = 2, max = 30, message = "Username should be between 2 and 30 characters")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 30, message = "Surname should be between 2 and 30 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "Email should not be empty")
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Override
    public Collection<RoleType> getAuthorities() {
        return Arrays.asList(RoleType.values());
    }

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//@Data
//@Entity
//@Table(name = "users")
//public class User implements UserDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(unique = true, nullable = false)
//    private Long id;
//    private String username;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String password;
//    @Enumerated(EnumType.STRING)
//    private RoleType role;
//    private BigDecimal balance;
//    @Override
//    public Collection<RoleType> getAuthorities() {
//        return Arrays.asList(RoleType.values());
//    }
//    private boolean accountNonExpired;
//    private boolean accountNonLocked;
//    private boolean credentialsNonExpired;
//    private boolean enabled;
//}
}