package com.example.myrepairmentagency.config;

import com.example.myrepairmentagency.entity.RoleType;
import com.example.myrepairmentagency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

//        @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/registration/**", "/js/**", "/css/**").permitAll()
                .antMatchers("/admin-panel/**").hasAuthority(RoleType.ADMIN.name())
                .antMatchers("/users/**").hasAnyAuthority(RoleType.ADMIN.name(), RoleType.USER.name())
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}