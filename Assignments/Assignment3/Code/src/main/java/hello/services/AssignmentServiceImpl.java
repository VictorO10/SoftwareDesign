package hello.services;

import hello.models.Assignment;
import hello.models.Laboratory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
public class AssignmentServiceImpl implements AssignmentService {


    @Autowired
    LaboratoryService laboratoryService;

    @Override
    public List<Assignment> getAllAssignments(Long labId) {
        String url = new String("http://localhost:8080/assignments");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        if(labId != null) {
            builder.queryParam("laboratoryId", labId);
        }

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Assignment>> assignmentRespone =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Assignment>>() {
                });

        List<Assignment> assignments = assignmentRespone.getBody();

        System.out.println(assignments.size());

       return  assignments;
    }

    @Override
    public Assignment getAssignmentById(Long assignmentId) {
        String url = new String("http://localhost:8080/assignments");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.pathSegment(assignmentId.toString());

        System.out.println(builder.toUriString());

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Assignment> assignmentRespone =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<Assignment>() {
                });

        Assignment assignment = assignmentRespone.getBody();

        return  assignment;
    }

    @Override
    public Assignment updateAssignment(Long assignmentId, Assignment assignment) {

        String url = new String("http://localhost:8080/assignments");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.queryParam("idassignment", assignmentId);

        System.out.println("PASUL 1.1");

        assignment.setIdlaboratory(getAssignmentById(assignmentId).getIdlaboratory());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Assignment> requestEntity = new HttpEntity<Assignment>(assignment, headers);
        HttpEntity<Assignment> response = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, requestEntity, Assignment.class);

        Assignment respAssignment = response.getBody();

        return respAssignment;
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        String url = new String("http://localhost:8080/assignments");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        assignment.setIdlaboratory((laboratoryService.getLaboratoryByLabNb(assignment.getIdlaboratory())).getIdlaboratory());


        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Assignment> requestEntity = new HttpEntity<Assignment>(assignment, headers);
        HttpEntity<Assignment> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, Assignment.class);

        Assignment respAssignment = response.getBody();

        return respAssignment;
    }

    @Override
    public String deleteAssignment(Long idassignment) {
        String url = new String("http://localhost:8080/assignments");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.pathSegment(idassignment.toString());

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, null, String.class);

        System.out.println(response.getBody());

        return response.getBody();
    }


    @Override
    public Assignment findById(Long assignmentId) {
        return null;
    }
}
