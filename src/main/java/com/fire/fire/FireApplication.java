package com.fire.fire;

import com.fire.fire.Model.Role;
import com.fire.fire.Model.User;
import com.fire.fire.Service.UserService;
import com.fire.fire.repo.RoleRepository;
import com.fire.fire.repo.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class FireApplication {

    private final  RoleRepository roleRepository;

    public FireApplication(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FireApplication.class, args);
    }




 //  @Bean
 //  @Autowired
 //  CommandLineRunner commandLineRunner (UserService userService){
 //
 //      return args -> {
 //          Role adminRole = roleRepository.findByRole("ADMIN");
 //          if (adminRole == null) {
 //              Role newAdminRole = new Role();
 //              newAdminRole.setRole("ADMIN");
 //              roleRepository.save(newAdminRole);
 //          }
 //          Set<Role> roles = new HashSet<>();
 //          roles.add(roleRepository.findByRole("ADMIN"));
 //          User user = new User("Adrian","Rokicki","jezus459@gmail.com","1234", roles);
 //
 //          userService.saveUser(user);
 //      };
 //  }

}
