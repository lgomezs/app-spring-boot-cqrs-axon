package com.lgomezs.cqrs.appcqrsevents.aggregates;

import com.lgomezs.cqrs.appcqrsevents.commands.CreateBeneficiaryCommand;
import com.lgomezs.cqrs.appcqrsevents.events.BeneficiaryCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@Aggregate
public class BeneficiaryAggregate {

    @AggregateIdentifier
    private String id;
    private String firstName;
    private String lastName;
    private CreateBeneficiaryCommand.Document document;

    public BeneficiaryAggregate(){   }

    @CommandHandler
    public BeneficiaryAggregate(CreateBeneficiaryCommand   createBeneficiaryCommand){
        log.info("##### @CommandHandler: Inicio BeneficiaryAggregate ######");
        AggregateLifecycle.apply(new BeneficiaryCreatedEvent(createBeneficiaryCommand.id,createBeneficiaryCommand.getFirstName(),
                createBeneficiaryCommand.getLastName(),createBeneficiaryCommand.getDocument() ));
    }

    @EventSourcingHandler
    protected  void addBeneficiary(BeneficiaryCreatedEvent beneficiaryCreatedEvent){
        log.info("##### @EventSourcingHandler : Inicio addBeneficiary ######");
        this.id=beneficiaryCreatedEvent.id;
        this.firstName=beneficiaryCreatedEvent.getFirstName();
        this.lastName= beneficiaryCreatedEvent.getLastName();
        this.document=beneficiaryCreatedEvent.getDocument();
    }

}
