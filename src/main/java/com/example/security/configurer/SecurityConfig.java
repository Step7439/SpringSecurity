package com.example.security.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Step").password("{noop}password").authorities("read", "write")
                .and()
                .withUser("Dima").password("{noop}password").authorities("read")
                .and()
                .withUser("Vasy").password("{noop}password").authorities("write");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/hello").permitAll()
                .and()
                .authorizeRequests().antMatchers("/login").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/read").hasAuthority("read")
                .and()
                .authorizeRequests().anyRequest().authenticated();

    }
}
