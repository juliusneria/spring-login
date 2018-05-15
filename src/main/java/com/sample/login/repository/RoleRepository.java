package com.sample.login.repository;

import com.sample.login.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by juliusneria on 15/05/2018.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String username);
}

