package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.ExamRoomDto;
import com.isimm.backendSide.services.ExamRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam_rooms")
public class ExamRoomController {
    @Autowired
    private ExamRoomService ExamRoomService;

    //Build Add ExamRoom REST API
    @PostMapping
    public ResponseEntity<ExamRoomDto> createExamRoom(@RequestBody ExamRoomDto ExamRoomDto){
        ExamRoomDto savedExamRoom = ExamRoomService.createExamRoom(ExamRoomDto);
        return new ResponseEntity<>(savedExamRoom, HttpStatus.CREATED);
    }
    //Build Get ExamRoom REST API
    @GetMapping("{id}")
    public ResponseEntity<ExamRoomDto> getExamRoomById(@PathVariable("id") Long id){
        ExamRoomDto ExamRoomDto = ExamRoomService.getExamRoomById(id);
        return ResponseEntity.ok(ExamRoomDto);
    }
    //Build Get All ExamRooms REST API
    @GetMapping
    public ResponseEntity<List<ExamRoomDto>> getAllExamRoom(){
        List<ExamRoomDto> ExamRooms = ExamRoomService.getAllExamRoom();
        return ResponseEntity.ok(ExamRooms);
    }
    //Build Update ExamRoom REST API
    @PutMapping("{id}")
    public ResponseEntity<ExamRoomDto> updateExamRoom(@PathVariable("id") Long id,
                                              @RequestBody ExamRoomDto updatedExamRoom){
        ExamRoomDto ExamRoomDto = ExamRoomService.updateExamRoom(id,updatedExamRoom);
        return ResponseEntity.ok(ExamRoomDto);
    }
    //Build Delete ExamRoom REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExamRoom(@PathVariable("id") Long id){
        ExamRoomService.deleteExamRoom(id);
        return ResponseEntity.ok("ExamRoom deleted successfully!");
    }
}
