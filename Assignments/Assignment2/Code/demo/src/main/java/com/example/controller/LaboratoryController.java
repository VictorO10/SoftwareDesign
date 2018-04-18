package com.example.controller;

import com.example.controller.exceptions.LaboratoryNotFoundException;
import com.example.model.service.contracts.LaboratoryService;
import com.example.model.service.models.LaboratoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("laboratories")
public class LaboratoryController {

    private final LaboratoryService laboratoryService;

    @Autowired
    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }


    //exceptions
    @ExceptionHandler(LaboratoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleLaboratoryNotFoundException() {
        return "Laboratory ID not found!";
    }

    @GetMapping("getLaboratories")
    public List<LaboratoryDTO> getAllLaboratorys(){
        try {
            return laboratoryService.getAllLaboratories();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getLaboratoryById")
    public LaboratoryDTO getLaboratoryById(@RequestParam Long idlaboratory){
        try {
            return laboratoryService.getLaboratoryByID(idlaboratory);
        } catch(Exception e) {
            e.printStackTrace();
            throw new LaboratoryNotFoundException();
        }
    }

    @PostMapping("saveLaboratory")
    public LaboratoryDTO saveLaboratory(@RequestBody LaboratoryDTO laboratoryDTO) {
        try {
            return laboratoryService.saveLaboratory(laboratoryDTO);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("updateLaboratory")
    public LaboratoryDTO updateLaboratory(@RequestParam Long idlaboratory, @RequestBody LaboratoryDTO laboratoryDTO){
        try {
            return laboratoryService.updateLaboratory(idlaboratory, laboratoryDTO);
        } catch(Exception e) {
            e.printStackTrace();
            throw new LaboratoryNotFoundException();
        }
    }

    @GetMapping("findByKeyword")
    public List<LaboratoryDTO> findByKeyword(@RequestParam String keyword) {
        return laboratoryService.findByKeyword(keyword);
    }

    @DeleteMapping("deleteLaboratoryById")
    public String deleteLaboratoryById(Long idlaboratory) {
        try {
            laboratoryService.deleteLaboratoryById(idlaboratory);
            return "Laboratory with id = " + idlaboratory + " successfully deleted!";
        } catch(Exception e) {
            e.getMessage();
            throw new LaboratoryNotFoundException();
        }
    }

    @DeleteMapping("deleteLaboratoryLabNb")
    public String deleteLaboratoryLabNb(Long labNb) {
        try {
            laboratoryService.deleteLaboratoryByLabNb(labNb);
            return "Laboratory with id = " + labNb + " successfully deleted!";
        } catch(Exception e) {
            e.getMessage();
            throw new LaboratoryNotFoundException();
        }
    }
}

