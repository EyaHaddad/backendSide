package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.ValidationDto;
import com.isimm.backendSide.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/validations")
public class ValidationController {
    @Autowired
    private ValidationService ValidationService;

    //Build Add Validation REST API
    @PostMapping
    public ResponseEntity<ValidationDto> createValidation(@RequestBody ValidationDto ValidationDto){
        ValidationDto savedValidation = ValidationService.createValidation(ValidationDto);
        return new ResponseEntity<>(savedValidation, HttpStatus.CREATED);
    }
    //Build Get Validation REST API
    @GetMapping("{id}")
    public ResponseEntity<ValidationDto> getValidationById(@PathVariable("id") Long id){
        ValidationDto ValidationDto = ValidationService.getValidationById(id);
        return ResponseEntity.ok(ValidationDto);
    }
    //Build Get All Validations REST API
    @GetMapping
    public ResponseEntity<List<ValidationDto>> getAllValidation(){
        List<ValidationDto> Validations = ValidationService.getAllValidation();
        return ResponseEntity.ok(Validations);
    }
    //Build Update Validation REST API
    @PutMapping("{id}")
    public ResponseEntity<ValidationDto> updateValidation(@PathVariable("id") Long id,
                                                          @RequestBody ValidationDto updatedValidation){
        ValidationDto ValidationDto = ValidationService.updateValidation(id,updatedValidation);
        return ResponseEntity.ok(ValidationDto);
    }
    //Build Delete Validation REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteValidation(@PathVariable("id") Long id){
        ValidationService.deleteValidation(id);
        return ResponseEntity.ok("Validation deleted successfully!");
    }
}
