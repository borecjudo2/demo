package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ParticipantRoleEnum {

    COACH(1L),
    ATHLETE(2L);

    private Long id;
}
