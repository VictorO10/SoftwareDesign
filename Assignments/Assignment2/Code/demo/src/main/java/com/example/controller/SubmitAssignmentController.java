package com.example.controller;

import com.example.model.service.contracts.AssignUserService;
import com.example.model.service.exceptions.DeadlinePassedException;
import com.example.model.service.models.AssignUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("submitAssignment")
public class SubmitAssignmentController {

    private final AssignUserService assignUserService;

    @Autowired
    public SubmitAssignmentController(AssignUserService assignUserService) {
        this.assignUserService = assignUserService;
    }

    @PostMapping("")
    public AssignUserDTO saveAssignmentSubmission(@RequestParam String emailStudent, @RequestParam Long idassignment, @RequestParam String gitRepo, @RequestParam String remark) {
        try {
            return assignUserService.submitAssignment(emailStudent, idassignment, gitRepo, remark);
        } catch(Exception e) {
            e.printStackTrace();
            throw new DeadlinePassedException();
        }
    }
}
