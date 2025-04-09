package com.isimm.backendSide.repositories;

import com.isimm.backendSide.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository extends JpaRepository<Validation,Long> {
}
