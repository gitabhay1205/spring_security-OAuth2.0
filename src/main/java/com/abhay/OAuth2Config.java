package com.abhay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

	
	  @Autowired private AuthenticationManager authenticationmanager;
	  
	  @Autowired private UserDetailsService userDetailsService;
	 
//This method defines which clients are going to registered your service
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory() // ClientDetailsServiceConfigurer class provides two types to store informatiom
							// 1)inmemory and 2)jdbc
				.withClient("eagleid") // id of the application
				.secret("eaglepassword") // password of the application
				.authorizedGrantTypes("refresh_token", "password", "client_credentials") // this specify it can accept
			    .autoApprove(true)
			     // either of the three
				.scopes("mobileclient", "webclient");
	}

// This method defines the different components used within the AuthenticationServerConfigure
// This code is telling Spring to use the default authentication manager and user details service that comes up with spring.
	
	   public void configure(AuthorizationServerEndpointsConfigurer endpoints)
	   throws Exception{
	  
	  endpoints.authenticationManager(authenticationmanager)
	  .userDetailsService(userDetailsService);
	  
	  }
	 

}
