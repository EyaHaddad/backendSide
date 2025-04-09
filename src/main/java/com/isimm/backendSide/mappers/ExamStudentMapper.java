package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.ExamStudentDto;
import com.isimm.backendSide.entities.Exam;
import com.isimm.backendSide.entities.ExamStudent;
import com.isimm.backendSide.entities.Student;

public class ExamStudentMapper {
    public static ExamStudentDto mapToExamStudentDto(ExamStudent ExamStudent){
        return new ExamStudentDto(
                ExamStudent.getExam_studentId(),
                ExamStudent.getExamS().getExamId(),
                ExamStudent.getStudent().getStudentId(),
                ExamStudent.getStatus(),
                ExamStudent.getCreatedAt()
        );
    }
    public static ExamStudent mapToExamStudent(ExamStudentDto ExamStudentDto, Exam exam, Student student){
        return new ExamStudent(
                ExamStudentDto.getExam_studentId(),
                exam,
                student,
                ExamStudentDto.getStatus()
        );
    }
}
