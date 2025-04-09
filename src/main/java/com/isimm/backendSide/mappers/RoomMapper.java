package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.RoomDto;
import com.isimm.backendSide.entities.Room;

public class RoomMapper {
    public static RoomDto mapToRoomDto(Room room) {
        return new RoomDto(
                room.getRoomId(),
                room.getRoomName(),
                room.getCapacity(),
                room.getLocation(),
                room.getUpdatedAt(),
                room.getAvailable()
        );
    }

    public static Room mapToRoom(RoomDto roomDto) {
        return new Room(
                roomDto.getRoomId(),
                roomDto.getRoomName(),
                roomDto.getCapacity(),
                roomDto.getLocation(),
                roomDto.getAvailable()
        );
    }
}
