package com.dwee.backenddwee.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.dwee.backenddwee.Models.ERole;
import com.dwee.backenddwee.Models.Role;
import com.dwee.backenddwee.Models.User;
import com.dwee.backenddwee.Models.request.LoginRequest;
import com.dwee.backenddwee.Models.request.ResetPasswordRequest;
import com.dwee.backenddwee.Models.request.SignupRequest;
import com.dwee.backenddwee.Models.response.JwtResponse;
import com.dwee.backenddwee.Models.response.MessageResponse;
import com.dwee.backenddwee.Repository.RoleRepository;
import com.dwee.backenddwee.Repository.UserRepository;
import com.dwee.backenddwee.Security.Jwt.JwtUtils;
import com.dwee.backenddwee.Security.Service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
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
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(), //username <=> email
                userDetails.getPassword(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        ERole strRole = signUpRequest.getRole();

        Role userRole = roleRepository.findByName(strRole)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.setRole(userRole);

        final var id = userRepository.save(user).getId();

        //notify admin send email?

        return ResponseEntity.ok(new MessageResponse(id));
    }

    @PostMapping("/resetpassword")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CHIEF_SERVICE') or hasRole('ROLE_DOCTOR') or hasRole('ROLE_USER')")
    public ResponseEntity<?> updatePassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
        if (!userRepository.existsByEmail(resetPasswordRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is not Correct!"));
        }

        final User user = userRepository.findByEmail(resetPasswordRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Error: User not Found!"));


        String encodedNewPassword = encoder.encode(resetPasswordRequest.getNewPassword());

        if (encoder.matches(resetPasswordRequest.getOldPassword(), user.getPassword())) {
            User updatedUser = new User();
            updatedUser.setId(user.getId());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(encodedNewPassword);
            updatedUser.setRole(user.getRole());
            userRepository.save(updatedUser);
            return ResponseEntity.ok(new MessageResponse("Password updated successfully!"));
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Old password is not Correct!"));
        }
    }
}