package com.lgomezs.cqrs.appcqrsevents.controller;

import com.lgomezs.cqrs.appcqrsevents.dto.BeneficiaryDTO;
import com.lgomezs.cqrs.appcqrsevents.service.commands.BeneficiaryCommandService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping(value = "/beneficiary")
@Api(value = "Beneficiary Commands", description = "Beneficiary Commands Related Endpoints", tags = "Beneficiary Commands")
public class BeneficiaryCommandController {

    private final BeneficiaryCommandService beneficiaryCommandService;

    public BeneficiaryCommandController(BeneficiaryCommandService beneficiaryCommandService){
        this.beneficiaryCommandService=beneficiaryCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO){
        log.info("##### Start controller createBeneficiary #####");
        return beneficiaryCommandService.createBeneficiaryCommand(beneficiaryDTO);
    }
}
