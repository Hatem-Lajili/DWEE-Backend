package com.dwee.backenddwee.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.dwee.backenddwee.Security.UserRole.CHIEF_SERVICE;
import static com.dwee.backenddwee.Security.UserRole.DOCTOR;

@Configuration
@EnableWebSecurity
public class DweeSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DweeSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/api/**").hasRole(DOCTOR.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

       UserDetails doctorUser = User.builder()
                .username("doctor")
                .password(passwordEncoder.encode("password"))
                .roles(DOCTOR.name())
                .build();
       UserDetails chiefServiceUser = User.builder()
               .username("chief")
               .password(passwordEncoder.encode("chief123"))
               .roles(CHIEF_SERVICE.name())
               .build();
        return new InMemoryUserDetailsManager(
                doctorUser,
                chiefServiceUser
        );

    }
}
