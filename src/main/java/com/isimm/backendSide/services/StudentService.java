package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.StudentDto;
import com.isimm.backendSide.entities.Student;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto StudentDto);
    StudentDto getStudentById (Long StudentId);
    List<StudentDto> getAllStudent();
    StudentDto updateStudent(Long StudentId, StudentDto updatedStudent);
    void deleteStudent (Long StudentId);
    Student findById(Long id);
}
