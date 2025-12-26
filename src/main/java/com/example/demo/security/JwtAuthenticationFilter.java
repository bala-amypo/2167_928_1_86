package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.core.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider provider;

    public JwtAuthenticationFilter(JwtTokenProvider provider) {
        this.provider = provider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
                                    FilterChain chain)
            throws ServletException, IOException {

        String h = req.getHeader("Authorization");
        if (h != null && h.startsWith("Bearer ")) {
            String token = h.substring(7);
            try {
                provider.validateToken(token);
                Authentication auth = new UsernamePasswordAuthenticationToken(
                        provider.getUserId(token),
                        null,
                        List.of(new SimpleGrantedAuthority("ROLE_" + provider.getRole(token)))
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception ignored) {}
        }
        chain.doFilter(req, res);
    }
}
