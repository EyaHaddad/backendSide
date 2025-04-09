package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.ExamStudentDto;
import com.isimm.backendSide.services.ExamStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam_students")
public class ExamStudentController {
    @Autowired
    private ExamStudentService examStudentService;

    //Build Add ExamStudent REST API
    @PostMapping
    public ResponseEntity<ExamStudentDto> createExamStudent(@RequestBody ExamStudentDto ExamStudentDto){
        ExamStudentDto savedExamStudent = examStudentService.createExamStudent(ExamStudentDto);
        return new ResponseEntity<>(savedExamStudent, HttpStatus.CREATED);
    }
    //Build Get ExamStudent REST API
    @GetMapping("{id}")
    public ResponseEntity<ExamStudentDto> getExamStudentById(@PathVariable("id") Long id){
        ExamStudentDto ExamStudentDto = examStudentService.getExamStudentById(id);
        return ResponseEntity.ok(ExamStudentDto);
    }
    //Build Get All ExamStudents REST API
    @GetMapping
    public ResponseEntity<List<ExamStudentDto>> getAllExamStudent(){
        List<ExamStudentDto> ExamStudents = examStudentService.getAllExamStudent();
        return ResponseEntity.ok(ExamStudents);
    }
    //Build Update ExamStudent REST API
    @PutMapping("{id}")
    public ResponseEntity<ExamStudentDto> updateExamStudent(@PathVariable("id") Long id,
                                                      @RequestBody ExamStudentDto updatedExamStudent){
        ExamStudentDto ExamStudentDto = examStudentService.updateExamStudent(id,updatedExamStudent);
        return ResponseEntity.ok(ExamStudentDto);
    }
    //Build Delete ExamStudent REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExamStudent(@PathVariable("id") Long id){
        examStudentService.deleteExamStudent(id);
        return ResponseEntity.ok("ExamStudent deleted successfully!");
    }
}
