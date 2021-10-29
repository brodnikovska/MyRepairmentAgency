package com.example.myrepairmentagency.dto;

import com.example.myrepairmentagency.annotation.ValidPassword;
import com.example.myrepairmentagency.entity.RoleType;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class UserDTO {
    @NotNull
    @Size(min = 1, message = "messages")
    private String username;
    @NotNull
    @Size(min = 1, message = "messages")
    private String firstName;
    @NotNull
    @Size(min = 1, message = "messages")
    private String lastName;
    @NotNull
    @Size(min = 1, message = "messages")
    @Email
    private String email;
    @NotNull
    @Size(min = 1, message = "messages")
    @ValidPassword
    private String password;
    @NotNull
    private RoleType role;
    @NotNull
    @Size(min = 1, message = "messages")
    private BigDecimal balance;
}
