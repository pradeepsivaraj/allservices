package com.tastyfood.order.my.food.usermanagementservice.controller;

import java.util.HashSet;
import java.util.Set;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastyfood.order.my.food.usermanagementservice.model.Role;
import com.tastyfood.order.my.food.usermanagementservice.model.RoleName;
import com.tastyfood.order.my.food.usermanagementservice.model.User;
import com.tastyfood.order.my.food.usermanagementservice.repository.RoleRepository;
import com.tastyfood.order.my.food.usermanagementservice.repository.UserRepository;
import com.tastyfood.order.my.food.usermanagementservice.request.LoginForm;
import com.tastyfood.order.my.food.usermanagementservice.request.SignUpForm;
import com.tastyfood.order.my.food.usermanagementservice.response.JwtResponse;
import com.tastyfood.order.my.food.usermanagementservice.security.jwt.JwtProvider;
 

 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
 
    @Autowired
    private AuthenticationManager authenticationManager;
 
    @Autowired
    private UserRepository userRepository;
 
    @Autowired
    private RoleRepository roleRepository;
 
    @Autowired
    PasswordEncoder encoder;
 
    @Autowired
    private JwtProvider jwtProvider;
 
    /*This method is for login user
      Authenticate user using JWT*/
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
 
        SecurityContextHolder.getContext().setAuthentication(authentication);
 
        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
 
    /*This method is for signup a user*/
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
 
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
 
        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()),signUpRequest.getAddress(),
                signUpRequest.getCity(), signUpRequest.getState(), signUpRequest.getPhone());
 
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
 
        strRoles.forEach(role -> {
          switch(role) {
          case "admin":
            Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
            roles.add(adminRole);
            
            break;
           default:
              Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
              roles.add(userRole);              
          }
        });
        
        user.setRoles(roles);
        userRepository.save(user);
 
        return ResponseEntity.ok().body("User registered successfully!");
    }
}