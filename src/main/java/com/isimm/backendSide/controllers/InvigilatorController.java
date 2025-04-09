package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.InvigilatorDto;
import com.isimm.backendSide.services.InvigilatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/invigilators")
public class InvigilatorController {
        @Autowired
        private InvigilatorService InvigilatorService;

        //Build Add Invigilator REST API
        @PostMapping
        public ResponseEntity<InvigilatorDto> createInvigilator(@RequestBody InvigilatorDto InvigilatorDto){
            InvigilatorDto savedInvigilator = InvigilatorService.createInvigilator(InvigilatorDto);
            return new ResponseEntity<>(savedInvigilator, HttpStatus.CREATED);
        }
        //Build Get Invigilator REST API
        @GetMapping("{id}")
        public ResponseEntity<InvigilatorDto> getInvigilatorById(@PathVariable("id") Long id){
            InvigilatorDto InvigilatorDto = InvigilatorService.getInvigilatorById(id);
            return ResponseEntity.ok(InvigilatorDto);
        }
        //Build Get All Invigilators REST API
        @GetMapping
        public ResponseEntity<List<InvigilatorDto>> getAllInvigilator(){
            List<InvigilatorDto> Invigilators = InvigilatorService.getAllInvigilator();
            return ResponseEntity.ok(Invigilators);
        }
        //Build Update Invigilator REST API
        @PutMapping("{id}")
        public ResponseEntity<InvigilatorDto> updateInvigilator(@PathVariable("id") Long id,
                                                              @RequestBody InvigilatorDto updatedInvigilator){
            InvigilatorDto InvigilatorDto = InvigilatorService.updateInvigilator(id,updatedInvigilator);
            return ResponseEntity.ok(InvigilatorDto);
        }
        //Build Delete Invigilator REST API
        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteInvigilator(@PathVariable("id") Long id){
            InvigilatorService.deleteInvigilator(id);
            return ResponseEntity.ok("Invigilator deleted successfully!");
        }
}
