package com.fire.fire.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Set;

@Data
@Document
public class User {
    @MongoId
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @DBRef
    private Set<Role> privileg;

    public User(String firstName, String lastName, String email, String password, Set<Role> privileg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.privileg = privileg;
    }

    public Set<Role> getPrivileg() {
        return privileg;
    }

    public void setPrivilegs(Set<Role> privilegs) {
        this.privileg = privilegs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
