package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Table(name = "PARTICIPANT_ROLE")
@Entity
public class ParticipantRole {

    @Id
    private Long id;

    @Column(name = "ROLE_VALUE", nullable = false)
    private String roleValue;

}