package com.isimm.backendSide.repositories;

import com.isimm.backendSide.entities.ScheduleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleLogRepository extends JpaRepository<ScheduleLog, Long> {
}
