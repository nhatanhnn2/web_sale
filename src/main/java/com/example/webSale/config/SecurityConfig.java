package com.example.webSale.config;

import com.example.webSale.constants.AuthoritiesConstants;
import com.example.webSale.security.CustomSuccessHandler;
import com.example.webSale.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
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
    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return customSuccessHandler;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAnyAuthority(AuthoritiesConstants.SUPER,AuthoritiesConstants.SYS,AuthoritiesConstants.SP,AuthoritiesConstants.SYS_USER,AuthoritiesConstants.SP_PRD)
                .antMatchers("/admin/category/**").hasAnyAuthority(AuthoritiesConstants.AD_PRD)
                .antMatchers("/admin/new/**").hasAnyAuthority(AuthoritiesConstants.NEW)
                .antMatchers("/admin/api/new/**").hasAnyAuthority(AuthoritiesConstants.NEW);
        http.authorizeRequests()
                .antMatchers("/trang-chu").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .and().formLogin().loginPage("/dang-nhap").usernameParameter("j_username").passwordParameter("j_password")
                .loginProcessingUrl("/j_spring_security_check")
                .successHandler(customSuccessHandler)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true);
        // Remember Me.
        http.addFilterBefore(new JwtValidator(SECRET_KEY), BasicAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable())
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
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
