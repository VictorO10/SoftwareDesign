package com.example.controller;

import com.example.controller.exceptions.AttendanceNotFoundException;
import com.example.model.service.contracts.AttendanceService;
import com.example.model.service.models.AttendanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @GetMapping("")
    public List<AttendanceDTO> getAllAttendances(@RequestParam(required=false) Long iduser, @RequestParam(required=false) Long idlaboratory){
        try {
            return attendanceService.getAllAttendances();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("{id}")
    public AttendanceDTO getAttendanceById(@PathVariable("id")Long attendanceId){
        try {
            System.out.println("id" + attendanceId);
            return attendanceService.getAttendanceByID(attendanceId);
        } catch(Exception e) {
            e.printStackTrace();
            throw new AttendanceNotFoundException();
        }
    }

//    @GetMapping("")
//    public List<AttendanceDTO> findAttendanceByUserId(@RequestParam(required=false) Long iduser, @RequestParam(required=false) Long idlaboratory){
//
//        try{
//            if(iduser != null) {
//                List<AttendanceDTO> attendances = attendanceService.findByIduser(iduser);
//                return attendances;
//            } else {
//                if(idlaboratory != null) {
//                    List<AttendanceDTO> attendances = attendanceService.findByIdlaboratory(idlaboratory);
//                    return attendances;
//                } else {
//                    return null;
//                }
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//            throw new AttendanceNotFoundException();
//        }
//    }

//    @GetMapping("")
//    public List<AttendanceDTO> findAttendanceByLaboratoryId(){
//        try{
//            List<AttendanceDTO> attendances = attendanceService.findByIdlaboratory(idlaboratory);
//            return attendances;
//        } catch(Exception e) {
//            e.printStackTrace();
//            throw new AttendanceNotFoundException();
//        }
//    }

    @PostMapping("")
    public AttendanceDTO saveAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        try {
            return attendanceService.saveAttendance(attendanceDTO);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("")
    public AttendanceDTO updateAttendance(@RequestParam Long idattendance, @RequestBody AttendanceDTO attendanceDTO){
        try {
            return attendanceService.updateAttendance(idattendance, attendanceDTO);
        } catch(Exception e) {
            e.printStackTrace();
            throw new AttendanceNotFoundException();
        }
    }

    @DeleteMapping("{id}")
    public String deleteAttendanceById(@PathVariable("id")Long idattendance) {
        try {
            attendanceService.deleteAttendanceById(idattendance);
            return "Attendance with id = " + idattendance + " successfully deleted!";
        } catch(Exception e) {
            e.getMessage();
            throw new AttendanceNotFoundException();
        }
    }
}
