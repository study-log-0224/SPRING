package com.example.demo.Config.auth.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    JWTTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JWTAuthorizationFilter's doFilterInternal invoke...!");
        // access-token 쿠키 받기
        String token = null; // access-token 쿠키 받아 token=null;

        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
        {
            token = Arrays.stream(cookies)
                    .filter((cookie) -> {return cookie.getName().equals(JWTProperties.ACCESS_TOKEN_COOKIE_NAME);})
                    .findFirst()
                    .map((cookie)->{return cookie.getValue();})
                    .orElse(null);
        }
        System.out.println("[Token] : " + token);

        if(token!=null) {
            // access-token is not null
            // access-token is Expired ?
            try {
                // no -> access-token -> Authentication -> SecurityContextholder 전달
                if(jwtTokenProvider.validateToken(token)) {
                    Authentication authentication = jwtTokenProvider.getAuthentication(token);
                    if(authentication != null)
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    // yes -> refresh-token -> refresh-token is Expired?
                }
            } catch (ExpiredJwtException e) {
                System.out.println("[ExpiredJwtException].." + e.getMessage());
            } catch (Exception e) {
                System.out.println("Exception..." + e.getMessage());
            }

            // access-token -> Authentication -> SecurityContextholder 전달
        }else {

        }

        filterChain.doFilter(request,response);
    }

}
