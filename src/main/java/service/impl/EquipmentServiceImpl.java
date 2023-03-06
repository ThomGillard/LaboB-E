package service.impl;

import models.dto.EquipmentDTO;
import repository.EquipmentRepository;
import service.EquipmentService;
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
