package service.impl;

import models.dto.ClassroomDTO;
import repository.ClassroomRepository;
import service.ClassroomService;
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
