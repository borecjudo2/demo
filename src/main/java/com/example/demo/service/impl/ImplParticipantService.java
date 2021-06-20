package com.example.demo.service.impl;

import com.example.demo.entity.Participant;
import com.example.demo.exception.BadRequestException;
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
        return participantRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Participant with id = " + id + " not found"));
    }

    @Override
    public List<Participant> getAll() {
        List<Participant> participants = participantRepository.findAll();
        if(participants.isEmpty()){
            throw new BadRequestException("Participants not found");
        }
        return participants;
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
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Participant with id = " + id + " not found"));
        participantRepository.delete(participant);
    }

}
