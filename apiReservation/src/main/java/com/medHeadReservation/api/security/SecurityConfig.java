package com.medHeadReservation.api.security;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.beans.factory.annotation.Value;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	 @Value("${security.my-jwtKey}")
	    private String jwtKey;   

        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			return http.authorizeHttpRequests(auth -> {
				auth.requestMatchers("/admin").hasRole("ADMIN");
				auth.requestMatchers("/user").hasRole("USER");
				auth.anyRequest().authenticated();
			}).oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
.httpBasic(Customizer.withDefaults()).build();
		}

        @Bean
        UserDetailsService users() {
			UserDetails user = User.builder()
					.username("user")
					.password(passwordEncoder().encode("user"))
					.roles("USER").build();
			UserDetails admin = User.builder()
					.username("admin")
					.password(passwordEncoder().encode("admin"))
					.roles("USER", "ADMIN").build();
			return new InMemoryUserDetailsManager(user, admin);
		}

        @Bean
        BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
        @Bean
        public JwtEncoder jwtEncoder() {
            return new NimbusJwtEncoder(new ImmutableSecret<>(this.jwtKey.getBytes()));
        }

        @Bean
        public JwtDecoder jwtDecoder() {
            SecretKeySpec secretKey = new SecretKeySpec(this.jwtKey.getBytes(), 0, this.jwtKey.getBytes().length, "RSA");
            return NimbusJwtDecoder.withSecretKey(secretKey).macAlgorithm(MacAlgorithm.HS256).build();
        }

}


