package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.ValidationDto;
import com.isimm.backendSide.entities.Exam;
import com.isimm.backendSide.entities.User;
import com.isimm.backendSide.entities.Validation;

public class ValidationMapper {
    public static ValidationDto mapToValidationDto(Validation validation) {
        return new ValidationDto(
                validation.getValidationId(),
                validation.getValidatedBy().getUserId(),
                validation.getValidatedBy().getUserId(),
                validation.getStatus(),
                validation.getComments(),
                validation.getValidationDate()
        );
    }

    public static Validation mapToValidation(ValidationDto validationDto, Exam exam, User validatedBy) {
        return new Validation(
                exam,
                validatedBy,
                validationDto.getStatus(),
                validationDto.getComments(),
                validationDto.getValidationDate()
        );
    }
}
