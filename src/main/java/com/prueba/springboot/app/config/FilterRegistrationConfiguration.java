package com.prueba.springboot.app.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class FilterRegistrationConfiguration {

    @Bean
    public FilterRegistrationBean jwtFilter()
    {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter() );
        registrationBean.addUrlPatterns( "/api/*" );

        return registrationBean;
    }

}