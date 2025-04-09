package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.ValidationDto;
import com.isimm.backendSide.entities.Exam;
import com.isimm.backendSide.entities.User;
import com.isimm.backendSide.entities.Validation;
import com.isimm.backendSide.exceptions.RessourceNotFoundException;
import com.isimm.backendSide.mappers.ValidationMapper;
import com.isimm.backendSide.repositories.ValidationRepository;
import com.isimm.backendSide.services.ExamService;
import com.isimm.backendSide.services.UserService;
import com.isimm.backendSide.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ExamService examService;

    @Override
    public ValidationDto createValidation(ValidationDto validationDto) {
        Exam exam = examService.findById(validationDto.getexam());
        User user = userService.findById(validationDto.getValidatedBy());
        Validation Validation = ValidationMapper.mapToValidation(validationDto,exam,user);
        exam.getValidations().add(Validation);
        user.getValidations().add(Validation);
        Validation savedValidation = validationRepository.save(Validation);
        return ValidationMapper.mapToValidationDto(savedValidation);
    }

    @Override
    public ValidationDto getValidationById(Long ValidationId) {
        Validation dep = validationRepository.findById(ValidationId)
                .orElseThrow(()->new RessourceNotFoundException("Validation is not exists with the given id :"+ValidationId));
        return ValidationMapper.mapToValidationDto(dep);
    }

    @Override
    public List<ValidationDto> getAllValidation() {
        List<Validation> Validations = validationRepository.findAll();
        return Validations.stream().map(ValidationMapper::mapToValidationDto)
                .collect(Collectors.toList());
    }

    @Override
    public ValidationDto updateValidation(Long ValidationId, ValidationDto updatedValidation) {
        Validation Validation = validationRepository.findById(ValidationId).orElseThrow(
                ()-> new RessourceNotFoundException("Validation is not exists with given id :"+ValidationId));
        Validation.getValidatedBy().getValidations().remove(Validation);
        Validation.getExamV().getValidations().remove(Validation);
        Exam exam = examService.findById(updatedValidation.getexam());
        User user = userService.findById(updatedValidation.getValidatedBy());
        Validation.setExamV(exam);
        Validation.setValidatedBy(user);
        Validation.setStatus(updatedValidation.getStatus());
        Validation.setComments(updatedValidation.getComments());
        Validation.setValidationDate(LocalDateTime.now());
        exam.getValidations().add(Validation);
        user.getValidations().add(Validation);
        validationRepository.save(Validation);
        return ValidationMapper.mapToValidationDto(Validation);
    }

    @Override
    public void deleteValidation(Long ValidationId) {
        Validation Validation = validationRepository.findById(ValidationId).orElseThrow(
                ()-> new RessourceNotFoundException("Validation is not exists with given id :"+ValidationId));
        Validation.getValidatedBy().getValidations().remove(Validation);
        Validation.getExamV().getValidations().remove(Validation);
        validationRepository.deleteById(ValidationId);
    }
}
