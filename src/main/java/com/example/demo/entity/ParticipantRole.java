package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "PARTICIPANT_ROLE")
@Entity
public class ParticipantRole {

    @Id
    private Long id;

    @Column(name = "ROLE_VALUE", unique = true, nullable = false)
    private String roleValue;

}