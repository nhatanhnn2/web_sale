package com.example.webSale.config;

import com.example.webSale.constants.AuthoritiesConstants;
import com.example.webSale.security.CustomSuccessHandler;
import com.example.webSale.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@EnableWebSecurity
public class SecurityConfig {

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
                .antMatchers("/admin").hasAnyAuthority(AuthoritiesConstants.SUPER,AuthoritiesConstants.SYS,AuthoritiesConstants.SP,AuthoritiesConstants.SYS_USER,AuthoritiesConstants.SP_NEW)
                .antMatchers("/admin/category/**").hasAnyAuthority(AuthoritiesConstants.AD_NEW)
                .antMatchers("/admin/new/**").hasAnyAuthority(AuthoritiesConstants.NEW,AuthoritiesConstants.NEW_L)
                .antMatchers("/admin/api/new/**").hasAnyAuthority(AuthoritiesConstants.NEW);
        http.authorizeRequests()
                .antMatchers("/trang-chu").permitAll()
                .and().formLogin().loginPage("/dang-nhap").usernameParameter("j_username").passwordParameter("j_password")
                .loginProcessingUrl("/j_spring_security_check")
                .successHandler(customSuccessHandler)
                .failureUrl("/dang-nhap?incorrectAccount").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true);
        // Remember Me.
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/images/**","/ckeditor/**","/ckfinder/**","/media/**");
//    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }
}
