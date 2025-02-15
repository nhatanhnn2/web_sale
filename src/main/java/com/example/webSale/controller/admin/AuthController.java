//package com.example.webSale.controller.admin;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//    private final PasswordEncoder passwordEncoder;
//
//    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostMapping("/login")
//    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        String token = jwtUtil.generateToken(username);
//        Map<String, String> response = new HashMap<>();
//        response.put("token", token);
//        return response;
//    }
//
//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello, this is a protected API!";
//    }
//}
//
