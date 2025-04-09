package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.InvigilatorDto;
import com.isimm.backendSide.entities.Exam;
import com.isimm.backendSide.entities.Invigilator;
import com.isimm.backendSide.entities.Room;
import com.isimm.backendSide.entities.User;
import com.isimm.backendSide.exceptions.RessourceNotFoundException;
import com.isimm.backendSide.mappers.InvigilatorMapper;
import com.isimm.backendSide.repositories.InvigilatorRepository;
import com.isimm.backendSide.services.ExamService;
import com.isimm.backendSide.services.InvigilatorService;
import com.isimm.backendSide.services.RoomService;
import com.isimm.backendSide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvigilatorServiceImpl implements InvigilatorService {
    @Autowired
    private InvigilatorRepository invigilatorRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ExamService examService;
    @Autowired
    private RoomService roomService;

    @Override
    public InvigilatorDto createInvigilator(InvigilatorDto InvigilatorDto) {
        User user = userService.findById(InvigilatorDto.getUser());
        Exam exam = examService.findById(InvigilatorDto.getExam());
        Room room = roomService.findById(InvigilatorDto.getRoom());
        Invigilator invigilator = InvigilatorMapper.mapToInvigilator(exam, room, user);
        user.getInvigilators().add(invigilator);
        exam.getInvigilators().add(invigilator);
        room.getInvigilators().add(invigilator);
        Invigilator savedInvigilator = invigilatorRepository.save(invigilator);
        return InvigilatorMapper.mapToInvigilatorDto(savedInvigilator);
    }

    @Override
    public InvigilatorDto getInvigilatorById(Long InvigilatorId) {
        Invigilator dep = invigilatorRepository.findById(InvigilatorId)
                .orElseThrow(()->new RessourceNotFoundException("Invigilator is not exists with the given id :"+InvigilatorId));
        return InvigilatorMapper.mapToInvigilatorDto(dep);
    }

    @Override
    public List<InvigilatorDto> getAllInvigilator() {
        List<Invigilator> invigilators = invigilatorRepository.findAll();
        return invigilators.stream().map(InvigilatorMapper::mapToInvigilatorDto)
                .collect(Collectors.toList());
    }

    @Override
    public InvigilatorDto updateInvigilator(Long InvigilatorId, InvigilatorDto updatedInvigilator) {
        Invigilator invigilator = invigilatorRepository.findById(InvigilatorId).orElseThrow(
                ()-> new RessourceNotFoundException("Invigilator is not exists with given id :"+InvigilatorId));
        invigilator.getUser().getInvigilators().remove(invigilator);
        invigilator.getExam().getInvigilators().remove(invigilator);
        invigilator.getRoom().getInvigilators().remove(invigilator);
        User userNew = userService.findById(updatedInvigilator.getUser());
        Exam examNew = examService.findById(updatedInvigilator.getExam());
        Room roomNew = roomService.findById(updatedInvigilator.getRoom());
        invigilator.setUser(userNew);
        invigilator.setExam(examNew);
        invigilator.setRoom(roomNew);
        userNew.getInvigilators().add(invigilator);
        examNew.getInvigilators().add(invigilator);
        roomNew.getInvigilators().add(invigilator);
        invigilatorRepository.save(invigilator);
        return InvigilatorMapper.mapToInvigilatorDto(invigilator);
    }

    @Override
    public void deleteInvigilator(Long invigilatorId) {
        Invigilator invigilator = invigilatorRepository.findById(invigilatorId).orElseThrow(
                ()-> new RessourceNotFoundException("Invigilator is not exists with given id :"+invigilatorId));
        invigilator.getExam().getInvigilators().remove(invigilator);
        invigilator.getRoom().getInvigilators().remove(invigilator);
        invigilator.getUser().getInvigilators().remove(invigilator);
        invigilatorRepository.deleteById(invigilatorId);
    }
}
