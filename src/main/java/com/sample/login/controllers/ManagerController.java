package com.sample.login.controllers;

import com.sample.login.Manager;
import com.sample.login.Branch;
import com.sample.login.repository.BranchRepository;
import com.sample.login.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by juliusneria on 19/10/2017.
 */
@Controller    // This means that this class is a Controller
@RequestMapping(path="/manager")
public class ManagerController {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @PostMapping(path="/add") // Map ONLY GET Requests
    //@CrossOrigin
    public @ResponseBody
    Object addNewManager (@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }

    @GetMapping(path="/all")
    //@CrossOrigin
    public @ResponseBody
    Iterable<Manager> getAllUsers() {
        // This returns a JSON or XML with the users
        return managerRepository.findAll();
    }

    @PutMapping("/update")
    public @ResponseBody
    Object updateBook(@RequestBody Manager manager) {

        managerRepository.save(manager);

        return manager;
    }

    @DeleteMapping("/delete")
    public @ResponseBody
    Object delete(@RequestBody Manager manager) {
        try {
            Branch branch = branchRepository.findStoreByManager(manager);
            branch.setManager(null);
            managerRepository.delete(manager);
        } catch (Exception e) {
            return null;
        }
        return manager;
    }
}
