package com.beto.flowable.service;

import com.beto.flowable.domain.AlertLevel;
import com.beto.flowable.domain.Approval;
import com.beto.flowable.domain.Article;
import com.beto.flowable.domain.EmergencyScenario;
import org.flowable.engine.RuntimeService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.flowable.engine.TaskService;

@Service
public class EmergencyScenarioWorkflowService {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @Transactional
    public void startProcess( EmergencyScenario emergencyScenario) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", emergencyScenario.getName());
        variables.put("workflow", emergencyScenario.getWorkflow());
        runtimeService.startProcessInstanceByKey(emergencyScenario.getWorkflow(), variables);
    }

    @Transactional
    public List<EmergencyScenario> getTasks(String assignee) {
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup(assignee)
                .list();
        return tasks.stream()
                .map(task -> {
                    Map<String, Object> variables = taskService.getVariables(task.getId());
                    return new EmergencyScenario(task.getId(), (String) variables.get("name"), (String) variables.get("workflow"));
                })
                .collect( Collectors.toList());
    }

    @Transactional
    public void review( AlertLevel alertLevel) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("alertlevel", Integer.valueOf(alertLevel.getAlertLevel()));
        taskService.complete(alertLevel.getId(), variables);
    }



}