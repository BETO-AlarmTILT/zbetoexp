package com.beto.flowable.service;

import com.beto.flowable.controller.EmergencyScenarioWorkflowController;
import com.beto.flowable.domain.*;
import com.beto.flowable.event.listener.MyEventListener;
import com.beto.flowable.event.listener.MyFlowableEventType;
import com.beto.flowable.event.listener.RegisterReplyEvent;
import com.beto.flowable.event.listener.YourEventListener;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventType;
import org.flowable.common.engine.impl.event.FlowableEventSupport;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.runtime.ProcessInstanceQuery;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<EmergencyScenario> getActiveTasks() {
        List<Task> tasks = taskService.createTaskQuery().active()
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

    @Transactional
    public void registerReply() {
        FlowableEventSupport flowableEventSupport=new FlowableEventSupport();
        //runtimeService.addEventListener(new YourEventListener());
        runtimeService.addEventListener(new MyEventListener());
        MyFlowableEventType testEventType = new MyFlowableEventType("registerReply");
        RegisterReplyEvent registerReplyEvent = new RegisterReplyEvent(testEventType);
        runtimeService.dispatchEvent(registerReplyEvent);
        //runtimeService.messageEventReceived();
    }

    @Transactional
    public List<EmergencyScenario> getActiveProcessIntances() {

        List<ProcessInstance> processInstances =
                runtimeService.createProcessInstanceQuery().active().list();

        List<EmergencyScenario> list = processInstances.stream()
                .map( processInstance -> new EmergencyScenario( processInstance.getId(), processInstance.getName(),
                        processInstance.getProcessDefinitionKey() ) ).collect( Collectors.toList() );

        return list;

    }


    @Transactional
    public void sendMessageEvent(String processInstanceId, String messageEventName) {


        Execution execution = runtimeService.createExecutionQuery()
                .processInstanceId(processInstanceId)
                .messageEventSubscriptionName(messageEventName).list().get(0);

        if (execution!=null) {
            runtimeService.messageEventReceived(messageEventName, execution.getId());
        }


    }

    @Transactional
    public List<EmergencyExecution> listExecutions(String processInstanceId) {


        List<Execution> executions = runtimeService.createExecutionQuery()
                .processInstanceId(processInstanceId)
                .list();

        List<EmergencyExecution> list = executions.stream()
                .map( execution -> new EmergencyExecution( execution.getId(), execution.getName(), execution.getProcessInstanceId(), execution.getActivityId(), execution.getDescription()
                        ) ).collect( Collectors.toList() );

        return list;


    }

}