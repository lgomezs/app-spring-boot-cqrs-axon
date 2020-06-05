package com.lgomezs.cqrs.appcqrsevents.events.base;

public class BaseEvent<T> {

    public final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
