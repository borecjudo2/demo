package com.example.demo.configuration;

import com.example.demo.service.ParticipantRoleService;
import com.example.demo.service.ParticipantService;
import com.example.demo.service.impl.ImplParticipantRoleService;
import com.example.demo.service.impl.ImplParticipantService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ParticipantService participantService(){
        return new ImplParticipantService();
    }

    @Bean
    public ParticipantRoleService participantRoleService(){
        return new ImplParticipantRoleService();
    }
}
