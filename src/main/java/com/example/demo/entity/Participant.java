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

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private ParticipantRole roleValue;

    @Column(name = "BIRTHDAY", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "SUBSCRIPTION_FROM", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date subscriptionFrom;

    @Column(name = "SUBSCRIPTION_TO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date subscriptionTo;

}