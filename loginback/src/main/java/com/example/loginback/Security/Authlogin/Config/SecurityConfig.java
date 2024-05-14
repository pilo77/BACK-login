package com.example.loginback.Security.Authlogin.Config;

import com.example.loginback.Security.Authlogin.Jwt.JwtAuthenticationEntryPoint;
import com.example.loginback.Security.Authlogin.Jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Autowired
    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, AuthenticationProvider authProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authProvider = authProvider;
    }

    @Bean
    public AuthenticationEntryPoint jwtAuthenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint())
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/alvarito/usuarios/auth/signup", "/alvarito/usuarios/auth/login", "/alvarito/usuarios/public").permitAll()
                                .antMatchers(HttpMethod.POST, "/alvarito/producto/save").hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.PUT, "/alvarito/producto/update").hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.DELETE, "/alvarito/producto/delete/**").hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.GET, "/alvarito/producto/all").hasAnyAuthority("ADMIN", "USER")
                                .antMatchers(HttpMethod.GET, "/alvarito/producto/all/**").hasAnyAuthority("ADMIN", "USER")
                                .antMatchers(HttpMethod.GET, "/alvarito/producto/search/**").hasAnyAuthority("ADMIN", "USER")
                                .antMatchers(HttpMethod.GET, "/alvarito/usuarios/all").hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.GET, "/alvarito/usuarios/all/**").hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.GET, "/alvarito/usuarios/search/**").hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.PUT, "/alvarito/usuarios/update/**").hasAnyAuthority("ADMIN", "USER")
                                .antMatchers(HttpMethod.DELETE, "/alvarito/usuarios/delete/**").hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.GET, "/alvarito/ventas/all").hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.GET, "/alvarito/usuarios/all/**").hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.GET, "/alvarito/usuarios/search/**").hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.PUT, "/alvarito/usuarios/update").hasAnyAuthority("ADMIN", "USER")
                                .antMatchers(HttpMethod.DELETE, "/alvarito/usuarios/delete/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                )
                .httpBasic()
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}