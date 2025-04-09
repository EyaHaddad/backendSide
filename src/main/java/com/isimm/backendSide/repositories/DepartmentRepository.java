package com.isimm.backendSide.repositories;

import com.isimm.backendSide.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query("select d from Department d where d.name like :x")
    public Optional<Department> findByName(@Param("x")String mc);
}
