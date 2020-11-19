package com.api.carrito.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.carrito.ws.config.JWTAuthorizationFilter;

@EnableHystrix
@SpringBootApplication
public class JavaBackEndSoaIntApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBackEndSoaIntApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/token/user").permitAll()
					.antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
					.antMatchers(HttpMethod.GET, "/v2/api-docs").permitAll()

				.anyRequest().authenticated();
		}
	}
}
