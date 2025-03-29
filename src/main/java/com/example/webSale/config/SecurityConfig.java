package com.example.webSale.config;

import com.example.webSale.constants.AuthoritiesConstants;
import com.example.webSale.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${SECRET_KEY}")
    private String SECRET_KEY;

    private final String[] PUBLIC_FOLDER  = {"/js/**","/common/**","/css/**","/decorators/**"};
    private final String[] PUBLIC_URL  = {"/dang-nhap","/trang-chu","/auth/**","/admin/**"};

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(PUBLIC_FOLDER).permitAll()
                .antMatchers(PUBLIC_URL).permitAll()
                .antMatchers("api/admin/**").hasAnyAuthority(AuthoritiesConstants.SUPER,AuthoritiesConstants.SYS,AuthoritiesConstants.SP,AuthoritiesConstants.SYS_USER,AuthoritiesConstants.SP_PRD)
                .antMatchers("api/admin/category/**").hasAnyAuthority(AuthoritiesConstants.AD_PRD)
                .antMatchers("api/admin/new/**").hasAnyAuthority(AuthoritiesConstants.NEW)
                .antMatchers("api/admin/api/new/**").hasAnyAuthority(AuthoritiesConstants.NEW)
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtValidator(SECRET_KEY), UsernamePasswordAuthenticationFilter.class)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()));
    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/images/**","/ckeditor/**","/ckfinder/**","/media/**");
//    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(
                "https://localhost:8088"
        ));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*","AUTH-TOKEN"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
