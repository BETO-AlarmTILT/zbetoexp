package com.beto.flowable.event.listener;

import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventType;

public class RegisterReplyEvent implements FlowableEvent {

    protected final FlowableEventType type;

    public RegisterReplyEvent(FlowableEventType type) {
        this.type = type;
    }

    @Override
    public FlowableEventType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TestFlowableEvent{" +
                "type=" + type +
                '}';
    }
}
