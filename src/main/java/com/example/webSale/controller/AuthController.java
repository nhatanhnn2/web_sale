package com.example.webSale.controller;

import com.example.webSale.config.JwtProvider;
import com.example.webSale.dto.AuthLoginDTO;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.service.RoleService;
import com.example.webSale.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("Auth Controller")
@RequestMapping("api/auth")
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

    @PostMapping("/login")
    public ResponseEntity<?> userLogin (@RequestBody UsersDTO usersDTO) {
        try {
            UsersDTO dto = usersService.findByEmail(usersDTO.getEmail());
            Authentication authen = authenticate(dto.getEmail(), usersDTO.getPassword());
            String jwt = jwtProvider.genToken(authen);
            String message = "Login successfully";

            AuthLoginDTO authLoginDTO = new AuthLoginDTO(message, jwt, roleService.findAllPermissionByRole(dto.getRoleId()));
            return new ResponseEntity<>(authLoginDTO, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
}
