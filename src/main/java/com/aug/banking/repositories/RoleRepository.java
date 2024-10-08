package com.aug.banking.repositories;

import com.aug.banking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String roleName);
}
