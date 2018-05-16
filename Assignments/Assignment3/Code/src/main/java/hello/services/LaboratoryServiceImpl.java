package hello.services;

import hello.models.Assignment;
import hello.models.Laboratory;
import hello.models.LaboratoryWAssignments;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LaboratoryServiceImpl implements  LaboratoryService {

    @Autowired
    AssignmentService assignmentService;

    @Override
    public List<LaboratoryWAssignments> getAllLaboratories(String keyword) {

        String url = new String("http://localhost:8080/laboratories");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        if(keyword != null) {
            builder.queryParam("keyword", keyword);
        }

        RestTemplate restTemplate = new RestTemplate();
        // List<Laboratory> laboratorys = restTemplate.getForObject(builder.toUriString(), List.class);
        ResponseEntity<List<Laboratory>> laboratorysRespone =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Laboratory>>() {
                });

        List<Laboratory> laboratorys = laboratorysRespone.getBody();

        Collections.sort(laboratorys, (Laboratory l1, Laboratory l2)->(int)(l1.getLabNb()-l2.getLabNb()));

        ModelMapper modelMapper = new ModelMapper();

        //map Laboratory to LaboratoryWAssignments
        Type listType = new TypeToken<List<LaboratoryWAssignments>>() {}.getType();
        List<LaboratoryWAssignments> laboratorysWAssignments = modelMapper.map(laboratorys, listType);

        for(LaboratoryWAssignments l: laboratorysWAssignments) {
            l.setAssignments(assignmentService.getAllAssignments(l.getIdlaboratory()));
        }

        return laboratorysWAssignments;
    }

    @Override
    public LaboratoryWAssignments getLaboratoryById(Long idlab) {
        String url = new String("http://localhost:8080/laboratories");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.pathSegment(idlab.toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Laboratory> laboratorysRespone =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<Laboratory>() {
                });


        ModelMapper modelMapper = new ModelMapper();
        LaboratoryWAssignments laboratoryWAssignments = new LaboratoryWAssignments();
        modelMapper.map(laboratorysRespone.getBody(), laboratoryWAssignments);

        laboratoryWAssignments.setAssignments(assignmentService.getAllAssignments(idlab));

        return  laboratoryWAssignments;

    }

    @Override
    public LaboratoryWAssignments getLaboratoryByLabNb(Long labNb) {
        List<LaboratoryWAssignments> labs = getAllLaboratories(null);

        for(LaboratoryWAssignments l:labs) {
            if(l.getLabNb().equals(labNb))
                return l;
        }

        return null;
    }

    @Override
    public Laboratory createLaboratory(LaboratoryWAssignments laboratoryWAssignments) {

        String url = new String("http://localhost:8080/laboratories");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        ModelMapper modelMapper = new ModelMapper();
        Laboratory laboratory = new Laboratory();
        modelMapper.map(laboratoryWAssignments, laboratory);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Laboratory> requestEntity = new HttpEntity<Laboratory>(laboratory, headers);
        HttpEntity<Laboratory> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, Laboratory.class);

        Laboratory respLaboratory = response.getBody();

        return respLaboratory;
    }

    @Override
    public String deletelaboratory(Long idlaboratory) {
        String url = new String("http://localhost:8080/laboratories");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.pathSegment(idlaboratory.toString());

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, null, String.class);

        System.out.println(response.getBody());

        return response.getBody();
    }

    @Override
    public Laboratory updateLaboratory(LaboratoryWAssignments laboratoryWAssignments) {

        String url = new String("http://localhost:8080/laboratories");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.queryParam("idlaboratory", laboratoryWAssignments.getIdlaboratory().toString());

        System.out.println("LABORATORY ID: " + laboratoryWAssignments.getIdlaboratory());

        System.out.println(builder.toUriString());

        ModelMapper modelMapper = new ModelMapper();
        Laboratory laboratory = new Laboratory();
        modelMapper.map(laboratoryWAssignments, laboratory);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Laboratory> requestEntity = new HttpEntity<Laboratory>(laboratory, headers);
        HttpEntity<Laboratory> response = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, requestEntity, Laboratory.class);

        Laboratory respLaboratory = response.getBody();

        return respLaboratory;
    }
}
