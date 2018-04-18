package com.example.controller;

import com.example.controller.exceptions.AssignUserNotFoundException;
import com.example.model.service.contracts.AssignUserService;
import com.example.model.service.models.AssignUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assignUser")
public class AssignUserController {

    private final AssignUserService assignUserService;

    @Autowired
    public AssignUserController(AssignUserService assignUserService) {
        this.assignUserService = assignUserService;
    }


    //exceptions
    @ExceptionHandler(AssignUserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleAssignUserNotFoundException() {
        return "AssignUser ID not found!";
    }

    @GetMapping("getAssignUsers")
    public List<AssignUserDTO> getAllAssignUsers(){
        try {
            return assignUserService.getAllAssignUsers();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getAssignUserById")
    public AssignUserDTO getAssignUserById(@RequestParam Long idassignUser){
        try {
            return assignUserService.getAssignUserByID(idassignUser);
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssignUserNotFoundException();
        }
    }

    @GetMapping("findAssignmentSubmissionByUserId")
    public List<AssignUserDTO> findAssignmentSubmissionByUserId(@RequestParam Long iduser){
        try{
            List<AssignUserDTO> assignUsers = assignUserService.findByIduser(iduser);
            return assignUsers;
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssignUserNotFoundException();
        }
    }

    @GetMapping("findAssignmentSubmissionByAssignmentId")
    public List<AssignUserDTO> findAssignmentSubmissionByAssignmentId(@RequestParam Long idassignment){
        try{
            List<AssignUserDTO> assignUsers = assignUserService.findByIdassignment(idassignment);
            return assignUsers;
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssignUserNotFoundException();
        }
    }

    @PostMapping("submitAssignment")
    public AssignUserDTO saveAssignmentSubmission(@RequestParam String emailStudent, @RequestParam Long idassignment, @RequestParam String gitRepo, @RequestParam String remark) {
        return assignUserService.submitAssignment(emailStudent, idassignment, gitRepo, remark);
    }

    @PutMapping("gradeAssignmentSubmission")
    public AssignUserDTO gradeAssignmentSubmission(@RequestParam Long idAssignmentSubmission, int grade) {
        return assignUserService.gradeAssignmentSubmission(idAssignmentSubmission, grade);
    }

    @PostMapping("saveAssignUser")
    public AssignUserDTO saveAssignUser(@RequestBody AssignUserDTO assignUserDTO) {
        try {
            return assignUserService.saveAssignUser(assignUserDTO);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("updateAssignUser")
    public AssignUserDTO updateAssignUser(@RequestParam Long idassignUser, @RequestBody AssignUserDTO assignUserDTO){
        try {
            return assignUserService.updateAssignUser(idassignUser, assignUserDTO);
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssignUserNotFoundException();
        }
    }

    @DeleteMapping("deleteAssignUserById")
    public String deleteAssignUserById(Long idassignUser) {
        try {
            assignUserService.deleteAssignUserById(idassignUser);
            return "AssignUser with id = " + idassignUser + " successfully deleted!";
        } catch(Exception e) {
            e.getMessage();
            throw new AssignUserNotFoundException();
        }
    }
}
