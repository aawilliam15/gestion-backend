package com.gestion.reclamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gestion.reclamo.excepciones.ErrorMensaje;
import com.gestion.reclamo.utils.JWTAuthorizationFilter;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class GestionReclamoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionReclamoBackendApplication.class, args);
	}

	@Configuration
	@EnableWebSecurity
	@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)	
	class SecurityConfig{

		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		    http.csrf().disable()
		        .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
		        .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
		            authorizationManagerRequestMatcherRegistry
		                .requestMatchers(HttpMethod.POST, "/api/v1/login").permitAll()		               
		                .anyRequest().authenticated())
		        .httpBasic(Customizer.withDefaults())
		        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));  // Stateless session

		    return http.build();
		}
		
	}

}
