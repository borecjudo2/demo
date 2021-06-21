package com.example.demo.service.impl;

import com.example.demo.entity.ParticipantRole;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.ParticipantRoleRepository;
import com.example.demo.service.ParticipantRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplParticipantRoleService implements ParticipantRoleService {

    @Autowired
    private ParticipantRoleRepository participantRoleRepository;

    @Override
    public ParticipantRole getByRole(String role) {
        return participantRoleRepository.findByRoleValueIgnoreCase(role)
                .orElseThrow(() -> new BadRequestException("ParticipantRole with role = " + role + " not found"));
    }
}
