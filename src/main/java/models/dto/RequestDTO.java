package models.dto;

import models.entity.Classroom;
import models.entity.Request;
import models.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class RequestDTO {
    private Long id;

    private LocalDateTime timeSlot;

    private LocalTime duration;

    private String reason;

    private String refuse;

    private Classroom classroom;

    private Set<EquipmentDTO> equipments;

    private User user;

    private User validator;

    public static RequestDTO toDto(Request entity){
        if( entity == null )
            return null;

        return RequestDTO.builder()
                .id(entity.getId())
                .timeSlot(entity.getTimeSlot())
                .duration(entity.getDuration())
                .reason(entity.getReason())
                .refuse(entity.getRefuse())
                .classroom(entity.getClassroom())
                .equipments(
                        entity.getEquipments().stream()
                                .map(EquipmentDTO::toDto)
                                .collect(Collectors.toSet())
                )
                .build();
    }

}
