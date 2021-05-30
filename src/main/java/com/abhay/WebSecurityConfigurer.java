package com.abhay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	//The AuthenticationManager bean is used by Spring Security to handle authentication
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
	return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	//The UserDetailsService is used by Spring Security to handle user information that will be returned by Spring Security
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception
	{
		return super.userDetailsServiceBean();
	}
	
	//This methods is where you will define users,their passwords and their roles
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		    .withUser("abhay")
		    .password(passwordEncoder().encode("kumar"))
		    .roles("USER")
		    .and()
		     .withUser("Aayushi")
		     .password(passwordEncoder().encode("password"))
		     .roles("USER", "ADMIN");
	}

}
