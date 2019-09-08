package com.beto.mockito;

public class DummyStudent extends Student {
    protected DummyStudent() {
        super(null, null);
    }
    public String getRoleNumber() {
        throw new RuntimeException("Dummy student");
    }
    public String getName() {
        throw new RuntimeException("Dummy student");
    }
}
