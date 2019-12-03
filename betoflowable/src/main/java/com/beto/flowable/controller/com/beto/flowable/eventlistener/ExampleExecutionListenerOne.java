package com.beto.flowable.controller.com.beto.flowable.eventlistener;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;

public class ExampleExecutionListenerOne implements ExecutionListener {

    /*
    public void notify( ExecutionListenerExecution execution) throws Exception {
        execution.setVariable("variableSetInExecutionListener", "firstValue");
        execution.setVariable("eventReceived", execution.getEventName());
    }
    */

    @Override public void notify( DelegateExecution delegateExecution ) {
        delegateExecution.setVariable("variableSetInExecutionListener", "firstValue");
        delegateExecution.setVariable("eventReceived", delegateExecution.getEventName());
    }
}
