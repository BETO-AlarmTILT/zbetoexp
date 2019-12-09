package com.beto.flowable.domain;

public class EmergencyScenario {
    private String id;
    private String name;
    private String workflow;

    public EmergencyScenario(String id, String name, String workflow ) {

        this.id = id;
        this.name = name;
        this.workflow = workflow;
    }

    public String getId() {

        return id;
    }

    public void setId( String id ) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName( String name ) {

        this.name = name;
    }

    public String getWorkflow() {

        return workflow;
    }

    public void setWorkflow( String workflow ) {

        this.workflow = workflow;
    }

    @Override public String toString() {

        return "EmergencyScenario{" + "id='" + id + '\'' + "name='" + name + '\'' + ", workflow='" + workflow + '\'' + '}';
    }
}
