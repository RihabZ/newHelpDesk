package com.rihab.interventions.config;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.ui.ModelMap;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.rihab.interventions.filter.JwtAuthenticationFilter;
import com.rihab.interventions.service.UserDetailsImpl;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled= true)
public class SecurityConfig {

    private final UserDetailsImpl userDetailsImpl;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

   // private final CustomLogoutHandler logoutHandler;
   
    public SecurityConfig(UserDetailsImpl userDetailsImpl,
                          JwtAuthenticationFilter jwtAuthenticationFilter
) {
        this.userDetailsImpl = userDetailsImpl;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
       // this.logoutHandler = logoutHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(AbstractHttpConfigurer::disable)
                
            	.cors(cors -> cors.configurationSource((org.springframework.web.cors.CorsConfigurationSource) 
						new CorsConfigurationSource()
				{
		@Override
		public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
		 
		 CorsConfiguration cors = new CorsConfiguration();

				cors.setAllowedOrigins(Collections.singletonList("http://localhost:5173"));
				cors.setAllowedMethods(Collections.singletonList("*"));
				cors.setAllowedHeaders(Collections.singletonList("*"));
				cors.setExposedHeaders(Collections.singletonList("Authorization"));
				 return cors;
				 }



				 }))
                
               .authorizeHttpRequests(
                        req->req.requestMatchers("/login/**","/register/**")
                                .permitAll()
                               
                                .requestMatchers("/all/**").hasAuthority("ADMIN")
                                .requestMatchers("/allUsers/**").hasAuthority("ADMIN")
                                .requestMatchers("/delUser/**").hasAuthority("ADMIN")
                                .requestMatchers("/create-admin").hasRole("ADMIN")
                                .requestMatchers("/updateTicket/**").hasAuthority("CLIENT")
                                .requestMatchers("/deleteTicket/**").hasAuthority("CLIENT")
                                .requestMatchers("/addTicket/**").hasAuthority("CLIENT")
                                .anyRequest()
                                .authenticated()
                ).userDetailsService(userDetailsImpl)
                .sessionManagement(session->session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(
                        e->e.accessDeniedHandler(
                                        (request, response, accessDeniedException)->response.setStatus(403)
                                )
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                
                .build();

    }
   

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public ModelMap modelMapper() {
        return new ModelMap();
    }
}