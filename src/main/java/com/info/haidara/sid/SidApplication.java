package com.info.haidara.sid;

import com.info.haidara.sid.entities.AppRole;
import com.info.haidara.sid.entities.AppUser;
import com.info.haidara.sid.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SidApplication  implements CommandLineRunner {
    @Autowired
    private AccountService accountService;
    public static void main(String[] args) {
        SpringApplication.run(SidApplication.class, args);
    }
    @Bean
    BCryptPasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public void run(String... args) throws Exception {
        /*AppRole r =  new AppRole();
        r.setRole("ADMIN");
        accountService.saveRole(r);
        AppRole r1 = new AppRole();
        r1.setRole("USER");
        accountService.saveRole(r1);
        accountService.saveAppUser("Haidara", "123","123");
        accountService.saveAppUser("Akale", "123","123");
        accountService.addRoleToUser("user", "USER");
        accountService.addRoleToUser("admin", "USER");
        accountService.addRoleToUser("admin", "ADMIN");
        */

    }
}
