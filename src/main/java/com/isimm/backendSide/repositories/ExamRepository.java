package com.isimm.backendSide.repositories;

import com.isimm.backendSide.dto.ExamDto;
import com.isimm.backendSide.entities.Exam;
import com.isimm.backendSide.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long> {

    @Query("select e from Exam e where e.subject like :x")
    List<Exam> findByName(@Param("x")String mc);
    @Query("select distinct e.subject from Exam e ")
    List<String> getSubjects();
}
