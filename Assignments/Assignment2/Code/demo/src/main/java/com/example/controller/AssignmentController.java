package com.example.controller;

import com.example.controller.exceptions.AssignmentNotFoundException;
import com.example.model.service.contracts.AssignmentService;
import com.example.model.service.models.AssignmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }


    //exceptions
    @ExceptionHandler(AssignmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleAssignmentNotFoundException() {
        return "Assignment ID not found!";
    }

    @GetMapping("")
    public List<AssignmentDTO> getAllAssignments(@RequestParam(required=false) Long laboratoryId){
        try {
            return assignmentService.getAllAssignments();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("{id}")
    public AssignmentDTO getAssignmentById(@PathVariable("id") Long idassignment){
        try {
            return assignmentService.getAssignmentByID(idassignment);
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssignmentNotFoundException();
        }
    }

//    @GetMapping("findAssignmentByLaboratoryId")
//    public List<AssignmentDTO> findAssignmentByLaboratoryId(@RequestParam Long idlaboratory){
//        try{
//            List<AssignmentDTO> assignments = assignmentService.findByIdlaboratory(idlaboratory);
//            return assignments;
//
//        } catch(Exception e) {
//            e.printStackTrace();
//            throw new AssignmentNotFoundException();
//        }
//    }

    @PostMapping("")
    public AssignmentDTO saveAssignment(@RequestBody AssignmentDTO assignmentDTO) {
        try {
            return assignmentService.saveAssignment(assignmentDTO);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("")
    public AssignmentDTO updateAssignment(@RequestParam Long idassignment, @RequestBody AssignmentDTO assignmentDTO){
        try {
            return assignmentService.updateAssignment(idassignment, assignmentDTO);
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssignmentNotFoundException();
        }
    }

    @DeleteMapping("{id}")
    public String deleteAssignmentById(@PathVariable("id") Long idassignment) {
        try {
            assignmentService.deleteAssignmentById(idassignment);
            return "Assignment with id = " + idassignment + " successfully deleted!";
        } catch(Exception e) {
            e.getMessage();
            throw new AssignmentNotFoundException();
        }
    }
}
