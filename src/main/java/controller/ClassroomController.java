package controller;

import models.dto.ClassroomDTO;
import service.ClassroomService;
import service.EquipmentService;
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
