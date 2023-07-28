package com.springboot.demo.myapp.config;

import com.springboot.demo.myapp.common.coaches.Coach;
import com.springboot.demo.myapp.common.coaches.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
