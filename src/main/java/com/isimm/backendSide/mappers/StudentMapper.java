package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.StudentDto;
import com.isimm.backendSide.entities.Student;
import com.isimm.backendSide.entities.User;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student Student){
        return new StudentDto(
                Student.getStudentId(),
                Student.getUserStud().getName(),
                Student.getUserStud().getEmail(),
                Student.getUserStud().getPassword(),
                Student.getUserStud().getRole(),
                Student.getUserStud().getDepartmentU().getName(),
                Student.getProgram(),
                Student.getCreatedAt(),
                Student.getUpdatedAt()
        );
    }
    public static Student mapToStudent(StudentDto StudentDto, User user){
        return new Student(
                StudentDto.getStudentId(),
                user,
                StudentDto.getProgram()
        );
    }
}
