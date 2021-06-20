package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "PARTICIPANT")
@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PARTICIPANT")
    @SequenceGenerator(name="SEQ_PARTICIPANT", allocationSize=1)
    @Column(name="ID", unique=true, nullable=false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;
    
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    private ParticipantRole roleValue;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "SUBSCRIPTION_FROM")
    private Date subscriptionFrom;

    @Column(name = "SUBSCRIPTION_TO")
    private Date subscriptionTo;

}