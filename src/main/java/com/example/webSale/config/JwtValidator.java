package com.example.webSale.config;

import com.example.webSale.dto.MyUser;
import com.example.webSale.service.impl.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
@ConfigurationPropertiesScan
@Slf4j
public class JwtValidator extends OncePerRequestFilter{
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Value("${SECRET_KEY}")
    private final String SECRET_KEY;

    public JwtValidator(@Value("${SECRET_KEY}") String SECRET_KEY) {
        this.SECRET_KEY = SECRET_KEY;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException  {
        String jwt = request.getHeader("Authorization");

        if (jwt != null) {
            jwt = jwt.replace("Bearer ", "");
            jwt = jwt.replace("bearer ", "");

            try {
                Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())).build().parseClaimsJws(jwt).getBody();

                String username = String.valueOf(claims.get("username"));
                String authorities = String.valueOf((claims.get("authorities")));
                MyUser myUser = (MyUser) customUserDetailsService.loadUserByUsername(username);
                List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
                Authentication authentication = new UsernamePasswordAuthenticationToken(myUser, null, auth);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request,response);
            } catch (Exception e) {
                log.error("failed on set user authentication", e);
            }
        }

        filterChain.doFilter(request, response);
    }


}
