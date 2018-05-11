package com.sample.login.repository;

import com.sample.login.Manager;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by juliusneria on 19/10/2017.
 */
public interface ManagerRepository extends CrudRepository<Manager, Long> {
}
