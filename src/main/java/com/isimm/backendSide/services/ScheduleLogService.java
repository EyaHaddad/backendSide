package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.ScheduleLogDto;
import com.isimm.backendSide.entities.ScheduleLog;

import java.util.List;

public interface ScheduleLogService {
    ScheduleLogDto createScheduleLog(ScheduleLogDto ScheduleLogDto);
    ScheduleLogDto getScheduleLogById (Long ScheduleLogId);
    List<ScheduleLogDto> getAllScheduleLog();
    ScheduleLogDto updateScheduleLog(Long ScheduleLogId, ScheduleLogDto updatedScheduleLog);
    void deleteScheduleLog (Long ScheduleLogId);
}
