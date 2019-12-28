package com.beto.flowable.domain;

public class EmergencyExecution {

    private String id;
    private String name;
    private String processInstanceId;
    private String activityId;
    private String description;

    public EmergencyExecution(String id, String name, String processInstanceId, String activityId, String description) {
        this.id = id;
        this.name = name;
        this.processInstanceId = processInstanceId;
        this.activityId = activityId;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
