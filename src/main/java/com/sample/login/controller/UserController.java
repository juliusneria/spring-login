package com.sample.login.controller;

import com.sample.login.model.Role;
import com.sample.login.model.User;
import com.sample.login.repository.RoleRepository;
import com.sample.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by juliusneria on 16/05/2018.
 */
@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(path="/createUser")
    @ResponseBody
    public User addNewUser(@RequestBody User user){
        Role role = roleRepository.findByName(user.getRole().getName());
        if(role == null){
            role = new Role(user.getRole().getName());
        }
        user.setRole(roleRepository.save(role));
        user.setPassword(encoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @PutMapping(path="/editUser")
    @ResponseBody
    public User editUser(@RequestBody User user){
        Optional<User> oldUser = userRepository.findById(user.getId());
        if(user.getPassword() == null){
            user.setPassword(oldUser.get().getPassword());
        } else {
            user.setPassword(encoder().encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    @GetMapping(path="/getUser/{ID}")
    @ResponseBody
    public Optional<User> getUserByID(@PathVariable String ID){
        return userRepository.findById(Long.parseLong(ID));
    }

    @GetMapping(path="/getUser")
    @ResponseBody
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @DeleteMapping(path="/deleteUser/{ID}")
    @ResponseBody
    public void deleteUser(@PathVariable String ID){
        Optional<User> user = userRepository.findById(Long.parseLong(ID));
        userRepository.delete(user.get());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
