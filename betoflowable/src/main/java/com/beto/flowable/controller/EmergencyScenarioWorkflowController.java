package com.beto.flowable.controller;

import com.beto.flowable.domain.*;
import com.beto.flowable.service.EmergencyScenarioWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmergencyScenarioWorkflowController {
    @Autowired
    private EmergencyScenarioWorkflowService service;
    @PostMapping("/emergency-scenario")
    public void submit(@RequestBody EmergencyScenario emergencyScenario) {
        service.startProcess(emergencyScenario);
    }

    @GetMapping("/emergency-tasks")
    public List<EmergencyScenario> getTasks() {
        return service.getActiveTasks();
    }

    @PostMapping("/emergency-review")
    public void review(@RequestBody AlertLevel alertLevel) {
        service.review(alertLevel);
    }

    @PostMapping("/emergency-event")
    public void registerReply() {
        service.registerReply();
    }

    @GetMapping("/emergency-active-workflows")
    public List<EmergencyScenario> getActiveProcessInstances() {
        return service.getActiveProcessIntances();
    }

    @PostMapping("/emergency-message-event")
    public void sendMessage(@RequestBody MessageEvent messageEvent ) {
        service.sendMessageEvent(messageEvent.getProcessId(),messageEvent.getMessageId());
    }

    @GetMapping("/emergency-executions/{processInstanceId}")
    public List<EmergencyExecution> getEmergencyExecutions(@PathVariable String processInstanceId) {
        return service.listExecutions(processInstanceId);
    }

}