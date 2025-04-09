package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.ValidationDto;

import java.util.List;

public interface ValidationService {
    ValidationDto createValidation(ValidationDto ValidationDto);
    ValidationDto getValidationById (Long ValidationId);
    List<ValidationDto> getAllValidation();
    ValidationDto updateValidation(Long ValidationId, ValidationDto updatedValidation);
    void deleteValidation (Long ValidationId);
}
