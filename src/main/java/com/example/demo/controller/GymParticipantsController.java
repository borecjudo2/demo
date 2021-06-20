package com.example.demo.controller;

import com.example.demo.converter.ParticipantConverter;
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
    private ParticipantConverter participantConverter;

    @ResponseBody
    @GetMapping
    public List<ParticipantDTO> getAllParticipants(){
        List<Participant> participants = participantService.getAll();
        return participants.stream()
                .map(participantConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ParticipantDTO getParticipantById(@PathVariable Long id){
        Participant participant = participantService.getById(id);
        return participantConverter.convertToDto(participant);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping
    public ParticipantDTO createParticipant(@RequestBody ParticipantDTO participantDTO){
        Participant participant = participantConverter.convertToEntity(participantDTO);
        Participant participantCreated = participantService.add(participant);
        return participantConverter.convertToDto(participantCreated);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public ParticipantDTO updateParticipant(@RequestBody ParticipantDTO participantDTO, @PathVariable Long id){
        Participant participant = participantService.getById(id);
        Participant newParticipant = participantConverter.updateParticipant(participant, participantDTO);
        Participant participantCreated = participantService.update(newParticipant);
        return participantConverter.convertToDto(participantCreated);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id){
        participantService.delete(id);
    }

}
