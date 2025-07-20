package com.domain.alif.iam.person.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.domain.alif.iam.person.PersonModel;
import com.domain.alif.iam.person.PersonRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired private JwtUtil jwtUtil;
    @Autowired private PersonRepository personRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException, java.io.IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            try {
                Claims claims = jwtUtil.extractClaims(jwt);
                String email = claims.getSubject();
                PersonModel person = personRepository.readByEmail(email);
                List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + person.getPersonRoleModel().getPersonRoleName()));

                UsernamePasswordAuthenticationToken token =
                        new UsernamePasswordAuthenticationToken(person, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(token);
            } catch (Exception ex) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
