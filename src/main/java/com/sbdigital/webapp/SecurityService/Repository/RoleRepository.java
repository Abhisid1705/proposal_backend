package com.sbdigital.webapp.SecurityService.Repository;

import com.sbdigital.webapp.SecurityService.Domain.Role;
import com.sbdigital.webapp.SecurityService.Enum.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    //Optional<Role> findByName(RoleName roleName);
}