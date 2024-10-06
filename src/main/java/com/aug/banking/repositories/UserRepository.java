package com.aug.banking.repositories;

import com.aug.banking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAll();
    List<User> findAllByFirstname(String firstname);
    User findById(int id);
    List <User> findAllByFirstnameContaining(String firstname);

    Optional<User> findByEmail(String email);
}
