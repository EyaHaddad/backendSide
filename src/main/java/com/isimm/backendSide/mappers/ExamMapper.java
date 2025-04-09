package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.ExamDto;
import com.isimm.backendSide.entities.Department;
import com.isimm.backendSide.entities.Exam;

public class ExamMapper {
    public static ExamDto mapToExamDto(Exam Exam){
        return new ExamDto(
                Exam.getExamId(),
                Exam.getSubject(),
                Exam.getDepartmentE().getName(),
                Exam.getExamDate(),
                Exam.getStartTime(),
                Exam.getEndTime(),
                Exam.getDifficulty(),
                Exam.getCoefficient(),
                Exam.getCreatedAt(),
                Exam.getUpdatedAt(),
                Exam.getDuplicate()
        );
    }
    public static Exam mapToExam(ExamDto ExamDto, Department department,Boolean dup){
        return new Exam(
                ExamDto.getExamId(),
                ExamDto.getSubject(),
                department,
                ExamDto.getExamDate(),
                ExamDto.getStartTime(),
                ExamDto.getEndTime(),
                ExamDto.getDifficulty(),
                ExamDto.getCoefficient(),
                dup
        );
    }
}
