package com.example.myrepairmentagency.utils;

import com.example.myrepairmentagency.annotation.ValidPassword;
import com.example.myrepairmentagency.entity.RoleType;
import com.example.myrepairmentagency.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

@Data
public class MyUserPrincipal implements UserDetails {
    private User user;

    @Autowired
    public MyUserPrincipal(User user) {
        this.user = user;
    }

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

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
