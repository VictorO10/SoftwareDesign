package com.example.controller;

import com.example.controller.exceptions.AssignUserNotFoundException;
import com.example.model.service.contracts.AssignUserService;
import com.example.model.service.exceptions.DeadlinePassedException;
import com.example.model.service.models.AssignUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Submission")
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

    //exceptions
    @ExceptionHandler(DeadlinePassedException.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String handleDeadlinePassedException(){
        return "The deadline has passed!";
    }

    @GetMapping("")
    public List<AssignUserDTO> getAllAssignUsers(@RequestParam(required=false) Long iduser, @RequestParam(required=false) Long idassignment){
        try {
            return assignUserService.getAllAssignUsers();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("{id}")
    public AssignUserDTO getAssignUserById(@PathVariable("id") Long idassignUser){
        try {
            return assignUserService.getAssignUserByID(idassignUser);
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssignUserNotFoundException();
        }
    }

//    @GetMapping("findAssignmentSubmissionByUserId")
//    public List<AssignUserDTO> findAssignmentSubmissionByUserId(@RequestParam Long iduser){
//        try{
//            List<AssignUserDTO> assignUsers = assignUserService.findByIduser(iduser);
//            return assignUsers;
//        } catch(Exception e) {
//            e.printStackTrace();
//            throw new AssignUserNotFoundException();
//        }
//    }
//
//    @GetMapping("findAssignmentSubmissionByAssignmentId")
//    public List<AssignUserDTO> findAssignmentSubmissionByAssignmentId(@RequestParam Long idassignment){
//        try{
//            List<AssignUserDTO> assignUsers = assignUserService.findByIdassignment(idassignment);
//            return assignUsers;
//        } catch(Exception e) {
//            e.printStackTrace();
//            throw new AssignUserNotFoundException();
//        }
//    }

    @PostMapping("")
    public AssignUserDTO saveAssignUser(@RequestBody AssignUserDTO assignUserDTO) {
        try {
            return assignUserService.saveAssignUser(assignUserDTO);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("")
    public AssignUserDTO updateAssignUser(@RequestParam Long idassignUser, @RequestBody AssignUserDTO assignUserDTO){
        try {
            return assignUserService.updateAssignUser(idassignUser, assignUserDTO);
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssignUserNotFoundException();
        }
    }

    @DeleteMapping("{id}")
    public String deleteAssignUserById(@PathVariable("id") Long idassignUser) {
        try {
            assignUserService.deleteAssignUserById(idassignUser);
            return "AssignUser with id = " + idassignUser + " successfully deleted!";
        } catch(Exception e) {
            e.getMessage();
            throw new AssignUserNotFoundException();
        }
    }
}
