package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.ExamDto;
import com.isimm.backendSide.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {
    @Autowired
    private ExamService examService;

    //Build Add Exam REST API
    @PostMapping
    public ResponseEntity<ExamDto> createExam(@RequestBody ExamDto ExamDto){
        ExamDto savedExam = examService.createExam(ExamDto);
        return new ResponseEntity<>(savedExam, HttpStatus.CREATED);
    }
    //Build Get Exam REST API
    @GetMapping("{id}")
    public ResponseEntity<ExamDto> getExamById(@PathVariable("id") Long id){
        ExamDto ExamDto = examService.getExamById(id);
        return ResponseEntity.ok(ExamDto);
    }
    //Build Get All Exams REST API
    @GetMapping
    public ResponseEntity<List<ExamDto>> getAllExam(){
        List<ExamDto> Exams = examService.getAllExam();
        return ResponseEntity.ok(Exams);
    }
    //Build Update Exam REST API
    @PutMapping("{id}")
    public ResponseEntity<ExamDto> updateExam(@PathVariable("id") Long id,
                                                          @RequestBody ExamDto updatedExam){
        ExamDto ExamDto = examService.updateExam(id,updatedExam);
        return ResponseEntity.ok(ExamDto);
    }
    //Build Delete Exam REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExam(@PathVariable("id") Long id){
        examService.deleteExam(id);
        return ResponseEntity.ok("Exam deleted successfully!");
    }
    @GetMapping("/subjects")
    public ResponseEntity<List<String>> getAllSubjects() {
        List<String> subjects = examService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }
}
