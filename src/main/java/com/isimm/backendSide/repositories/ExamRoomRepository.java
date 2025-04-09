package com.isimm.backendSide.repositories;

import com.isimm.backendSide.entities.ExamRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRoomRepository extends JpaRepository<ExamRoom,Long> {

}
