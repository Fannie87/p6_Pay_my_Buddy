package com.paymybuddy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf() //
				.disable() //
				.authorizeRequests() //
				//
				.antMatchers("/login*") //
				.permitAll() //
				//
				.antMatchers("/registration*") //
				.permitAll() //
				//
				.anyRequest() //
				.authenticated() //
				//
				.and() //
					.formLogin() //
					.loginPage("/login") //
					.loginProcessingUrl("/perform_login") //
					.defaultSuccessUrl("/home", true) //
				//
				.and()
					.rememberMe() //
					.key("eIxQfAVsVz") //
					.userDetailsService(customUserDetailsService) //
				//
				.and() //
					.logout() //
					.logoutUrl("/perform_logout") //
					.deleteCookies("JSESSIONID");
		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder)
			throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);

		authenticationManagerBuilder.userDetailsService(customUserDetailsService)
				.passwordEncoder(bCryptPasswordEncoder);
		return authenticationManagerBuilder.build();

	}

}
