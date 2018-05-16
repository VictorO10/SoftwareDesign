package hello.controllers;

import hello.models.Assignment;
import hello.models.AssignmentSubmission;
import hello.services.AssignmentService;
import hello.services.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("assignments")
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @Autowired
    AssignmentSubmissionService assignmentSubmissionService;

    @GetMapping("{id}")
    public String getAssignmentById(@PathVariable("id") Long idassignment, Model model){
        System.out.println("GET ASS BY ID");
        try {

            Assignment assignment1 = new Assignment();

//            assignment1.setIdlaboratory(Long.parseLong("50"));
//            assignment1.setName("CACA MA PIS PE EA DE TREABA");
//            Assignment assignment2 = assignmentService.createAssignment(assignment1);

            Assignment assignment = assignmentService.getAssignmentById(idassignment);
            model.addAttribute("assignment", assignment);

            return "assignment";

        } catch(Exception e) {
            e.printStackTrace();
           // throw new AssignmentNotFoundException();

            return "error";
        }
    }

    @PostMapping
    public String createNewAssignment(@ModelAttribute Assignment assignmentU, Model model) {
        System.out.println("CREATE ASS");
        try {

            System.out.println(assignmentU);
            Assignment assignment = assignmentService.createAssignment(assignmentU);

            model.addAttribute("assignment", assignment);

            return "assignment";

        } catch(Exception e) {
            e.printStackTrace();
            // throw new AssignmentNotFoundException();

            return "error";
        }

    }


    @PostMapping("{id}")
    public String updateAssignmentById(@PathVariable("id") Long idassignment, @ModelAttribute Assignment assignmentU, Model model){
        System.out.println("UPDATE ASS BY ID");
        try {

            Assignment assignment = assignmentService.updateAssignment(idassignment, assignmentU);
            System.out.println("PASUL 2");

            model.addAttribute("assignment", assignment);

            return "assignment";

        } catch(Exception e) {
            e.printStackTrace();
            // throw new AssignmentNotFoundException();

            return "error";
        }
    }

    @DeleteMapping("{id}")
    public String deleteAssignment(@PathVariable("id") Long assignmentid) {
        System.out.println(assignmentService.deleteAssignment(assignmentid));

        return "index";
    }


    @ModelAttribute(value = "submissionModel")
    public AssignmentSubmission newAssignmentSubmission()
    {
        return new AssignmentSubmission();
    }

}
