package io.noobi.carrentalbackend.dto;

import io.noobi.carrentalbackend.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

  private Long id;
  private String name;
  private String email;
  private Role role;
}
