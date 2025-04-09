package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.RoomDto;
import com.isimm.backendSide.entities.Room;
import com.isimm.backendSide.exceptions.RessourceNotFoundException;
import com.isimm.backendSide.mappers.RoomMapper;
import com.isimm.backendSide.repositories.RoomRepository;
import com.isimm.backendSide.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room findByName(String name){
        return roomRepository.findByName(name);
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow(
                ()-> new RessourceNotFoundException("Exam is not exists with given id :"+id));
    }

    @Override
    public RoomDto createRoom(RoomDto RoomDto) {
        Room Room = RoomMapper.mapToRoom(RoomDto);
        Room savedRoom = roomRepository.save(Room);
        return RoomMapper.mapToRoomDto(savedRoom);
    }

    @Override
    public RoomDto getRoomById(Long RoomId) {
        Room dep = roomRepository.findById(RoomId)
                .orElseThrow(()->new RessourceNotFoundException("Room is not exists with the given id :"+RoomId));
        return RoomMapper.mapToRoomDto(dep);
    }

    @Override
    public List<RoomDto> getAllRoom() {
        List<Room> Rooms = roomRepository.findAll();
        return Rooms.stream().map(RoomMapper::mapToRoomDto)
                //car il s'agit d'une méthode statique
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto updateRoom(Long RoomId, RoomDto updatedRoom) {
        Room room = roomRepository.findById(RoomId).orElseThrow(
                ()-> new RessourceNotFoundException("Room is not exists with given id :"+RoomId));
        room.setRoomName(updatedRoom.getRoomName());
        room.setCapacity(updatedRoom.getCapacity());
        room.setLocation(updatedRoom.getLocation());
        room.setAvailable(updatedRoom.getAvailable());
        room.setUpdatedAt(LocalDateTime.now());
        roomRepository.save(room);
        return RoomMapper.mapToRoomDto(room);
    }

    @Override
    public void deleteRoom(Long RoomId) {
        Room room = roomRepository.findById(RoomId).orElseThrow(
                ()-> new RessourceNotFoundException("Room is not exists with given id :"+RoomId));
        roomRepository.deleteById(RoomId);
    }

}
