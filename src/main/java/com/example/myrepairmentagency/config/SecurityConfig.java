package com.example.myrepairmentagency.config;

import com.example.myrepairmentagency.entity.RoleType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
                .antMatchers(HttpMethod.GET,"/admin-panel/**").hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.POST,"/admin-panel/**").hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.GET,"/users/**").hasRole(RoleType.USER.name())
                .antMatchers(HttpMethod.POST,"/users/**").hasRole(RoleType.USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
        ;

    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles(RoleType.ADMIN.toString())
                        .build(),

                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("user"))
                        .roles(RoleType.USER.name())
                        .build()
        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

//    @Autowired
//    public void configureGlobal(AuthentificationManageBuilder auth) throws Exception {
//        auth.userDetailsService
//    }
}