package hello.services;

import hello.models.User;
import hello.utility.security.PasswordEncryptor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    @Override
    public List<User> getAllUsers() {
        String url = new String("http://localhost:8080/users");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<User>> userRespone =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });

        List<User> users = userRespone.getBody();

        System.out.println(users.size());

        return  users;
    }

    @Override
    public User getUserByID(Long iduser) {
        String url = new String("http://localhost:8080/users");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.pathSegment(iduser.toString());

        System.out.println(builder.toUriString());

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> userRespone =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
                });

        User user = userRespone.getBody();

        return  user;
    }

    @Override
    public User findByEmail(String email) {
        List<User> users = this.getAllUsers();

        for(User u: users) {
            if(u.getEmail().equals(email))
                return u;
        }

        return null;
    }

    @Override
    public User registerStudent(String email, String fullName, String group, String hobby){

        String url = new String("http://localhost:8080/RegisterTeacher");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.queryParam("email", email);
        builder.queryParam("fullName", fullName);
        builder.queryParam("group", group);
        builder.queryParam("hobby", hobby);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<User> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, User.class);

        return response.getBody();

    }

    @Override
    public User registerWithToken(String email, String token, String pass) {
        String url = new String("http://localhost:8080/RegisterStudent");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.queryParam("token", token);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        pass = PasswordEncryptor.encrypt(pass);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<String>(pass, headers);

        HttpEntity<User> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, User.class);

        return response.getBody();
    }

    @Override
    public User login(String email, String pass) {
        String url = new String("http://localhost:8080/login");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        builder.queryParam("email", email);
        builder.queryParam("password", pass);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> userRespone =
                restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, new ParameterizedTypeReference<User>() {
                });

        User user = userRespone.getBody();

        System.out.println("LOGIN FROM SERVICES. EMAIL: " + user.getEmail());

        return user;
    }
}
