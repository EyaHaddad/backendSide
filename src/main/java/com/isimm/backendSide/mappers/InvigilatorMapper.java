package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.InvigilatorDto;
import com.isimm.backendSide.entities.Exam;
import com.isimm.backendSide.entities.Invigilator;
import com.isimm.backendSide.entities.Room;
import com.isimm.backendSide.entities.User;

public class InvigilatorMapper {
    public static InvigilatorDto mapToInvigilatorDto(Invigilator invigilator) {
        return new InvigilatorDto(
                invigilator.getInvigilatorId(),
                invigilator.getUser().getUserId(),
                invigilator.getExam().getExamId(),
                invigilator.getRoom().getRoomId()
//ne pas ajouter la date de creation car à chaque fois on va la changer et c'est pas logique
        );
    }

    public static Invigilator mapToInvigilator(Exam exam, Room room, User user) {
        return new Invigilator(
                user,exam,room
        );
    }
}
