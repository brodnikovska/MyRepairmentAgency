package com.example.myrepairmentagency;

import com.example.myrepairmentagency.repository.UsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
public class MyRepairmentAgencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyRepairmentAgencyApplication.class, args);
    }

}
