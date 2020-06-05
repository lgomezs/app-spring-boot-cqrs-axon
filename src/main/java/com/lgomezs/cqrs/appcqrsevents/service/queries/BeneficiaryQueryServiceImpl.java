package com.lgomezs.cqrs.appcqrsevents.service.queries;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiaryQueryServiceImpl implements  BeneficiaryQueryService{

    private final EventStore eventStore;

    public BeneficiaryQueryServiceImpl(EventStore eventStore){
        this.eventStore=eventStore;
    }

    @Override
    public List<Object> listEventBeneficiary(String id) {
        return eventStore.readEvents(id).asStream().map(Message::getPayload).collect(Collectors.toList());
    }
}
