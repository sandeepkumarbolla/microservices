package io.amigos.security.auth;

import io.amigos.security.config.JwtService;
import io.amigos.security.user.Role;
import io.amigos.security.user.User;
import io.amigos.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository  userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        Optional<User> user1= userRepository.findByEmail(request.getEmail());



            var user = User.builder()
                    .firstname(request.getFirstName())
                    .lastname(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
           // userRepository.save(user);

            var jwtToken = jwtService.generateToken(user);

//            return AuthenticationResponse.builder()
//                    .token(jwtToken)
//                    .build();
//        }
//        else {
//            return "user already exists";
//        }
        if (user1.isEmpty()){
           userRepository.save(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }
        else {
            return AuthenticationResponse.builder().token("user already exists, try to login with different email and password").build();
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
