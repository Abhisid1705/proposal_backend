package com.sbdigital.webapp.SecurityService.Controller;

import com.sbdigital.webapp.SecurityService.Domain.ApiResponse;
import com.sbdigital.webapp.SecurityService.Domain.SignupRequest;
import com.sbdigital.webapp.SecurityService.Domain.SignupResponse;
import com.sbdigital.webapp.SecurityService.Domain.User;
import com.sbdigital.webapp.SecurityService.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins = "*")  // Replace with your frontend URL

@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository ,BCryptPasswordEncoder bCryptPasswordEncoder ) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @CrossOrigin(origins = "*")  // Replace with your frontend URL
    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody User user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User result = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/sign-up")
                .buildAndExpand(result.getUsername()).toUri();
        return ResponseEntity.created(location).body(result);
    }
}
