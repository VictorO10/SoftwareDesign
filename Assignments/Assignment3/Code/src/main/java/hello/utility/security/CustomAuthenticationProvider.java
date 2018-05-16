package hello.utility.security;

import hello.models.User;
import hello.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider
        implements AuthenticationProvider {

    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        //encrypt before calling API
        password = PasswordEncryptor.encrypt(password);

        User user = userService.login(name, password);

        if (! user.getEmail().equals("fail")) {

            // use the credentials
            // and authenticate against the third-party system]

            List<GrantedAuthority> grantedAuths = new ArrayList<>();

            String authority;
            if (user.isTeacher() == true) {
                authority = "ROLE_TEACHER";
            } else {
                authority = "ROLE_STUDENT";
            }

            grantedAuths.add(new SimpleGrantedAuthority(authority));

            return new UsernamePasswordAuthenticationToken(
                    name, password, grantedAuths);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
