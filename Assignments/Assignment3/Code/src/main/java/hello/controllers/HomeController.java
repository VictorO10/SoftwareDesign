package hello.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
class HomeController {

    @GetMapping("/")
    String index(Principal principal) {
        return principal != null ? "homeSignedIn" : "homeNotSignedIn";
    }
}

