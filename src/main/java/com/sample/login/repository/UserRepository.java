package com.sample.login.repository;

import com.sample.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by juliusneria on 15/05/2018.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String username);
}
