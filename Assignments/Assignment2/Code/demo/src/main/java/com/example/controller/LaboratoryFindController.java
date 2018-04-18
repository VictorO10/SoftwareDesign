package com.example.controller;

import com.example.model.service.contracts.LaboratoryService;
import com.example.model.service.models.LaboratoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("find")
public class LaboratoryFindController {

    private final LaboratoryService laboratoryService;

    @Autowired
    public LaboratoryFindController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @GetMapping("")
    public List<LaboratoryDTO> findByKeyword(@RequestParam String keyword) {
        return laboratoryService.findByKeyword(keyword);
    }
}
