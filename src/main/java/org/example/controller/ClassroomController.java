package org.example.controller;

import org.example.models.dto.ClassroomDTO;
import org.example.service.ClassroomService;
import org.example.service.EquipmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService, EquipmentService equipmentService) {
        this.classroomService = classroomService;
    }

    //GET - /classroom
    @GetMapping("/all")
    public List<ClassroomDTO> getAll(){
        return classroomService.getAll();
    }
}
