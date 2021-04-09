package ru.itis.api.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import ru.itis.api.security.jwt.JwtAuthenticationFilter;
import ru.itis.api.security.jwt.JwtAuthenticationProvider;
import ru.itis.api.security.jwt.JwtLogoutFilter;

/**
 * 13.03.2021
 * 03. Spring Security
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private JwtLogoutFilter jwtLogoutFilter;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(jwtLogoutFilter, LogoutFilter.class)
                .authorizeRequests()
                .antMatchers("/teachers").hasAuthority("ADMIN")
                .antMatchers("/logout").hasAnyAuthority()
                .antMatchers("/login").permitAll()
                .and()
                .sessionManagement().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(jwtAuthenticationProvider);
    }
}
