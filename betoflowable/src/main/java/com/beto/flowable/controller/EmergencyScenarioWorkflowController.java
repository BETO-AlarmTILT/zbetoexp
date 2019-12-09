package com.beto.flowable.controller;

import com.beto.flowable.domain.AlertLevel;
import com.beto.flowable.domain.Approval;
import com.beto.flowable.domain.Article;
import com.beto.flowable.domain.EmergencyScenario;
import com.beto.flowable.service.EmergencyScenarioWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<EmergencyScenario> getTasks(@RequestParam String assignee) {
        return service.getTasks(assignee);
    }

    @PostMapping("/emergency-review")
    public void review(@RequestBody AlertLevel alertLevel) {
        service.review(alertLevel);
    }

}