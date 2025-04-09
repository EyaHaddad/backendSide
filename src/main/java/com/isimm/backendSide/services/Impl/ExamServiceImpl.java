package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.ExamDto;
import com.isimm.backendSide.entities.Department;
import com.isimm.backendSide.entities.Exam;
import com.isimm.backendSide.exceptions.RessourceNotFoundException;
import com.isimm.backendSide.mappers.ExamMapper;
import com.isimm.backendSide.repositories.ExamRepository;
import com.isimm.backendSide.services.DepartmentService;
import com.isimm.backendSide.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository ExamRepository;
    @Autowired
    DepartmentService departmentService;

    @Override
    public ExamDto createExam(ExamDto ExamDto) {
        Department department = departmentService.findByName(ExamDto.getDepartmentE());
        Boolean dup = !ExamRepository.findByName(ExamDto.getSubject()).isEmpty();
        Exam Exam = ExamMapper.mapToExam(ExamDto,department,dup);
        department.getExams().add(Exam);
        Exam savedExam = ExamRepository.save(Exam);
        return ExamMapper.mapToExamDto(savedExam);
    }

    @Override
    public ExamDto getExamById(Long ExamId) {
        Exam dep = ExamRepository.findById(ExamId)
                .orElseThrow(()->new RessourceNotFoundException("Exam is not exists with the given id :"+ExamId));
        return ExamMapper.mapToExamDto(dep);
    }

    @Override
    public List<ExamDto> getAllExam() {
        List<Exam> Exams = ExamRepository.findAll();
        return Exams.stream().map(ExamMapper::mapToExamDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExamDto updateExam(Long ExamId, ExamDto updatedExam) {
        Exam exam = ExamRepository.findById(ExamId).orElseThrow(
                ()-> new RessourceNotFoundException("Exam is not exists with given id :"+ExamId));
        exam.getDepartmentE().getExams().remove(exam);

        exam.setSubject(updatedExam.getSubject());
        Department depNouveau = departmentService.findByName(updatedExam.getDepartmentE());
        exam.setDepartmentE(depNouveau);
        exam.setExamDate(updatedExam.getExamDate());
        exam.setStartTime(updatedExam.getStartTime());
        exam.setEndTime(updatedExam.getEndTime());
        exam.setDifficulty(updatedExam.getDifficulty());
        exam.setCoefficient(updatedExam.getCoefficient());
        depNouveau.getExams().add(exam);
        ExamRepository.save(exam);
        return ExamMapper.mapToExamDto(exam);
    }

    @Override
    public void deleteExam(Long ExamId) {
        Exam Exam = ExamRepository.findById(ExamId).orElseThrow(
                ()-> new RessourceNotFoundException("Exam is not exists with given id :"+ExamId));
        Exam.getDepartmentE().getExams().remove(Exam);
        ExamRepository.deleteById(ExamId);
    }

    @Override
    public Exam findById(Long id) {
        return ExamRepository.findById(id).orElseThrow(
                ()-> new RessourceNotFoundException("Exam is not exists with given id :"+id));
    }
}
