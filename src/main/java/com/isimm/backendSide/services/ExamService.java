package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.ExamDto;
import com.isimm.backendSide.entities.Exam;

import java.util.List;

public interface ExamService {
    ExamDto createExam(ExamDto examDto);
    ExamDto getExamById (Long examId);
    List<ExamDto> getAllExam();
    ExamDto updateExam(Long examId, ExamDto updatedExam);
    void deleteExam (Long examId);
    Exam findById(Long id);
}
