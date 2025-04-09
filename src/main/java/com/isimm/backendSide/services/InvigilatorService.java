package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.InvigilatorDto;
import com.isimm.backendSide.entities.Invigilator;

import java.util.List;

public interface InvigilatorService {
    InvigilatorDto createInvigilator(InvigilatorDto InvigilatorDto);
    InvigilatorDto getInvigilatorById (Long InvigilatorId);
    List<InvigilatorDto> getAllInvigilator();
    InvigilatorDto updateInvigilator(Long InvigilatorId, InvigilatorDto updatedInvigilator);
    void deleteInvigilator (Long InvigilatorId);
}
