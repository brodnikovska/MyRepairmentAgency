package com.example.myrepairmentagency.dto;

import com.example.myrepairmentagency.entity.RoleType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private RoleType role;
    private double balance;
}
