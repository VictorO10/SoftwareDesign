package hello.services;

import hello.models.*;
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
import java.util.Collections;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    @Autowired
    UserService userService;

    @Autowired
    LaboratoryService laboratoryService;

    @Override
    public List<AttendanceWUserAndLab> getAllAttendances(String email, Long idlaboratory) {

        String url = new String("http://localhost:8080/attendance");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        if(email != null && !email.equals("")) {
            User user = userService.findByEmail(email);
            builder.queryParam("iduser", user.getIduser());
        }
        if(idlaboratory != null) {
            LaboratoryWAssignments laboratory = laboratoryService.getLaboratoryById(idlaboratory);
            builder.queryParam("idlaboratory", idlaboratory);
        }

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Attendance>> attendancesRespone =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Attendance>>() {
                });

        List<Attendance> attendances = attendancesRespone.getBody();

        ModelMapper modelMapper = new ModelMapper();

        //map Attendance to AttendanceWUserAndLab
        Type listType = new TypeToken<List<AttendanceWUserAndLab>>() {}.getType();
        List<AttendanceWUserAndLab> attendancesWUserAndLab = modelMapper.map(attendances, listType);

        for(AttendanceWUserAndLab l: attendancesWUserAndLab) {
            l.setUser(userService.getUserByID(l.getIduser()));
            l.setLaboratory(laboratoryService.getLaboratoryById(l.getIdlaboratory()));
        }

        return attendancesWUserAndLab;
    }

    @Override
    public Attendance createAttendance(String email, Long idLaboratory) {
        User user = userService.findByEmail(email);

        String url = new String("http://localhost:8080/presence");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.queryParam("iduser", user.getIduser());
        builder.queryParam("idlaboratory", idLaboratory);
        builder.queryParam("bonusPoints", 0);

        System.out.println(builder.toUriString());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Attendance> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Attendance.class);

        return response.getBody();

    }
}
