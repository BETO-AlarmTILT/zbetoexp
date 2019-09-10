package com.beto.mockito.mock;

import com.beto.mockito.Student;
import com.beto.mockito.spy.MethodInvocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

    private StudentServiceMockObject mock;
    public void setMock(StudentServiceMockObject mock) {
        this.mock = mock;
    }

    private Map<String, List<Student>> studentCouseMap = new HashMap<String, List<Student>>();
    public void enrollToCourse(String courseName, Student student){

        MethodInvocation invocation = new MethodInvocation();
        invocation.addParam(courseName).addParam(student).setMethod("enrollToCourse");
        mock.registerCall(invocation);

        List<Student> list = studentCouseMap.get(courseName);
        if (list == null) {
            list = new ArrayList<Student>();
        }
        if (!list.contains(student)) {
            list.add(student);
        }
        studentCouseMap.put(courseName, list);
    }
}
