package com.prueba.springboot.app.config;

import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordEncryptorConfiguration {

    @Bean
    public PasswordEncryptor passwordEncryptor() {
        return new StrongPasswordEncryptor();
    }

}