package com.example.demo.controller;

import com.example.demo.converter.ConverterParticipant;
import com.example.demo.dto.ParticipantDTO;
import com.example.demo.entity.Participant;
import com.example.demo.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/gym/participants")
public class GymParticipantsController {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private ConverterParticipant converterParticipant;

    @GetMapping
    public List<ParticipantDTO> getAllParticipants(){
        List<Participant> participants = participantService.getAll();
        return participants.stream()
                .map(converterParticipant::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ParticipantDTO getParticipantById(@PathVariable Long id){
        Participant participant = participantService.getById(id);
        return converterParticipant.convertToDto(participant);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping
    public ParticipantDTO createParticipant(@RequestBody ParticipantDTO participantDTO){
        Participant participant = converterParticipant.convertToEntity(participantDTO);
        Participant participantCreated = participantService.add(participant);
        return converterParticipant.convertToDto(participantCreated);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public ParticipantDTO updateParticipant(@RequestBody ParticipantDTO participantDTO, @PathVariable Long id){
        Participant participant = converterParticipant.convertToEntity(participantDTO);
        participant.setId(id);
        Participant participantCreated = participantService.update(participant);
        return converterParticipant.convertToDto(participantCreated);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id){
        participantService.delete(id);
    }

}
