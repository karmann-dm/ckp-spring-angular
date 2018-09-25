package org.ccfebras.ckp.web.controller;

import org.ccfebras.ckp.exception.AppException;
import org.ccfebras.ckp.model.Role;
import org.ccfebras.ckp.model.RoleName;
import org.ccfebras.ckp.model.User;
import org.ccfebras.ckp.security.JwtTokenProvider;
import org.ccfebras.ckp.service.auth.AuthService;
import org.ccfebras.ckp.service.dictionary.DegreeService;
import org.ccfebras.ckp.service.dictionary.OrganizationService;
import org.ccfebras.ckp.service.dictionary.PositionService;
import org.ccfebras.ckp.service.dictionary.RankService;
import org.ccfebras.ckp.web.dto.request.LoginRequest;
import org.ccfebras.ckp.web.dto.request.SignUpRequest;
import org.ccfebras.ckp.web.dto.response.ApiResponse;
import org.ccfebras.ckp.web.dto.response.JwtAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private DegreeService degreeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private RankService rankService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(authService.userExistsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<ApiResponse>(
                    new ApiResponse(false, "Email is already taken!"),
                    HttpStatus.BAD_REQUEST
            );
        }

        User user = new User(
                signUpRequest.getFirstName(),
                signUpRequest.getSecondName(),
                signUpRequest.getLastName(),
                signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()),
                signUpRequest.getPhone(),
                organizationService.getOrganizationById(signUpRequest.getOrganizationId()),
                degreeService.getById(signUpRequest.getDegreeId()),
                positionService.getById(signUpRequest.getPositionId()),
                rankService.getById(signUpRequest.getRankId())
        );

        Role userRole = authService.findRoleByName(RoleName.ROLE_USER).orElseThrow(() -> new AppException("User role not set."));
        user.setRoles(Collections.singleton(userRole));

        User result = authService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getEmail()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully."));
    }
}
