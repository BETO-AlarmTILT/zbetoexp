package com.beto.mockito;

import java.math.BigDecimal;

public class Marks {
    private final Student student;

    private final String subjectId;

    private final BigDecimal marks;

    public Marks(Student student, String subjectId,
                 BigDecimal marks) {
        this.student = student;
        this.subjectId = subjectId;
        this.marks = marks;
    }

    //getters methods go here

    public BigDecimal getMarks() {
        return marks;
    }

    public String getSubjectId() {
        return subjectId;
    }
}