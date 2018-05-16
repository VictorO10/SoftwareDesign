package hello.controllers;

import hello.models.Assignment;
import hello.models.Laboratory;
import hello.models.LaboratoryWAssignments;
import hello.models.LabsWrapper;
import hello.services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("laboratory")
public class LaboratoryController {

    @Autowired
    LaboratoryService laboratoryService;

    @GetMapping()
    public String getLaboratory(@RequestParam(required = false) String keyword, Model model) {

        List<LaboratoryWAssignments> laboratorys = laboratoryService.getAllLaboratories(keyword);
        LabsWrapper labsWrapper = new LabsWrapper();
        labsWrapper.setLabs(laboratorys);

        model.addAttribute("laboratorys", labsWrapper);

        return "laboratory";
    }

    @GetMapping("{id}")
    public String getLaboratoryById(@PathVariable("id") Long labId, Model model) {

        LaboratoryWAssignments laboratoryWAssignments = laboratoryService.getLaboratoryById(labId);

        List<LaboratoryWAssignments> laboratorys = new ArrayList<>();
        laboratorys.add(laboratoryWAssignments);

        model.addAttribute("laboratorys", laboratorys);

        return "laboratory";
    }

    @PostMapping
    public String createLaboratory(@ModelAttribute LaboratoryWAssignments laboratory) {

        laboratoryService.createLaboratory(laboratory);

        return "index";
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @PostMapping("{id}")
    public String updateLaboratory(@PathVariable("id") Long labId, @ModelAttribute LaboratoryWAssignments laboratory) {

        System.out.println(laboratory);
        laboratory.setIdlaboratory(labId);

        Laboratory laboratoryl = laboratoryService.updateLaboratory(laboratory);

        return "index";
    }

    @DeleteMapping("{id}")
    public String deleteLaboratory(@PathVariable("id") Long labId) {
        System.out.println(laboratoryService.deletelaboratory(labId));



        return "index";
    }

    @ModelAttribute(value = "assignment")
    public Assignment newAssignment()
    {
        return new Assignment();
    }
}
