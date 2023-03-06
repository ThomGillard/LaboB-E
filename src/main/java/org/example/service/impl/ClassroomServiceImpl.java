package org.example.service.impl;

import org.example.models.dto.ClassroomDTO;
import org.example.repository.ClassroomRepository;
import org.example.service.ClassroomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<ClassroomDTO> getAll() {
        return classroomRepository.findAll().stream()
                .map( ClassroomDTO::toDto )
                .toList();
    }
}
