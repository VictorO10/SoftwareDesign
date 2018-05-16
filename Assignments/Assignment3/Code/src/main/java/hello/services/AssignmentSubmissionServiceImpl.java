package hello.services;

import hello.models.AssignmentSubmission;
import hello.models.AssignmentSubmissionWUserAndLab;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class AssignmentSubmissionServiceImpl implements AssignmentSubmissionService{

    @Autowired
    AssignmentService assignmentService;

    @Autowired
    UserService userService;

    @Override
    public List<AssignmentSubmissionWUserAndLab> getAssignmentSubbmisions(Long iduser, Long idassignment) {

        String url = new String("http://localhost:8080/Submission");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        if(iduser != null) {
            builder.queryParam("iduser", iduser);
        }
        if(idassignment != null) {
            builder.queryParam("idassignment", idassignment);
        }

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<AssignmentSubmission>> assignmentSubmissionRespone =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<AssignmentSubmission>>() {
                });

        List<AssignmentSubmission> assignmentSubmissions = assignmentSubmissionRespone.getBody();

        ModelMapper modelMapper = new ModelMapper();
        //map Laboratory to LaboratoryWAssignments
        Type listType = new TypeToken<List<AssignmentSubmissionWUserAndLab>>() {}.getType();
        List<AssignmentSubmissionWUserAndLab> submissions = modelMapper.map(assignmentSubmissions, listType);

        for(AssignmentSubmissionWUserAndLab s : submissions) {
            s.setUser(userService.getUserByID(s.getIduser()));
            s.setAssignment(assignmentService.getAssignmentById(s.getIdassignment()));
        }

        return submissions;
    }

    @Override
    public void gradeAssignment(Long idSubmission, int grade) {

        System.out.println("GRADE ASSIGNMENT");
        String url = new String("http://localhost:8080/grade/gradeAssignmentSubmission");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.queryParam("idAssignmentSubmission", idSubmission);
        builder.queryParam("grade", grade);

        System.out.println(builder.toUriString());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();

        //HttpEntity<AssignmentSubmission> requestEntity = new HttpEntity<AssignmentSubmission>(assignment, headers);
        HttpEntity<AssignmentSubmission> response = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, null, AssignmentSubmission.class);

        AssignmentSubmission assignmentSubmission = response.getBody();
    }

    @Override
    public AssignmentSubmission submitAssignment(AssignmentSubmission assignmentSubmission) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();
        System.out.println("EMAIL: " + email);
        System.out.println(assignmentSubmission);

        String url = new String("http://localhost:8080/submitAssignment");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.queryParam("emailStudent", email);
        builder.queryParam("idassignment", assignmentSubmission.getIdassignment());
        builder.queryParam("gitRepo", assignmentSubmission.getGitrepo());
        builder.queryParam("remark", assignmentSubmission.getRemark());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<AssignmentSubmission> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, AssignmentSubmission.class);

        return response.getBody();
    }

}
