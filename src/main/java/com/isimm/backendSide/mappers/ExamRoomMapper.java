package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.ExamRoomDto;
import com.isimm.backendSide.entities.Department;
import com.isimm.backendSide.entities.Exam;
import com.isimm.backendSide.entities.ExamRoom;
import com.isimm.backendSide.entities.Room;

public class ExamRoomMapper {
    public static ExamRoomDto mapToExamRoomDto(ExamRoom ExamRoom){
        return new ExamRoomDto(
                ExamRoom.getExam_roomId(),
                ExamRoom.getExam().getExamId(),
                ExamRoom.getRoom().getRoomId(),
                ExamRoom.getCreatedAt()
        );
    }
    public static ExamRoom mapToExamRoom(ExamRoomDto ExamRoomDto, Exam exam, Room room){
        return new ExamRoom(
                ExamRoomDto.getExam_roomId(),
                exam,
                room
        );
    }
}
