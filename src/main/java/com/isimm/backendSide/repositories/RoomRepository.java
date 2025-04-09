package com.isimm.backendSide.repositories;

import com.isimm.backendSide.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    @Query("select r from Room r where r.roomName =:name")
    Room findByName(@Param("name") String name);
}
