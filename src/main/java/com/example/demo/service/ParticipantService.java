package com.example.demo.service;

import com.example.demo.entity.Participant;

import java.util.List;

public interface ParticipantService {

    Participant getById(Long id);

    List<Participant> getAll();

    Participant add(Participant participant);

    Participant update(Participant participant);

    void delete(Long id);

}
