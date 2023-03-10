package org.example.models.dto;

import org.example.models.entity.Equipment;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class EquipmentDTO {

    private Long id;

    private String name;

    private Set<ClassroomDTO> classrooms;

    private Set<RequestDTO> requests;

    public static EquipmentDTO toDto(Equipment entity) {
        if( entity == null )
            return null;

        return EquipmentDTO.builder()
                .id( entity.getId() )
                .name( entity.getName() )
                .build();
    }
}
