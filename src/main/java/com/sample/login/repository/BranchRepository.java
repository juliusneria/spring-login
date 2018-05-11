package com.sample.login.repository;

import com.sample.login.Branch;
import com.sample.login.Manager;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by juliusneria on 19/10/2017.
 */
public interface BranchRepository extends CrudRepository<Branch, Long> {

    Branch findStoreByManager(Manager manager);
    /*Branch findByStore_id(Long id);
    Branch deleteByStore_id(Long id);*/
}

