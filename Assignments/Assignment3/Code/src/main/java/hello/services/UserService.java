package hello.services;

import hello.models.User;

import java.util.List;
import java.util.stream.Collectors;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserByID(Long iduser);

    public User findByEmail(String email);

    public User registerStudent(String email, String fullName, String group, String hobby);

    public User registerWithToken(String email, String token, String pass);

    public User login(String email, String pass);

}
