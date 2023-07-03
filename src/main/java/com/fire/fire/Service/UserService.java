package com.fire.fire.Service;

import com.fire.fire.Model.Role;
import com.fire.fire.Model.User;
import com.fire.fire.repo.RoleRepository;
import com.fire.fire.repo.UserRespository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsManager
 {
     @Autowired
     private  UserRespository userRespository;
     @Autowired
     private  RoleRepository roleRepository;
@Autowired
     private BCryptPasswordEncoder bCryptPasswordEncoder;



    public User addUser (User user){
        return userRespository.save(user);
    }
    public User updateUser (User user) {
        return userRespository.save(user);
    }

    public List<User> findAllStudent(){
        return  userRespository.findAll();
    }
    public User findUserByID(String id)  {
        return userRespository.findById(id).orElseThrow();
    }

     public User findUserByEmail(String email) {
         return userRespository.findByEmail(email);
     }

    public User saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setPrivilegs(new HashSet<>(Arrays.asList(userRole)));
        return userRespository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRespository.findByEmail(email);
        if(user != null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getPrivileg());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }

    }

     private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
         Set<GrantedAuthority> roles = new HashSet<>();
         userRoles.forEach((role) -> {
             roles.add(new SimpleGrantedAuthority(role.getRole()));
         });

         List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
         return grantedAuthorities;
     }
     private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
         return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
     }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    
    public void deleteUser(String username) {

    }

   @Override
   public void changePassword(String oldPassword, String newPassword) {

   }

   @Override
   public boolean userExists(String username) {
       return false;
   }
}
