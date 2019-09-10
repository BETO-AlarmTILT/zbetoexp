package com.beto.mockito.fake;

import com.beto.mockito.Student;

import java.util.List;

public interface StudentDao {
    public void batchUpdate(List<Student> students);
}