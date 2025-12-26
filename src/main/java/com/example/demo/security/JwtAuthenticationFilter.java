package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder; // ✅ FIX
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider provider;

    public JwtAuthenticationFilter(JwtTokenProvider provider) {
        this.provider = provider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                provider.validateToken(token);

                Authentication auth =
                        new UsernamePasswordAuthenticationToken(
                                provider.getUserId(token),
                                null,
                                List.of(new SimpleGrantedAuthority(
                                        "ROLE_" + provider.getRole(token)))
                        );

                // ✅ THIS LINE NOW COMPILES
                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception ignored) {
            }
        }

        filterChain.doFilter(request, response);
    }
}
