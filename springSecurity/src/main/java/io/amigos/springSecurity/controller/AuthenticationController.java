package io.amigos.springSecurity.controller;

import io.amigos.springSecurity.DTO.AuthenticationRequest;
import io.amigos.springSecurity.config.JwtUtil;
import io.amigos.springSecurity.dao.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDAO userDAO;
    private final JwtUtil jwtUtil;


    @GetMapping("/hello")
    public String hello(){
        return "authentication free";
    }


    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request
            ){
                authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
                        );
        final UserDetails userDetails=userDAO.findUserByEmail(request.getEmail());
        if (userDetails!=null){
            return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
        }
        else {
            return ResponseEntity.status(400).body("some error occured");
        }
    }
}
