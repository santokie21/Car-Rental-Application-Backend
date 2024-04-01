package io.noobi.carrentalbackend.controller;

import io.noobi.carrentalbackend.dto.SignUpRequest;
import io.noobi.carrentalbackend.dto.UserDTO;
import io.noobi.carrentalbackend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/signup")
  public ResponseEntity<?> signUpCustomer(@RequestBody SignUpRequest signUpRequest) {
    UserDTO createdCustomer = authService.createCustomer(signUpRequest);
    if(createdCustomer == null) {
      return new ResponseEntity<>("Customer Not created, Come back again", HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
  }
}
