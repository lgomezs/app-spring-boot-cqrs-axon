package com.lgomezs.cqrs.appcqrsevents.controller;

import com.lgomezs.cqrs.appcqrsevents.service.queries.BeneficiaryQueryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/beneficiary")
@Api(value = "Beneficiary queries", description = "Beneficiary queries Related Endpoints", tags = "Beneficiary queries")
public class BeneficiaryQueryController {

    private final BeneficiaryQueryService beneficiaryQueryService;

    public BeneficiaryQueryController(BeneficiaryQueryService beneficiaryQueryService){
        this.beneficiaryQueryService=beneficiaryQueryService;
    }

    @GetMapping("/{id}/events")
    public List<Object> listEventsForBeneficiary(@PathVariable(value = "id") String id){
        return beneficiaryQueryService.listEventBeneficiary(id);
    }

}


