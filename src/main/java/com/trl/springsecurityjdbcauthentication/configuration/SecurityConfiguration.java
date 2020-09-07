package com.trl.springsecurityjdbcauthentication.configuration;

import com.trl.springsecurityjdbcauthentication.service.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
    }*/

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .withDefaultSchema()
                .withUser(
                        User.withUsername("user")
                        .password("pass")
                        .roles("USER")
                )
                .withUser(
                        User.withUsername("admin")
                        .password("pass")
                        .roles("ADMIN")
                );
    }*/

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        // Don't use this configuration in a production environment.
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole(UserRole.ADMIN.name())
                .antMatchers("/h2").hasRole(UserRole.ADMIN.name())
                .antMatchers("/user").hasAnyRole(UserRole.ADMIN.name(), UserRole.USER.name())
                .antMatchers("/").permitAll()
                .and().formLogin();

        // H2 Database.
        // Don't use this configuration in a production environment.
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
