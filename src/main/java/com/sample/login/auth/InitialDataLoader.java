package com.sample.login.auth;

import com.sample.login.model.Role;
import com.sample.login.model.User;
//import com.sample.login.repository.PrivilegeRepository;
import com.sample.login.repository.RoleRepository;
import com.sample.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    /*@Autowired
    private PrivilegeRepository privilegeRepository;*/

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        createRoleIfNotFound("ADMIN");
        String email = "test@test.com";
        User user = userRepository.findByEmail(email);
        if(user == null){
            user = new User();
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setPassword(encoder().encode("test"));
            user.setEmail(email);
            Role adminRole = roleRepository.findByName("ADMIN");
            user.setRole(adminRole);
            user.setEnabled(true);
            userRepository.save(user);
        }

        alreadySetup = true;
    }

    @Transactional
    private Role createRoleIfNotFound(String name) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            List<String> priviledges = new ArrayList<>();
            priviledges.add("READ_PRIVILEGE");
            priviledges.add("WRITE_PRIVILEGE");
            role = new Role(name);
            role.setPrivileges(priviledges);
            roleRepository.save(role);
        }
        return role;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
