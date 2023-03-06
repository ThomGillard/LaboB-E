package org.example.service.impl;

import org.example.models.dto.EquipmentDTO;
import org.example.repository.EquipmentRepository;
import org.example.service.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<EquipmentDTO> getAll() {
        return equipmentRepository.findAll().stream()
                .map( EquipmentDTO::toDto )
                .toList();
    }
}
