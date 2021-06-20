package com.example.demo.converter;

import com.example.demo.dto.ParticipantDTO;
import com.example.demo.entity.Participant;
import com.example.demo.repository.ParticipantRepository;
import com.example.demo.repository.ParticipantRoleRepository;
import com.example.demo.service.ParticipantRoleService;
import com.example.demo.service.ParticipantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterParticipant {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private ParticipantRoleService participantRoleService;

    public ParticipantDTO convertToDto(Participant participant) {
        return modelMapper.map(participant, ParticipantDTO.class);
    }

    public Participant convertToEntity(ParticipantDTO participantDTO) {
        Participant participant = modelMapper.map(participantDTO, Participant.class);
        participant.setRoleValue(participantRoleService.getByRole(participantDTO.getRole()));
        if (participant.getId() != null) {
            Participant oldParticipant = participantService.getById(participant.getId());
            participant.setName(oldParticipant.getName());
            participant.setLastName(oldParticipant.getLastName());
            participant.setBirthday(oldParticipant.getBirthday());
            participant.setRoleValue(oldParticipant.getRoleValue());
            participant.setSubscriptionFrom(oldParticipant.getSubscriptionFrom());
            participant.setSubscriptionTo(oldParticipant.getSubscriptionTo());
        }
        return participant;
    }

}
