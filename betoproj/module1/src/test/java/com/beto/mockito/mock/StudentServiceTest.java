package com.beto.mockito.mock;

import com.beto.mockito.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentServiceTest {
    StudentService service = new StudentService();
    StudentServiceMockObject mockObject = new StudentServiceMockObject();

    @Test
    public void enrolls_students() throws Exception {
//create 2 students
        Student bob = new Student("001", "Robert Anthony");
        Student roy = new Student("002", "Roy Noon");
//set mock/spy
        service.setMock(mockObject);
//invoke method twice
        service.enrollToCourse("english", bob);
        service.enrollToCourse("history", roy);
//assert that the method was invoked twice
        assertEquals(2, mockObject.invocation("enrollToCourse"));
//verify wrong information, that enrollToCourse was
//invoked once, but actually it is invoked twice
        mockObject.verify("enrollToCourse", 2);
    }
}