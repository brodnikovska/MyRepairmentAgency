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

//@Data
//public class UserDTO {
//    @NotNull
//    @Size(min = 1, message = "messages")
//    private String username;
//    @NotNull
//    @Size(min = 1, message = "messages")
//    private String firstName;
//    @NotNull
//    @Size(min = 1, message = "messages")
//    private String lastName;
//    @NotNull
//    @Size(min = 1, message = "messages")
//    @Email
//    private String email;
//    @NotNull
//    @Size(min = 1, message = "messages")
//    // custom password validation @
//    private String password;
//    // confirm password
//    @NotNull
//    private RoleType role;
//    @NotNull
//    @Size(min = 1, message = "messages")
//    private BigDecimal balance;
//}
}
