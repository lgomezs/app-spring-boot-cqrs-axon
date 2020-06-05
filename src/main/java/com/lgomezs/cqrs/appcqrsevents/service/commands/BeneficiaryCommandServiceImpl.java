package com.lgomezs.cqrs.appcqrsevents.service.commands;

import com.lgomezs.cqrs.appcqrsevents.commands.CreateBeneficiaryCommand;
import com.lgomezs.cqrs.appcqrsevents.domain.Beneficiary;
import com.lgomezs.cqrs.appcqrsevents.dto.BeneficiaryDTO;
import com.lgomezs.cqrs.appcqrsevents.events.BeneficiaryCreatedEvent;
import com.lgomezs.cqrs.appcqrsevents.repository.BeneficiaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class BeneficiaryCommandServiceImpl implements BeneficiaryCommandService{

    private final CommandGateway commandGateway;
    private final BeneficiaryRepository beneficiaryRepository;

    public BeneficiaryCommandServiceImpl(CommandGateway commandGateway,BeneficiaryRepository beneficiaryRepository){
        this.commandGateway=commandGateway;
        this.beneficiaryRepository= beneficiaryRepository;
    }

    @Override
    public CompletableFuture<String> createBeneficiaryCommand(BeneficiaryDTO beneficiaryDTO) {
        log.info("############### Start createBeneficiaryCommand ###############");
        return commandGateway.send(new CreateBeneficiaryCommand(UUID.randomUUID().toString(),beneficiaryDTO.getFirstName(),
                beneficiaryDTO.getLastName(),
                new CreateBeneficiaryCommand.Document(beneficiaryDTO.getDocument().getType(),beneficiaryDTO.getDocument().getNumber())));
    }

    @EventSourcingHandler
    @Override
    public void addBeneficiary(BeneficiaryCreatedEvent beneficiaryCreatedEvent) {
        log.info("############### Start addBeneficiary ###############");
        beneficiaryRepository.save(new Beneficiary(beneficiaryCreatedEvent.id,beneficiaryCreatedEvent.getFirstName(),
                beneficiaryCreatedEvent.getLastName(),beneficiaryCreatedEvent.getDocument().getType(),
                beneficiaryCreatedEvent.getDocument().getNumber()));
    }
}
