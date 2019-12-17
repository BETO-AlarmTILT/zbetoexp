package com.beto.flowable.event.listener;

import org.flowable.common.engine.api.delegate.event.FlowableEventType;

public class MyFlowableEventType implements FlowableEventType {
    protected final String name;

    public MyFlowableEventType(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "TestFlowableEventType{" +
                "name='" + name + '\'' +
                '}';
    }
}
