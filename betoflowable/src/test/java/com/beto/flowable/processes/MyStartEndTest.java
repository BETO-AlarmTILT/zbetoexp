package com.beto.flowable.processes;

import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.Deployment;
import org.flowable.spring.impl.test.FlowableSpringExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@ExtendWith( FlowableSpringExtension.class)
@SpringBootTest
public class MyStartEndTest {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;

    @Test
    @Deployment(resources = { "processes/mystartend.bpmn20.xml" })
    void startEndProcessTest() {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("x","value of x - "+new Date());
        variables.put("y","value of y - "+new Date());
        variables.put("z","value of z - "+new Date());
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey( "mystartend", variables );
        String processInstanceId = processInstance.getId();
        System.out.println( "processInstanceId:"+processInstanceId );

        List<ProcessInstance> listRuntime =
                runtimeService.createProcessInstanceQuery().processInstanceId( processInstanceId ).list();

        List<HistoricProcessInstance> listHistory =
                historyService.createHistoricProcessInstanceQuery().processInstanceId( processInstanceId ).list();
        System.out.println( "durationInMillis:"+listHistory.get( 0 ).getDurationInMillis() );

        // Check post condition
        // process must be ended , so can not be retrieved from runtime service
        assertTrue(listRuntime.size()==0);

        // process must be ended , so can be retrieved from history service
        assertTrue(listHistory.size()==1);
        assertTrue(listHistory.get( 0 ).getId().equals(processInstanceId));
        // process has been started , so startTime must be set
        assertTrue(listHistory.get( 0 ).getStartTime()!=null);
        // process ended , so endTime must be set
        assertTrue(listHistory.get( 0 ).getEndTime()!=null);
        // process end time must be after start time
        assertTrue(listHistory.get( 0 ).getEndTime().after( listHistory.get( 0 ).getStartTime() ));

    }

}