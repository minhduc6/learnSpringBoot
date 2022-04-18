package com.example.userservice;

import com.example.userservice.model.Role;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return  args -> {
            userService.save(new Role(null,"ROLE_USER"));
            userService.save(new Role(null,"ROLE_MANAGER"));
            userService.save(new Role(null,"ROLE_ADMIN"));
            userService.save(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"RONALDO","RONALDO","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"MESSI","MESSI","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"POGBA","POGBA","1234",new ArrayList<>()));

            userService.addRoleToUser("RONALDO","ROLE_USER");
            userService.addRoleToUser("RONALDO" , "ROLE_MANAGER");
            userService.addRoleToUser("MESSI" , "ROLE_ADMIN");
            userService.addRoleToUser("POGBA","ROLE_USER");

        };
    }

}
