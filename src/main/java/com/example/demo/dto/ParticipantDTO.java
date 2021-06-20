package com.example.demo.dto;

import com.example.demo.entity.ParticipantRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class ParticipantDTO {

    @JsonIgnore
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private Long id;

    private String name;

    private String lastName;

    private String role;

    private String birthdayDate;

    private String subscriptionFromDate;

    private String subscriptionToDate;

    public void setRoleValue(ParticipantRole participantRole){
        this.role = participantRole.getRoleValue();
    }

    @JsonIgnore
    public Date getBirthday(){
        return toDate(this.birthdayDate);
    }

    @JsonIgnore
    public Date getSubscriptionFrom(){
        return toDate(this.subscriptionFromDate);
    }

    @JsonIgnore
    public Date getSubscriptionTo(){
        return toDate(this.subscriptionToDate);
    }

    public void setBirthday(Date date){
        this.birthdayDate = toStr(date);
    }

    public void setSubscriptionFrom(Date date){
        this.subscriptionFromDate = toStr(date);
    }

    public void setSubscriptionTo(Date date){
        this.subscriptionToDate = toStr(date);
    }

    private String toStr(Date date){
        return simpleDateFormat.format(date);
    }

    @SneakyThrows
    private Date toDate(String date){
        return simpleDateFormat.parse(date);
    }

}
