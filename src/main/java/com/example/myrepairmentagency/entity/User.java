package com.example.myrepairmentagency.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="user",
        uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Surname should be between 2 and 30 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "Email should not be empty")
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Column(name = "balance", nullable = false)
    private double balance;
}
