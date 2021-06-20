package com.example.demo.converter;

import com.example.demo.dto.ParticipantRoleDTO;
import com.example.demo.entity.ParticipantRole;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParticipantRoleConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ParticipantRoleDTO convertToDTO(ParticipantRole participantRole){
        return modelMapper.map(participantRole, ParticipantRoleDTO.class);
    }

}
