package com.gestion.reclamo.servicio;


import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;



import com.gestion.reclamo.modelo.User;

import com.gestion.reclamo.repositorio.UsuarioRepositorio;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UsuarioServicio {

	private static final String SECRET_KEY = "3qYw9A1We9S2+nEwLpS12V1GVff7kPT1+7Y9VYzB6h4="; 
	private static final long EXPIRATION_TIME = 86400000; // 1 dia
	  
	@Autowired
	private UsuarioRepositorio usuariorepositorio;

	public User login(String username, String pwd) {
		User user = new User();
		List<User> users = usuariorepositorio.findAll();
		User entityuser = users.stream().filter(item -> item.getUser().equals(username) && item.getPwd().equals(pwd))
				.findFirst().get();

		String usernamex = entityuser.getUser().toString();

		if (entityuser != null) {

			String token = generateToken(usernamex);

			user.setUser(entityuser.getUser());
			user.setToken(token);

		}

		return user;

	}

	public static String generateToken(String username) {
		
	
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512,
						SECRET_KEY.getBytes()).compact();

		return "Bearer " + token;
		
	
	}
	
}
