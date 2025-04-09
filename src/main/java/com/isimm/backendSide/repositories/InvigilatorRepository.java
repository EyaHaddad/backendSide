package com.isimm.backendSide.repositories;

import com.isimm.backendSide.entities.Invigilator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvigilatorRepository extends JpaRepository<Invigilator, Long> {
}
