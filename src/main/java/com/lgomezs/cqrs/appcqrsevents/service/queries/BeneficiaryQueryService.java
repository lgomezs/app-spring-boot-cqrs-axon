package com.lgomezs.cqrs.appcqrsevents.service.queries;

import java.util.List;

public interface BeneficiaryQueryService {

    List<Object> listEventBeneficiary(String id);
}
