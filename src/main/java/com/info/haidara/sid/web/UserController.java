package com.info.haidara.sid.web;

import com.info.haidara.sid.config.ConfigureConstantDefault;
import com.info.haidara.sid.entities.AppUser;
import com.info.haidara.sid.form.RegistrationForm;
import com.info.haidara.sid.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    AccountService accountService;
    AppUser user = null;
    @PostMapping("/registration")
    public AppUser signUp(@RequestBody RegistrationForm data){
        String username =  data.getUsername();
        String password = data.getPassword();
        String passwordAgain =  data.getRepassword();
        accountService.saveAppUser(username, password,passwordAgain);
        return  user ;
    }

    @PostMapping("/login")
    public AppUser signIn(@RequestBody RegistrationForm data){
        String username =  data.getUsername();
        String password = data.getPassword();
        accountService.findUserByUsername(username);
        return  user ;
    }


}
