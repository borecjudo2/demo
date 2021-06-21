package com.example.demo.dto;

import com.example.demo.entity.ParticipantRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class ParticipantDTO {

    @JsonIgnore
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Null(message = "id must be null")
    private Long id;

    @NotBlank(message = "name must be not null")
    private String name;

    @NotBlank(message = "lastName must be not null")
    private String lastName;

    @NotBlank(message = "role must be not null")
    private String role;

    @NotBlank(message = "birthdayDate must be not null")
    private String birthdayDate;

    @NotBlank(message = "subscriptionFromDate must be not null")
    private String subscriptionFromDate;

    @NotBlank(message = "subscriptionToDate must be not null")
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
