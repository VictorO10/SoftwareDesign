package hello.controllers;

import hello.models.Assignment;
import hello.services.AssignmentService;
import hello.services.AssignmentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Onuca") String name, Model model){

        model.addAttribute("name", name);
        return "greeting";
    }

}
