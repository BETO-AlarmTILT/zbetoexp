package com.beto.mockito;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class StudentServiceTest {

    @Test
    // Stub
    public void when_connection_times_out_then_the_student_is_not_saved() {
        StudentServiceImpl studentService = new StudentServiceImpl(new ConnectionTimedOutStudentDAOStub());
        String classNine = "IX";
        String johnSmith = "john Smith";
        CreateStudentResponse resp = studentService.create(johnSmith, classNine);
        assertFalse(resp.isSuccess());
    }
}
