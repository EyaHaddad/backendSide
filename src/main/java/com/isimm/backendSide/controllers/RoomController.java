package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.RoomDto;
import com.isimm.backendSide.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    //Build Add room REST API
    @PostMapping
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto){
        RoomDto savedroom = roomService.createRoom(roomDto);
        return new ResponseEntity<>(savedroom, HttpStatus.CREATED);
    }
    //Build Get room REST API
    @GetMapping("{id}")
    public ResponseEntity<RoomDto> getroomById(@PathVariable("id") Long id){
        RoomDto roomDto = roomService.getRoomById(id);
        return ResponseEntity.ok(roomDto);
    }
    //Build Get All rooms REST API
    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllroom(){
        List<RoomDto> rooms = roomService.getAllRoom();
        return ResponseEntity.ok(rooms);
    }
    //Build Update room REST API
    @PutMapping("{id}")
    public ResponseEntity<RoomDto> updateroom(@PathVariable("id") Long id,
                                                          @RequestBody RoomDto updatedroom){
        RoomDto roomDto = roomService.updateRoom(id,updatedroom);
        return ResponseEntity.ok(roomDto);
    }
    //Build Delete room REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteroom(@PathVariable("id") Long id){
        roomService.deleteRoom(id);
        return ResponseEntity.ok("room deleted successfully!");
    }
}
