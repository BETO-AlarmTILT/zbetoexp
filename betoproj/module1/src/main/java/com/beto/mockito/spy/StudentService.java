package com.beto.mockito.spy;

import com.beto.mockito.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private StudentServiceSpy spy;
    public void setSpy(StudentServiceSpy spy) {
        this.spy = spy;
    }

    private Map<String, List<Student>> studentCourseMap = new HashMap<String, List<Student>>();

    public void enrollToCourse(String courseName, Student student) {

        MethodInvocation invocation = new MethodInvocation();
        invocation.addParam(courseName).addParam(student).
                setMethod("enrollToCourse");
        spy.registerCall(invocation);

        List<Student> list = studentCourseMap.get(courseName);
        if (list == null) {
            list = new ArrayList<Student>();
        }
        if (!list.contains(student)) {
            list.add(student);
        }
        studentCourseMap.put(courseName, list);
    }
}
