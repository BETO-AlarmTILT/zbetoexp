package com.beto.flowable.service;

import org.flowable.engine.delegate.BpmnError;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class TaskWithErrorManagement  implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        String value = (String) delegateExecution.getVariable("var");

        String sequenceFlowToTake = null;
        try {
            executeLogic(value);
        } catch (Exception e) {
            throw new BpmnError("BusinessExceptionOccurred");
        }
    }

    private void executeLogic(String value) throws IllegalArgumentException {
        if (!"OK".equals(value)) {
            throw new IllegalArgumentException();
        }
    }
}
