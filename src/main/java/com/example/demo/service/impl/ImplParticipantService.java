package com.example.demo.service.impl;

import com.example.demo.entity.Participant;
import com.example.demo.repository.ParticipantRepository;
import com.example.demo.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplParticipantService implements ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public Participant getById(Long id) {
        return participantRepository.getById(id);
    }

    @Override
    public List<Participant> getAll() {
        return participantRepository.findAll();
    }

    @Override
    public Participant add(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public Participant update(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public void delete(Long id) {
        Participant participant = participantRepository.getById(id);
        participantRepository.delete(participant);
    }

}
