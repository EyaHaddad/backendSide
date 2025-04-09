package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.ScheduleLogDto;
import com.isimm.backendSide.entities.ScheduleLog;
import com.isimm.backendSide.entities.User;

public class ScheduleLogMapper {
    public static ScheduleLogDto mapToScheduleLogDto(ScheduleLog scheduleLog) {
        return new ScheduleLogDto(
                scheduleLog.getLogId(),
                scheduleLog.getAction(),
                scheduleLog.getDescription(),
                scheduleLog.getPerformedBy().getUserId(),
                scheduleLog.getTimestamp()
        );
    }

    public static ScheduleLog mapToScheduleLog(ScheduleLogDto scheduleLogDto, User performedBy) {
        return new ScheduleLog(
                scheduleLogDto.getLogId(),
                scheduleLogDto.getAction(),
                scheduleLogDto.getDescription(),
                performedBy,
                scheduleLogDto.getTimestamp()
        );
    }
}
