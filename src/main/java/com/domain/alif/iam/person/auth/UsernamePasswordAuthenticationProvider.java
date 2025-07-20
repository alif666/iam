package com.domain.alif.iam.person.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.domain.alif.iam.person.PersonModel;
import com.domain.alif.iam.person.PersonRepository;
import com.domain.alif.iam.person.PersonRoleModel;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        PersonModel person = personRepository.readByEmail(email);

        if (null != person && person.getId() > 0 && pwd.equals(person.getPwd())) {
            System.out.println("Granted Authorities: " + getGrantedAuthorities(person.getPersonRoleModel()));

            return new UsernamePasswordAuthenticationToken(person.getEmail(), pwd,
                    getGrantedAuthorities(person.getPersonRoleModel()));
        } else {
            throw new BadCredentialsException("Invalid Credentials!");
        }
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(PersonRoleModel personRoleModel) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + personRoleModel.getPersonRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
