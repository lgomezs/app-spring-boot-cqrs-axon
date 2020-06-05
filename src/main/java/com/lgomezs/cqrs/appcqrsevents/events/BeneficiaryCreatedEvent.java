package com.lgomezs.cqrs.appcqrsevents.events;

import com.lgomezs.cqrs.appcqrsevents.commands.CreateBeneficiaryCommand;
import com.lgomezs.cqrs.appcqrsevents.events.base.BaseEvent;
import lombok.Getter;

@Getter
public class BeneficiaryCreatedEvent extends BaseEvent<String> {
    private String firstName;
    private String lastName;
    private CreateBeneficiaryCommand.Document document;

    public BeneficiaryCreatedEvent(String id, String firstName, String lastName, CreateBeneficiaryCommand.Document document) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
    }
}
