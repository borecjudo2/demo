package com.example.demo.serializer;

import com.example.demo.converter.ParticipantRoleConverter;
import com.example.demo.dto.ParticipantRoleDTO;
import com.example.demo.entity.ParticipantRole;
import com.example.demo.service.ParticipantRoleService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class ParticipantRoleDTODeserializer extends StdDeserializer<ParticipantRoleDTO> {

    @Autowired
    private ParticipantRoleService participantRoleService;

    @Autowired
    private ParticipantRoleConverter participantRoleConverter;

    public ParticipantRoleDTODeserializer() {
        this(null);
    }

    protected ParticipantRoleDTODeserializer(Class<ParticipantRoleDTO> t) {
        super(t);
    }

    @Override
    public ParticipantRoleDTO deserialize(JsonParser jsonParser,
                                          DeserializationContext deserializationContext) throws IOException {
        String roleStr = jsonParser.getText();
        if(Objects.nonNull(roleStr)){
            ParticipantRole participantRole = participantRoleService.getByRole(roleStr);
            return participantRoleConverter.convertToDTO(participantRole);
        }
        return new ParticipantRoleDTO();
    }
}
