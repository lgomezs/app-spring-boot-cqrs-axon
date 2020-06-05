package com.lgomezs.cqrs.appcqrsevents.service.commands;

import com.lgomezs.cqrs.appcqrsevents.dto.BeneficiaryDTO;
import com.lgomezs.cqrs.appcqrsevents.events.BeneficiaryCreatedEvent;

import java.util.concurrent.CompletableFuture;

public interface BeneficiaryCommandService {

    CompletableFuture<String> createBeneficiaryCommand(BeneficiaryDTO beneficiaryDTO);

    void addBeneficiary(BeneficiaryCreatedEvent  beneficiaryCreatedEvent);
}
