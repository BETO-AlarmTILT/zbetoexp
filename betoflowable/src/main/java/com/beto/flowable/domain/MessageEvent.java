package com.beto.flowable.domain;

public class MessageEvent {
    private String processId;
    private String messageId;

    public String getProcessId() {

        return processId;
    }

    public void setProcessId( String processId ) {

        this.processId = processId;
    }

    public String getMessageId() {

        return messageId;
    }

    public void setMessageId( String messageId ) {

        this.messageId = messageId;
    }
}
