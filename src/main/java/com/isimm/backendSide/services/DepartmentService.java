package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.DepartmentDto;
import com.isimm.backendSide.entities.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto DepartmentDto);
    Department findByName (String name);
    DepartmentDto getDepartmentById (Long DepartmentId);
    List<DepartmentDto> getAllDepartment();
    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);
    void deleteDepartment (Long departmentId);
}
