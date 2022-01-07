package com.xzh.encryption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootPasswordEncryptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPasswordEncryptionApplication.class, args);
    }

    @GetMapping("/login")
    public String login(String password){
        return password;
    }
}
