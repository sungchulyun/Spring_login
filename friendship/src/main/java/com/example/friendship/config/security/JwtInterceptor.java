package com.example.friendship.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private static final String HEADER_AUTH = "authorization";

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        final String token = request.getHeader(HEADER_AUTH);
        System.out.println(token);
        if(token != null && jwtTokenProvider.validateToken(token)){
            return true;
        }
        else {
            throw new Exception();
        }
    }
}
