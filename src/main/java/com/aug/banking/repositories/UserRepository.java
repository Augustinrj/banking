package com.aug.banking.repositories;

import com.aug.banking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAll();
    List<User> findAllByFirstname(String firstname);
    User findById(int id);
    List <User> findAllByFirstnameContaining(String firstname);
}
