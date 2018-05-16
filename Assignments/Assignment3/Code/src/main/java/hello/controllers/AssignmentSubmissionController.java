package hello.controllers;

import hello.models.AssignmentSubmission;
import hello.models.AssignmentSubmissionWUserAndLab;
import hello.services.AssignmentSubmissionService;
import hello.services.UserService;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("submission")
public class AssignmentSubmissionController {

    @Autowired
    AssignmentSubmissionService assignmentSubmissionService;

    @Autowired
    UserService userService;

    @GetMapping
    public String getSubmissions(@RequestParam(required=false) Long iduser, @RequestParam(required = false) Long idassignment, Model model) {

        List<AssignmentSubmissionWUserAndLab> assignmentSubmissions = assignmentSubmissionService.getAssignmentSubbmisions(iduser, idassignment);

        for(AssignmentSubmissionWUserAndLab a: assignmentSubmissions) {
            System.out.println(a);
        }

        model.addAttribute("submissions", assignmentSubmissions);


        return "submission";
    }

    @PostMapping
    public String submitSolution(@ModelAttribute AssignmentSubmission assignmentSubmission, Model model){
        try {

            AssignmentSubmission assignmentSubmission1 = assignmentSubmissionService.submitAssignment(assignmentSubmission);


            return getSubmissions(null, assignmentSubmission.getIdassignment(), model);

        } catch(Exception e) {
            e.printStackTrace();
            // throw new AssignmentNotFoundException();

            return "error";
        }
    }

    @PostMapping("{id}")
    public String gradeSubmission(@PathVariable("id") Long idsubmission, @ModelAttribute("grade") String grade, Model model){
        System.out.println("UPDATE ASS BY ID");
        try {


            System.out.println(grade);

            int intGrade = Integer.parseInt(grade);
            assignmentSubmissionService.gradeAssignment(idsubmission, intGrade);

            return "submission";

        } catch(Exception e) {
            e.printStackTrace();
            // throw new AssignmentNotFoundException();

            return "error";
        }
    }

}
