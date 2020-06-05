package com.lgomezs.cqrs.appcqrsevents.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Beneficiary {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String type;
    private String number;

    public Beneficiary(){

    }

    public Beneficiary(String id, String firstName, String lastName, String type, String number ) {
        this.id=id;
        this.firstName= firstName;
        this.lastName=lastName;
        this.number=number;
        this.type=type;
    }
}
