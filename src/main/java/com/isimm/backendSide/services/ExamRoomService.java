package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.ExamRoomDto;

import java.util.List;

public interface ExamRoomService {
    ExamRoomDto createExamRoom(ExamRoomDto ExamRoomDto);
    ExamRoomDto getExamRoomById (Long ExamRoomId);
    List<ExamRoomDto> getAllExamRoom();
    ExamRoomDto updateExamRoom(Long ExamRoomId, ExamRoomDto updatedExamRoom);
    void deleteExamRoom (Long ExamRoomId);
}
