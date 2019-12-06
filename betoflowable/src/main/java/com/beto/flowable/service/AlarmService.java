package com.beto.flowable.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class AlarmService implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        System.out.println("Alarm activated ... processInstanceId/Task -> "+execution.getProcessInstanceId()+"/"+execution.getCurrentFlowElement().getName());
    }
}
