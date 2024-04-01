package io.noobi.carrentalbackend.service.impl;

import io.noobi.carrentalbackend.dto.SignUpRequest;
import io.noobi.carrentalbackend.dto.UserDTO;
import io.noobi.carrentalbackend.enums.Role;
import io.noobi.carrentalbackend.model.User;
import io.noobi.carrentalbackend.repository.UserRepository;
import io.noobi.carrentalbackend.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  private final UserRepository userRepository;

  public AuthServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDTO createCustomer(SignUpRequest signUpRequest) {
    User user = new User();
    user.setName(signUpRequest.getName());
    user.setEmail(signUpRequest.getEmail());
    user.setPassword(signUpRequest.getPassword());
    user.setRole(Role.CUSTOMER);
    User createdUser = userRepository.save(user);
    UserDTO userDTO = new UserDTO();
    userDTO.setId(createdUser.getId());
    return userDTO;
  }

  @Override
  public boolean hasCustomerWithEmail(String email) {
    return userRepository.findFirstByEmail(email).isPresent();
  }
}
