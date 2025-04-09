package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.StudentDto;
import com.isimm.backendSide.entities.Department;
import com.isimm.backendSide.entities.User;
import com.isimm.backendSide.entities.Student;
import com.isimm.backendSide.exceptions.RessourceNotFoundException;
import com.isimm.backendSide.mappers.StudentMapper;
import com.isimm.backendSide.repositories.StudentRepository;
import com.isimm.backendSide.services.DepartmentService;
import com.isimm.backendSide.services.StudentService;
import com.isimm.backendSide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository StudentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;

    @Override
    public StudentDto createStudent(StudentDto StudentDto) {
        //create user 
        User user = userService.createUser(StudentDto.getName(),
                StudentDto.getEmail(),StudentDto.getPassword(),StudentDto.getRole(),
                StudentDto.getDepartmentU(),true);
        Student Student = StudentMapper.mapToStudent(StudentDto,user);
        Student savedStudent = StudentRepository.save(Student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long StudentId) {
        Student dep = StudentRepository.findById(StudentId)
                .orElseThrow(()->new RessourceNotFoundException("Student is not exists with the given id :"+StudentId));
        return StudentMapper.mapToStudentDto(dep);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> Students = StudentRepository.findAll();
        return Students.stream().map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long StudentId, StudentDto updatedStudent) {
        Student student = StudentRepository.findById(StudentId).orElseThrow(
                ()-> new RessourceNotFoundException("Student is not exists with given id :"+StudentId));
        student.getUserStud().getDepartmentU().getUsers().remove(student.getUserStud());
        student.getUserStud().setName(updatedStudent.getName());
        student.getUserStud().setEmail(updatedStudent.getEmail());
        student.getUserStud().setPassword(updatedStudent.getPassword());
        student.getUserStud().setRole(updatedStudent.getRole());
        Department newDep = departmentService.findByName(updatedStudent.getDepartmentU());
        student.getUserStud().setDepartmentU(newDep);
        student.setProgram(updatedStudent.getProgram());
        student.getUserStud().getDepartmentU().getUsers().add(student.getUserStud());
        StudentRepository.save(student);
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public void deleteStudent(Long StudentId) {
        Student Student = StudentRepository.findById(StudentId).orElseThrow(
                ()-> new RessourceNotFoundException("Student is not exists with given id :"+StudentId));
        Student.getUserStud().getDepartmentU().getUsers().remove(Student.getUserStud());
        StudentRepository.deleteById(StudentId);
    }

    @Override
    public Student findById(Long id) {
        return StudentRepository.findById(id).orElseThrow(
                ()-> new RessourceNotFoundException("Student is not exists with given id :"+id));
    }
}
