package com.info.haidara.sid.services;

import com.info.haidara.sid.config.ConfigureConstantDefault;
import com.info.haidara.sid.dao.AppRoleRepository;
import com.info.haidara.sid.dao.AppUserRepository;
import com.info.haidara.sid.entities.AppRole;
import com.info.haidara.sid.entities.AppUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppRoleRepository roleRepository;
    private AppUserRepository userRepository;

    public AccountServiceImpl(AppRoleRepository roleRepository, AppUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser user  =  userRepository.findByUsername(username);
        AppRole r =  roleRepository.findByRole(role);
        user.getRoles().add(r);
    }

    @Override
    public AppRole saveRole(AppRole r) {
        return roleRepository.save(r);
    }

    @Override
    public AppUser saveAppUser(String username, String password, String passwordAgain) {
        AppUser user =  userRepository.findByUsername (username);
        if(user !=null) throw  new RuntimeException("This user already exists, try with an other username.");
        if(!password.equals(passwordAgain)) throw new RuntimeException("You must confirm your password.");
        user =  new AppUser();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setUsername(username);
        user.setActivated(true);
        userRepository.save(user);
        addRoleToUser(username, ConfigureConstantDefault.ROLE_USER);
        return user;
    }

    @Override
    public AppUser saveAppUser(AppUser u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        return userRepository.save(u);
    }
}
