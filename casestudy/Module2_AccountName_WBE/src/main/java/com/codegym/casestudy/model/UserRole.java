package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userRole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;
    @ManyToMany
    @JoinTable(name = "userRole",JoinColumns = @JoinColumn(name = "userName",referencedColumnName = "user"),)
    private List<User> username;

    public UserRole() {
    }

    public UserRole(int roleId, List<User> username) {
        this.roleId = roleId;
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<User> getUsername() {
        return username;
    }

    public void setUsername(List<User> username) {
        this.username = username;
    }
}
