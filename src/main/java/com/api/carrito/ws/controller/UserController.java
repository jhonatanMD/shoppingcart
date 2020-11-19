package com.api.carrito.ws.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.carrito.ws.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/token")
public class UserController {

	static final Logger logLogeo = Logger.getLogger("Logeo");
	@Value("${user}")
	String user;
	@Value("${password}")
	String password;
	

	@PostMapping("/user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) throws Exception {
				
		if (username.equals(user) && pwd.equals(password)) {
		String token = getJWTToken(username);
		User user = new User();
		user.setUser(username);
		user.setPwd(pwd);
		user.setToken(token);
			logLogeo.debug("logeo de usueario exitoso");
		return user;
		}else{
			logLogeo.info("no se entro usueario");
			throw  new Exception("no se encontro usuario");
		}

		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
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
				.setExpiration(new Date(System.currentTimeMillis() + 120000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
