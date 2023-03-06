package org.example.controller;

import org.example.models.dto.RequestDTO;
import org.example.models.form.RequestNewForm;
import org.example.service.EquipmentService;
import org.example.service.RequestService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;
    private final EquipmentService equipmentService;

    public RequestController(RequestService requestService, EquipmentService equipmentService) {
        this.requestService = requestService;
        this.equipmentService = equipmentService;
    }

    //GET - /request/all
    @GetMapping("/mine")
    public List<RequestDTO> getAllSelf(Authentication auth){
        return requestService.getAllSelf(auth);
    }

    @GetMapping("/all")
    public List<RequestDTO> getAll(){
        return requestService.getAll();
    }

    //POST - /request/add
    @PostMapping("/add")
    public void processInsertForm(@RequestBody @Valid RequestNewForm form,Authentication auth){
        requestService.insert(form, auth);
    }

    //POST - /request/add
    @DeleteMapping ("/{id:[0-9]+}/delete")
    public void delete(@PathVariable long id){
        requestService.delete(id);
    }

    @PatchMapping("/{id:[0-9]+}/refuse")
    public void refuse(@PathVariable long id){
        requestService.refuse(id);
    }

    //@GetMapping Mapping("/{id:[0-9]+}/manage")


}
