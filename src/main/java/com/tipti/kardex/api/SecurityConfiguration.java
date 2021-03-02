package com.tipti.kardex.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@EnableWebMvc
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { 

	
	/**
	 * Funcion no reversible para Hash para datos como la contraseña de usuario
	 * 
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	/**
	 * Configuro los usuarios en memoria
	 * 
	 */
	@Bean
    public UserDetailsService userDetailsService() {
		
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(password -> encoder.encode(password));
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
        return manager;
    }
	
	
	/**
	 *	cualquier usuario autenticado podra realizar acciones CRUD sobre el los endpoints expuestos  
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http 
			.csrf() 
			.disable()
			.authorizeRequests()
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated();
	}
	
}