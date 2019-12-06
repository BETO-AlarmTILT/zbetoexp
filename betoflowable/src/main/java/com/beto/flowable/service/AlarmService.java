package com.beto.flowable.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.el.FixedValue;

public class AlarmService implements JavaDelegate {
    private FixedValue alarmName;

    public FixedValue getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(FixedValue alarmName) {
        this.alarmName = alarmName;
    }

    public void execute(DelegateExecution execution) {
        System.out.println("Alarm activated ... processInstanceId/Task -> "+execution.getProcessInstanceId()+"/"+execution.getCurrentFlowElement().getName());
        System.out.println("process variable alarmName:"+execution.getVariable("alarmName")) ;
        if (this.alarmName!=null) {
            System.out.println("fixed value attribute alarmName:"+((String)this.alarmName.getValue(execution)).toUpperCase()) ;
        }

    }
}
