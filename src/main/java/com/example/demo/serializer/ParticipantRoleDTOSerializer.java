package com.example.demo.serializer;

import com.example.demo.dto.ParticipantRoleDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Objects;

public class ParticipantRoleDTOSerializer extends StdSerializer<ParticipantRoleDTO> {

    public ParticipantRoleDTOSerializer() {
        this(null);
    }

    protected ParticipantRoleDTOSerializer(Class<ParticipantRoleDTO> t) {
        super(t);
    }

    @Override
    public void serialize(ParticipantRoleDTO participantRoleDTO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(Objects.nonNull(participantRoleDTO)){
            jsonGenerator.writeString(participantRoleDTO.getRoleValue());
        }
    }
}
