package com.example.controller;

import com.example.model.service.contracts.AttendanceService;
import com.example.model.service.models.AttendanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("presence")
public class PresenceController {

    private final AttendanceService attendanceService;

    @Autowired
    public PresenceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("")
    public AttendanceDTO markPresent(@RequestParam Long iduser, @RequestParam Long idlaboratory, @RequestParam int bonusPoints) {
        return attendanceService.markPresent(iduser, idlaboratory, bonusPoints);
    }
}
