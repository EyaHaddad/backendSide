package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.ScheduleLogDto;
import com.isimm.backendSide.entities.ScheduleLog;
import com.isimm.backendSide.entities.User;
import com.isimm.backendSide.exceptions.RessourceNotFoundException;
import com.isimm.backendSide.mappers.ScheduleLogMapper;
import com.isimm.backendSide.repositories.ScheduleLogRepository;
import com.isimm.backendSide.services.ScheduleLogService;
import com.isimm.backendSide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleLogServiceImpl implements ScheduleLogService {
    
    @Autowired
    private ScheduleLogRepository scheduleLogRepository;
    @Autowired
    private UserService userService;

    @Override
    public ScheduleLogDto createScheduleLog(ScheduleLogDto scheduleLogDto) {
        User user =userService.findById(scheduleLogDto.getPerformedBy());
        ScheduleLog ScheduleLog = ScheduleLogMapper.mapToScheduleLog(scheduleLogDto, user);
        user.getScheduleLogs().add(ScheduleLog);
        ScheduleLog savedScheduleLog = scheduleLogRepository.save(ScheduleLog);
        return ScheduleLogMapper.mapToScheduleLogDto(savedScheduleLog);
    }

    @Override
    public ScheduleLogDto getScheduleLogById(Long ScheduleLogId) {
        ScheduleLog dep = scheduleLogRepository.findById(ScheduleLogId)
                .orElseThrow(()->new RessourceNotFoundException("ScheduleLog is not exists with the given id :"+ScheduleLogId));
        return ScheduleLogMapper.mapToScheduleLogDto(dep);
    }

    @Override
    public List<ScheduleLogDto> getAllScheduleLog() {
        List<ScheduleLog> ScheduleLogs = scheduleLogRepository.findAll();
        return ScheduleLogs.stream().map(ScheduleLogMapper::mapToScheduleLogDto)
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleLogDto updateScheduleLog(Long ScheduleLogId, ScheduleLogDto updatedScheduleLog) {
        ScheduleLog ScheduleLog = scheduleLogRepository.findById(ScheduleLogId).orElseThrow(
                ()-> new RessourceNotFoundException("ScheduleLog is not exists with given id :"+ScheduleLogId));
        ScheduleLog.getPerformedBy().getScheduleLogs().remove(ScheduleLog);
        ScheduleLog.setAction(updatedScheduleLog.getAction());
        ScheduleLog.setDescription(updatedScheduleLog.getDescription());
        User user = userService.findById(updatedScheduleLog.getPerformedBy());
        ScheduleLog.setPerformedBy(user);
        user.getScheduleLogs().add(ScheduleLog);
        scheduleLogRepository.save(ScheduleLog);
        return ScheduleLogMapper.mapToScheduleLogDto(ScheduleLog);
    }

    @Override
    public void deleteScheduleLog(Long ScheduleLogId) {
        ScheduleLog ScheduleLog = scheduleLogRepository.findById(ScheduleLogId).orElseThrow(
                ()-> new RessourceNotFoundException("ScheduleLog is not exists with given id :"+ScheduleLogId));
        ScheduleLog.getPerformedBy().getScheduleLogs().add(ScheduleLog);
        scheduleLogRepository.deleteById(ScheduleLogId);
    }
}
