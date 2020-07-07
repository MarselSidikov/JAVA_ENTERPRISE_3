package ru.itis.service.security.providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.service.models.User;
import ru.itis.service.repositories.UsersRepository;
import ru.itis.service.security.authentication.TokenAuthentication;
import ru.itis.service.security.details.UsersDetailsImpl;

import java.util.Optional;

/**
 * 05.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsersRepository usersRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("PROVIDER " + authentication.getName());
        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;
        Optional<User> userOptional = usersRepository.findByToken(tokenAuthentication.getName());
        if (userOptional.isPresent()) {
            UsersDetailsImpl userDetails = new UsersDetailsImpl(userOptional.get());
            tokenAuthentication.setAuthenticated(true);
            tokenAuthentication.setUserDetails(userDetails);
            return tokenAuthentication;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(TokenAuthentication.class.getName());
    }
}
