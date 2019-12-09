package com.beto.flowable.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.el.FixedValue;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class AlarmService implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger( AlarmService.class );


    private FixedValue alarmName;

    public FixedValue getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(FixedValue alarmName) {
        this.alarmName = alarmName;
    }

    public void execute(DelegateExecution execution) {
        log.info("Alarm activated ... processInstanceId/Task -> "+execution.getProcessInstanceId()+"/"+execution.getCurrentFlowElement().getName());
        log.info("process variable alarmName:"+execution.getVariable("alarmName")) ;
        if (this.alarmName!=null) {
            log.info("fixed value attribute alarmName:"+((String)this.alarmName.getValue(execution)).toUpperCase()) ;
        }

    }
}
