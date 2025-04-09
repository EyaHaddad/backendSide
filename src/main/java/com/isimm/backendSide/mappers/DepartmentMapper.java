package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.DepartmentDto;
import com.isimm.backendSide.entities.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getDepartmentId(),
                department.getName(),
                department.getHead(),
                department.getCreatedAt(),
                department.getUpdatedAt()
        );
    }
    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getDepartmentId(),
                departmentDto.getName()
        );
    }
}
