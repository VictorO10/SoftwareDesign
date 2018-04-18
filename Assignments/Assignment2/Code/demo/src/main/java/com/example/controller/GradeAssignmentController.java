package com.example.controller;

import com.example.model.service.contracts.AssignUserService;
import com.example.model.service.models.AssignUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("grade")
public class GradeAssignmentController {

    private final AssignUserService assignUserService;

    @Autowired
    public GradeAssignmentController(AssignUserService assignUserService) {
        this.assignUserService = assignUserService;
    }
    @PutMapping("gradeAssignmentSubmission")
    public AssignUserDTO gradeAssignmentSubmission(@RequestParam Long idAssignmentSubmission, int grade) {
        return assignUserService.gradeAssignmentSubmission(idAssignmentSubmission, grade);
    }
}
