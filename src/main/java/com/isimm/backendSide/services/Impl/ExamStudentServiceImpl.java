package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.ExamStudentDto;
import com.isimm.backendSide.entities.*;
import com.isimm.backendSide.exceptions.RessourceNotFoundException;
import com.isimm.backendSide.mappers.ExamStudentMapper;
import com.isimm.backendSide.repositories.ExamStudentRepository;
import com.isimm.backendSide.services.ExamService;
import com.isimm.backendSide.services.ExamStudentService;
import com.isimm.backendSide.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamStudentServiceImpl implements ExamStudentService {
    @Autowired
    private ExamStudentRepository ExamStudentRepository;
    @Autowired
    private ExamService examService;
    @Autowired
    private StudentService studentService;

    @Override
    public ExamStudentDto createExamStudent(ExamStudentDto ExamStudentDto) {
        Exam exam = examService.findById(ExamStudentDto.getExamS());
        Student student = studentService.findById(ExamStudentDto.getStudent());
        ExamStudent examStudent = ExamStudentMapper.mapToExamStudent(ExamStudentDto,exam,student);
        exam.getExamStudents().add(examStudent);
        student.getExamStudents().add(examStudent);
        ExamStudent savedExamStudent = ExamStudentRepository.save(examStudent);
        return ExamStudentMapper.mapToExamStudentDto(savedExamStudent);
    }

    @Override
    public ExamStudentDto getExamStudentById(Long ExamStudentId) {
        ExamStudent dep = ExamStudentRepository.findById(ExamStudentId)
                .orElseThrow(()->new RessourceNotFoundException("ExamStudent is not exists with the given id :"+ExamStudentId));
        return ExamStudentMapper.mapToExamStudentDto(dep);
    }

    @Override
    public List<ExamStudentDto> getAllExamStudent() {
        List<ExamStudent> ExamStudents = ExamStudentRepository.findAll();
        return ExamStudents.stream().map(ExamStudentMapper::mapToExamStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExamStudentDto updateExamStudent(Long ExamStudentId, ExamStudentDto updatedExamStudent) {
        ExamStudent ExamStudent = ExamStudentRepository.findById(ExamStudentId).orElseThrow(
                ()-> new RessourceNotFoundException("ExamStudent is not exists with given id :"+ExamStudentId));
        ExamStudent.getExamS().getExamStudents().remove(ExamStudent);
        ExamStudent.getStudent().getExamStudents().remove(ExamStudent);
        Exam examN =examService.findById(updatedExamStudent.getExamS());
        Student student = studentService.findById(updatedExamStudent.getStudent());
        ExamStudent.setExamS(examN);
        ExamStudent.setStudent(student);
        ExamStudent.setStatus(updatedExamStudent.getStatus());
        examN.getExamStudents().add(ExamStudent);
        student.getExamStudents().add(ExamStudent);
        ExamStudentRepository.save(ExamStudent);
        return ExamStudentMapper.mapToExamStudentDto(ExamStudent);
    }

    @Override
    public void deleteExamStudent(Long ExamStudentId) {
        ExamStudent ExamStudent = ExamStudentRepository.findById(ExamStudentId).orElseThrow(
                ()-> new RessourceNotFoundException("ExamStudent is not exists with given id :"+ExamStudentId));
        ExamStudent.getExamS().getExamStudents().remove(ExamStudent);
        ExamStudent.getStudent().getExamStudents().remove(ExamStudent);
        ExamStudentRepository.deleteById(ExamStudentId);
    }
}
