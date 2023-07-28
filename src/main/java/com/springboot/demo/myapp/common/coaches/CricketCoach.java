package com.springboot.demo.myapp.common.coaches;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 minutes";
    }
}
