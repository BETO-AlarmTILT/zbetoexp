package com.beto.flowable.service;

import com.beto.flowable.domain.EmergencyScenario;
import org.flowable.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmergencyScenarioWorkflowService {
    @Autowired
    private RuntimeService runtimeService;

    @Transactional
    public void startProcess( EmergencyScenario emergencyScenario) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", emergencyScenario.getName());
        variables.put("workflow", emergencyScenario.getWorkflow());
        runtimeService.startProcessInstanceByKey(emergencyScenario.getWorkflow(), variables);
    }

}