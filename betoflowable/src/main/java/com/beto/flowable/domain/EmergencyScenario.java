package com.beto.flowable.domain;

public class EmergencyScenario {
    private String name;
    private String workflow;

    public EmergencyScenario( String name, String workflow ) {

        this.name = name;
        this.workflow = workflow;
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

        return "EmergencyScenario{" + "name='" + name + '\'' + ", workflow='" + workflow + '\'' + '}';
    }
}
