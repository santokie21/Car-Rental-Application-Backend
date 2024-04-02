package io.noobi.carrentalbackend.service;

import io.noobi.carrentalbackend.dto.SignUpRequest;
import io.noobi.carrentalbackend.dto.UserDTO;

public interface AuthService {
  UserDTO createCustomer(SignUpRequest signUpRequest);
  boolean hasCustomerWithEmail(String email);
}
