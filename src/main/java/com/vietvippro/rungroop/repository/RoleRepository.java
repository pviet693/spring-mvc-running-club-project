package com.vietvippro.rungroop.repository;

import com.vietvippro.rungroop.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
