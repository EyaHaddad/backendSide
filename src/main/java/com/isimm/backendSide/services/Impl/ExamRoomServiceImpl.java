package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.ExamRoomDto;
import com.isimm.backendSide.entities.Exam;
import com.isimm.backendSide.entities.ExamRoom;
import com.isimm.backendSide.entities.Room;
import com.isimm.backendSide.exceptions.RessourceNotFoundException;
import com.isimm.backendSide.mappers.ExamRoomMapper;
import com.isimm.backendSide.services.ExamRoomService;
import com.isimm.backendSide.services.ExamService;
import com.isimm.backendSide.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.isimm.backendSide.repositories.ExamRoomRepository;
@Service
public class ExamRoomServiceImpl implements ExamRoomService {
    @Autowired
    private ExamRoomRepository ExamRoomRepository;
    @Autowired
    private ExamService examService;
    @Autowired
    private RoomService roomService;

    @Override
    public ExamRoomDto createExamRoom(ExamRoomDto ExamRoomDto) {
        Exam exam = examService.findById(ExamRoomDto.getExam());
        Room room = roomService.findById(ExamRoomDto.getRoom());
        ExamRoom ExamRoom = ExamRoomMapper.mapToExamRoom(ExamRoomDto,exam,room);
        exam.getExamRooms().add(ExamRoom);
        room.getExamRooms().add(ExamRoom);
        ExamRoom savedExamRoom = ExamRoomRepository.save(ExamRoom);
        return ExamRoomMapper.mapToExamRoomDto(savedExamRoom);
    }

    @Override
    public ExamRoomDto getExamRoomById(Long ExamRoomId) {
        ExamRoom dep = ExamRoomRepository.findById(ExamRoomId)
                .orElseThrow(()->new RessourceNotFoundException("ExamRoom is not exists with the given id :"+ExamRoomId));
        return ExamRoomMapper.mapToExamRoomDto(dep);
    }

    @Override
    public List<ExamRoomDto> getAllExamRoom() {
        List<ExamRoom> ExamRooms = ExamRoomRepository.findAll();
        return ExamRooms.stream().map(ExamRoomMapper::mapToExamRoomDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExamRoomDto updateExamRoom(Long ExamRoomId, ExamRoomDto updatedExamRoom) {
        ExamRoom examRoom = ExamRoomRepository.findById(ExamRoomId).orElseThrow(
                ()-> new RessourceNotFoundException("ExamRoom is not exists with given id :"+ExamRoomId));

        //assurer la suppression de l'ancient element
        examRoom.getExam().getExamRooms().remove(examRoom);
        examRoom.getRoom().getExamRooms().remove(examRoom);

        examRoom.setExam(examService.findById(updatedExamRoom.getExam()));
        examRoom.setRoom(roomService.findById(updatedExamRoom.getRoom()));
        //assurer l'ajout du nouveau element
        examRoom.getExam().getExamRooms().add(examRoom);
        examRoom.getRoom().getExamRooms().add(examRoom);
        ExamRoomRepository.save(examRoom);
        return ExamRoomMapper.mapToExamRoomDto(examRoom);
    }

    @Override
    public void deleteExamRoom(Long ExamRoomId) {
        ExamRoom ExamRoom = ExamRoomRepository.findById(ExamRoomId).orElseThrow(
                ()-> new RessourceNotFoundException("ExamRoom is not exists with given id :"+ExamRoomId));
        ExamRoom.getExam().getExamRooms().remove(ExamRoom);
        ExamRoom.getRoom().getExamRooms().remove(ExamRoom);
        ExamRoomRepository.deleteById(ExamRoomId);
    }
}
