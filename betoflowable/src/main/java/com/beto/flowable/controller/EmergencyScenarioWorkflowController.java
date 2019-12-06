package com.beto.flowable.controller;

import com.beto.flowable.domain.EmergencyScenario;
import com.beto.flowable.service.EmergencyScenarioWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmergencyScenarioWorkflowController {
    @Autowired
    private EmergencyScenarioWorkflowService service;
    @PostMapping("/emergency-scenario")
    public void submit(@RequestBody EmergencyScenario emergencyScenario) {
        service.startProcess(emergencyScenario);
    }
}