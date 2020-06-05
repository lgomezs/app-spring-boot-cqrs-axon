package com.lgomezs.cqrs.appcqrsevents.commands;

import com.lgomezs.cqrs.appcqrsevents.commands.base.BaseCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBeneficiaryCommand extends BaseCommand<String> {
    private String firstName;
    private String lastName;
    private Document document;

    public CreateBeneficiaryCommand(String id, String firstName, String lastName, Document document) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
    }

    @Getter
    @Setter
    public static class Document{
            private String type;
            private String number;

        public Document(String type, String number){
            this.type=type;
            this.number=number;
        }
    }
}
