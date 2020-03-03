package com.info.haidara.sid.services;

import com.info.haidara.sid.entities.AppRole;
import com.info.haidara.sid.entities.AppUser;

public interface AccountService {
    public AppUser findUserByUsername(String username);
    public void addRoleToUser(String username, String role);
    public  AppRole saveRole(AppRole r);
    public  AppUser saveAppUser(String username, String Password, String repassword);
    public  AppUser saveAppUser(AppUser user);
}
