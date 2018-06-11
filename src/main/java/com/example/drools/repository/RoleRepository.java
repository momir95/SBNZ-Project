package com.example.drools.repository;

/**
 * Created by Momir on 11.06.2018.
 */
import com.example.drools.model.Role;
import com.example.drools.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleName roleName);
}
