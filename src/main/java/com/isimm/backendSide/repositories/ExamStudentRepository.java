package com.isimm.backendSide.repositories;

import com.isimm.backendSide.entities.ExamStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamStudentRepository extends JpaRepository<ExamStudent, Long> {
}
