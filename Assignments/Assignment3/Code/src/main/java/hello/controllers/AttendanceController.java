package hello.controllers;

import hello.models.AttendanceWEmail;
import hello.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @GetMapping
    public String getAllAttendances(@RequestParam(required=false) String email, @RequestParam(required = false) Long idlaboratory, Model model){

        model.addAttribute("attendances", attendanceService.getAllAttendances(email, idlaboratory));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String emaill = authentication.getName();

        model.addAttribute("currentUser", emaill);

        return "attendance";
    }

    @PostMapping
    public String createAttendance(@ModelAttribute AttendanceWEmail attendanceWEmail, Model model) {

        System.out.println(attendanceWEmail.getEmail());

        attendanceService.createAttendance(
                attendanceWEmail.getEmail(),
                attendanceWEmail.getIdlaboratory()
        );

        return getAllAttendances(null, null, model);
    }

    @ModelAttribute(value = "attendanceWEmailModel")
    public AttendanceWEmail newAssignment()
    {
        AttendanceWEmail attendanceWEmail = new AttendanceWEmail();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String emaill = authentication.getName();

        return attendanceWEmail;
    }
}
