package com.example.controller;

import com.example.controller.exceptions.AttendanceNotFoundException;
import com.example.model.service.contracts.AttendanceService;
import com.example.model.service.models.AttendanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }


    //exceptions
    @ExceptionHandler(AttendanceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleAttendanceNotFoundException() {
        return "Attendance ID not found!";
    }

    @GetMapping("getAttendances")
    public List<AttendanceDTO> getAllAttendances(){
        try {
            return attendanceService.getAllAttendances();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getAttendanceById")
    public AttendanceDTO getAttendanceById(@RequestParam Long idattendance){
        try {
            return attendanceService.getAttendanceByID(idattendance);
        } catch(Exception e) {
            e.printStackTrace();
            throw new AttendanceNotFoundException();
        }
    }

    @GetMapping("findAttendanceByUserId")
    public List<AttendanceDTO> findAttendanceByUserId(@RequestParam Long iduser){
        try{
            List<AttendanceDTO> attendances = attendanceService.findByIduser(iduser);
            return attendances;
        } catch(Exception e) {
            e.printStackTrace();
            throw new AttendanceNotFoundException();
        }
    }

    @GetMapping("findAttendanceByLaboratoryId")
    public List<AttendanceDTO> findAttendanceByLaboratoryId(@RequestParam Long idlaboratory){
        try{
            List<AttendanceDTO> attendances = attendanceService.findByIdlaboratory(idlaboratory);
            return attendances;
        } catch(Exception e) {
            e.printStackTrace();
            throw new AttendanceNotFoundException();
        }
    }

    @PostMapping("markPresent")
    public AttendanceDTO markPresent(@RequestParam Long iduser, @RequestParam Long idlaboratory, @RequestParam int bonusPoints) {
        return attendanceService.markPresent(iduser, idlaboratory, bonusPoints);
    }

    @PostMapping("saveAttendance")
    public AttendanceDTO saveAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        try {
            return attendanceService.saveAttendance(attendanceDTO);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("updateAttendance")
    public AttendanceDTO updateAttendance(@RequestParam Long idattendance, @RequestBody AttendanceDTO attendanceDTO){
        try {
            return attendanceService.updateAttendance(idattendance, attendanceDTO);
        } catch(Exception e) {
            e.printStackTrace();
            throw new AttendanceNotFoundException();
        }
    }

    @DeleteMapping("deleteAttendanceById")
    public String deleteAttendanceById(Long idattendance) {
        try {
            attendanceService.deleteAttendanceById(idattendance);
            return "Attendance with id = " + idattendance + " successfully deleted!";
        } catch(Exception e) {
            e.getMessage();
            throw new AttendanceNotFoundException();
        }
    }
}
