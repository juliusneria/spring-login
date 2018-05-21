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

import java.util.List;
import java.util.Optional;

/**
 * Created by juliusneria on 16/05/2018.
 */
@Controller
@RequestMapping(path="/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(path="/createRole")
    @ResponseBody
    public Role addNewUser(@RequestBody Role role){
        return roleRepository.save(role);
    }

    @PutMapping(path="/editRole")
    @ResponseBody
    public Role editUser(@RequestBody Role role){
        return roleRepository.save(role);
    }

    @GetMapping(path="/getRole/{ID}")
    @ResponseBody
    public Optional<Role> getUserByID(@PathVariable String ID){
        return roleRepository.findById(Long.parseLong(ID));
    }

    @GetMapping(path="/getRole")
    @ResponseBody
    public List<Role> getAllUser(){
        return roleRepository.findAll();
    }

    /*@DeleteMapping(path="/deleteRole/{ID}")
    @ResponseBody
    public void deleteUser(@PathVariable String ID){
        Optional<User> user = userRepository.findById(Long.parseLong(ID));
        userRepository.delete(user.get());
    }*/
}
