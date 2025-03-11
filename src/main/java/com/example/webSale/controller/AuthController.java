package com.example.webSale.controller;

import com.example.webSale.config.JwtProvider;
import com.example.webSale.dto.AuthLoginDTO;
import com.example.webSale.dto.MyUser;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.service.RoleService;
import com.example.webSale.security.TokenBlacklistService;
import com.example.webSale.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller("Auth Controller")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersService usersService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtProvider jwtProvider;

    private final TokenBlacklistService tokenBlacklistService;

    public AuthController(JwtProvider jwtProvider, TokenBlacklistService tokenBlacklistService) {
        this.jwtProvider = jwtProvider;
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin (@RequestBody UsersDTO usersDTO) {
        try {
            UsersDTO dto = usersService.findByEmail(usersDTO.getEmail());
            Authentication authen = authenticate(dto.getEmail(), usersDTO.getPassword());
            String jwt = jwtProvider.genToken(authen);
            String message = "Login successfully";
            return ResponseEntity.ok(new AuthLoginDTO(message,jwt,redirectUrl(dto.getRoleId())));
        } catch (Exception e){
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }

    private Authentication authenticate(String username , String password){
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (userDetails == null){
            throw new BadCredentialsException("Invalid username......");
        }
        if (!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password......");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }

    private String redirectUrl(Long roleId){
        List<String> roles = roleService.findAllPermissionByRole(roleId);
        String url = "";
        if (isAdmin(roles)) {
            url = "/admin/home";
        } else {
            url = "/trang-chu";
        }

        return url;
    }
    private boolean isAdmin(List<String> roles) {
        if (roles.contains("SUPER") || roles.contains("SYS") ||
                roles.contains("SP") || roles.contains("SYS_USER")|| roles.contains("SP_NEW")) {
            return true;
        }
        return false;
    }
}
