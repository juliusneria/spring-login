package com.sample.login.controller;

import com.sample.login.model.Role;
import com.sample.login.model.User;
import com.sample.login.repository.RoleRepository;
import com.sample.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by juliusneria on 16/05/2018.
 */
@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(path="/createAdmin")
    @ResponseBody
    public User addNewAdmin (@RequestBody User user) {
        Role role = roleRepository.findByName("ADMIN");
        user.setRole(role);
        return userRepository.save(user);
    }

    @PostMapping(path="/createUser")
    @ResponseBody
    public User addNewUser (@RequestBody User user) {
        Role role = roleRepository.findByName("USER");
        user.setRole(role);
        return userRepository.save(user);
    }

    @PostMapping(path="/createRole") // Map ONLY GET Requests
    @ResponseBody
    public Role addNewUser (@RequestBody Role role) {
        return roleRepository.save(role);
    }
}
