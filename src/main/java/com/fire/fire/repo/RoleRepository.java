
package com.fire.fire.repo;


import com.fire.fire.Model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {
    
    Role findByRole(String role);
    
}
