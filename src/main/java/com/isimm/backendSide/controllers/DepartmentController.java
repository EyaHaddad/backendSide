package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.DepartmentDto;
import com.isimm.backendSide.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //Build Add Department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto DepartmentDto){
        DepartmentDto savedDepartment = departmentService.createDepartment(DepartmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    //Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long id){
        DepartmentDto departmentDto = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(departmentDto);
    }
    //Build Get All Departments REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        List<DepartmentDto> departments = departmentService.getAllDepartment();
        return ResponseEntity.ok(departments);
    }
    //Build Update Department REST API
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long id,
                                                          @RequestBody DepartmentDto updatedDepartment){
        DepartmentDto departmentDto = departmentService.updateDepartment(id,updatedDepartment);
        return ResponseEntity.ok(departmentDto);
    }
    //Build Delete Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted successfully!");
    }
}
