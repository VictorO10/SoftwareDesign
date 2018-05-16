package hello.controllers;

import hello.models.User;
import hello.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class RegisterController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @GetMapping("registerByTeacher")
    public String getForm(Model model) {
        model.addAttribute("topMessage", "");
        return "registerByTeacher";
    }

//    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @PostMapping("registerByTeacher")
    public String createUser(@ModelAttribute User user, Model model) {

        System.out.println("CREATE NEW USER");
        User userl = userService.registerStudent(user.getEmail(),
                user.getFullName(),
                user.getGroupName(),
                user.getHobby());

        if(userl != null) {
            model.addAttribute("topMessage", "User " + user.getEmail() + " added");
        } else {
            model.addAttribute("topMessage", "User could NOT be added");
        }

        return "registerByTeacher";
    }

    @GetMapping("registerByStudent")
    public String getFormStudent(Model model) {
        model.addAttribute("topMessage", "");
        return "registerByStudent";
    }

    @PostMapping("registerByStudent")
    public String createUserStudent(@ModelAttribute User user, Model model) {

        System.out.println("CREATE NEW USER WITH TOKEN");
        User userl = userService.registerWithToken(
                user.getEmail(),
                user.getToken(),
                user.getPassword());

        if(userl != null) {
            model.addAttribute("topMessage", "Welcome to our website, " + userl.getFullName() + " !");
        } else {
            model.addAttribute("topMessage", "Something went wrong");
        }

        return "registerByStudent";
    }

    @ModelAttribute(value = "userModel")
    public User newUserModel()
    {
        User user = new User();

        user.setGroupName("30431");
        user.setHobby("Tema la SD");

        return user;
    }
}
