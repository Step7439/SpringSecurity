package com.example.security.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public PasswordEncoder encoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Step")
                .password(encoder().encode("password"))
                .roles("READ", "WRITE")
                .and()
                .withUser("Dima")
                .password(encoder().encode("password2"))
                .authorities("read","write")
                .and()
                .withUser("Vasy")
                .password(encoder().encode("password3"))
                .authorities("write");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .and()
//                .authorizeRequests().antMatchers("/hello").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/login").hasAuthority("read")
//                .and()
//                .authorizeRequests().antMatchers("/read").hasAuthority("read")
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
//
//    }
}
