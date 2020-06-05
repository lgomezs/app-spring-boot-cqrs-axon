package com.lgomezs.cqrs.appcqrsevents.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeneficiaryDTO {
    private String firstName;
    private String lastName;
    private Document document;

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
