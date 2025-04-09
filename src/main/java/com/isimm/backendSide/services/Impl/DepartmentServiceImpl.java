package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.DepartmentDto;
import com.isimm.backendSide.entities.Department;
import com.isimm.backendSide.exceptions.RessourceNotFoundException;
import com.isimm.backendSide.mappers.DepartmentMapper;
import com.isimm.backendSide.repositories.DepartmentRepository;
import com.isimm.backendSide.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department Department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(Department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public Department findByName(String name){
        return departmentRepository.findByName(name)
                .orElseThrow(() -> new RessourceNotFoundException("Department with name '" + name + "' not found"));
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department dep = departmentRepository.findById(departmentId)
                .orElseThrow(()->new RessourceNotFoundException("Department is not exists with the given id :"+departmentId));
        return DepartmentMapper.mapToDepartmentDto(dep);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentMapper::mapToDepartmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                ()-> new RessourceNotFoundException("Department is not exists with given id :"+departmentId));
        department.setName(updatedDepartment.getName());
        department.setHead(updatedDepartment.getHead());
        department.setUpdatedAt(LocalDateTime.now());
        departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                ()-> new RessourceNotFoundException("Department is not exists with given id :"+departmentId));
        departmentRepository.deleteById(departmentId);
    }
}
