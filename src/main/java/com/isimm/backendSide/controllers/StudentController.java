package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.StudentDto;
import com.isimm.backendSide.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService StudentService;

    //Build Add Student REST API
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto StudentDto){
        StudentDto savedStudent = StudentService.createStudent(StudentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    //Build Get Student REST API
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id){
        StudentDto StudentDto = StudentService.getStudentById(id);
        return ResponseEntity.ok(StudentDto);
    }
    //Build Get All Students REST API
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        List<StudentDto> Students = StudentService.getAllStudent();
        return ResponseEntity.ok(Students);
    }
    //Build Update Student REST API
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long id,
                                                          @RequestBody StudentDto updatedStudent){
        StudentDto StudentDto = StudentService.updateStudent(id,updatedStudent);
        return ResponseEntity.ok(StudentDto);
    }
    //Build Delete Student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        StudentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
