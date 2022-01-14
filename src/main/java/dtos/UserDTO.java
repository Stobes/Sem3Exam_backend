/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Role;
import entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45319
 */
public class UserDTO {
    
    private String userName;
    private String userPass;
    private List<Role> roleList = new ArrayList<>();
    
    public UserDTO() {}

    public UserDTO(User user) {
        this.userName = user.getUserName();
        this.userPass = user.getUserPass();
        this.roleList = user.getRoleList();
    }

    public UserDTO(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }
    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
    
    public void addRole(Role userRole) {
    roleList.add(userRole);
    }
    
    
    
}
