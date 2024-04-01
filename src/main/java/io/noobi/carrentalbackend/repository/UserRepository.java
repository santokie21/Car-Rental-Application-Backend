package io.noobi.carrentalbackend.repository;

import io.noobi.carrentalbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findFirstByEmail(String email);
}
