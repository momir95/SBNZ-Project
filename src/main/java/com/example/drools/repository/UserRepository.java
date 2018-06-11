package com.example.drools.repository;

import com.example.drools.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Momir on 11.06.2018.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Optional<User> findById(Integer id);

    Boolean existsByUsername(String username);
}
