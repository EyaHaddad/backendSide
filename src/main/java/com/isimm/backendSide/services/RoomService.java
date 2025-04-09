package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.RoomDto;
import com.isimm.backendSide.entities.Room;

import java.util.List;

public interface RoomService {
    Room findByName(String name);

    Room findById(Long id);

    RoomDto createRoom(RoomDto RoomDto);

    RoomDto getRoomById(Long RoomId);

    List<RoomDto> getAllRoom();

    RoomDto updateRoom(Long RoomId, RoomDto updatedRoom);

    void deleteRoom(Long RoomId);
}