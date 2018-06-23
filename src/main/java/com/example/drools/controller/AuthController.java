package com.example.drools.controller;

import com.example.drools.model.*;
import com.example.drools.payload.*;
import com.example.drools.repository.DiseaseRepository;
import com.example.drools.repository.RoleRepository;
import com.example.drools.repository.SymptomRepository;
import com.example.drools.repository.UserRepository;
import com.example.drools.security.JwtTokenProvider;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Momir on 11.06.2018.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    DiseaseRepository diseaseRepository;

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    JwtTokenProvider tokenProvider;
    private User user;

    private final KieContainer kieContainer;

    @Autowired
    public AuthController(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateToken(authentication);

            User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() ->
                    new UsernameNotFoundException("User not found with username : " + loginRequest.getUsername()));

            KieSession kieSession = kieContainer.newKieSession();

            List<Disease> diseases = this.diseaseRepository.findAll();
            List<Symptom> symptoms = this.symptomRepository.findAll();


            for (Disease disease : diseases)
                kieSession.insert(disease);

            for (Symptom symptom : symptoms)
                kieSession.insert(symptom);

            //kieSession.dispose();



            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, user.getId(), user.getUsername(), user.getRoles().iterator().next().getName()));
        }catch (Exception e)
        {
            return new ResponseEntity<>("Invalid login", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getPassword(), signUpRequest.getFirstname(), signUpRequest.getLastname());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_DOCTOR)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}

