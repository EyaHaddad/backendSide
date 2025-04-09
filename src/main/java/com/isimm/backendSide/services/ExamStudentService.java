package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.ExamStudentDto;

import java.util.List;

public interface ExamStudentService {
    ExamStudentDto createExamStudent(ExamStudentDto ExamStudentDto);
    ExamStudentDto getExamStudentById (Long ExamStudentId);
    List<ExamStudentDto> getAllExamStudent();
    ExamStudentDto updateExamStudent(Long ExamStudentId, ExamStudentDto updatedExamStudent);
    void deleteExamStudent (Long ExamStudentId);
}
