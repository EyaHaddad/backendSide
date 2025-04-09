package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.ScheduleLogDto;
import com.isimm.backendSide.services.ScheduleLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduleLogs")
public class ScheduleLogController {
    @Autowired
    private ScheduleLogService ScheduleLogService;

    //Build Add ScheduleLog REST API
    @PostMapping
    public ResponseEntity<ScheduleLogDto> createScheduleLog(@RequestBody ScheduleLogDto ScheduleLogDto){
        ScheduleLogDto savedScheduleLog = ScheduleLogService.createScheduleLog(ScheduleLogDto);
        return new ResponseEntity<>(savedScheduleLog, HttpStatus.CREATED);
    }
    //Build Get ScheduleLog REST API
    @GetMapping("{id}")
    public ResponseEntity<ScheduleLogDto> getScheduleLogById(@PathVariable("id") Long id){
        ScheduleLogDto ScheduleLogDto = ScheduleLogService.getScheduleLogById(id);
        return ResponseEntity.ok(ScheduleLogDto);
    }
    //Build Get All ScheduleLogs REST API
    @GetMapping
    public ResponseEntity<List<ScheduleLogDto>> getAllScheduleLog(){
        List<ScheduleLogDto> ScheduleLogs = ScheduleLogService.getAllScheduleLog();
        return ResponseEntity.ok(ScheduleLogs);
    }
    //Build Update ScheduleLog REST API
    @PutMapping("{id}")
    public ResponseEntity<ScheduleLogDto> updateScheduleLog(@PathVariable("id") Long id,
                                                          @RequestBody ScheduleLogDto updatedScheduleLog){
        ScheduleLogDto ScheduleLogDto = ScheduleLogService.updateScheduleLog(id,updatedScheduleLog);
        return ResponseEntity.ok(ScheduleLogDto);
    }
    //Build Delete ScheduleLog REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteScheduleLog(@PathVariable("id") Long id){
        ScheduleLogService.deleteScheduleLog(id);
        return ResponseEntity.ok("ScheduleLog deleted successfully!");
    }
}
