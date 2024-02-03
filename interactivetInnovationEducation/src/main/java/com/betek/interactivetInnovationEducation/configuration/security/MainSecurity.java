package com.betek.interactivetInnovationEducation.configuration.security;

import com.betek.interactivetInnovationEducation.configuration.Constants;
import com.betek.interactivetInnovationEducation.configuration.security.jwt.JwtEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MainSecurity {

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() { return new JwtAuthenticationFilter(); }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .formLogin(formLogin -> formLogin.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/actuator/health", "/files/picture").permitAll()
                        .requestMatchers(HttpMethod.POST,"/management/post/").hasAuthority(Constants.ROLE_MEMBER)
                        .requestMatchers(HttpMethod.DELETE,"/management/post/").hasAuthority(Constants.ROLE_MEMBER)
                        .requestMatchers(HttpMethod.POST, "/management/category/").hasAuthority(Constants.ROLE_ADMINSITRATOR)
                        .requestMatchers(HttpMethod.DELETE, "/management/category/").hasAuthority(Constants.ROLE_ADMINSITRATOR)
                        .requestMatchers(HttpMethod.GET, "/management/category/").hasAnyAuthority(Constants.ROLE_MEMBER, Constants.ROLE_ADMINSITRATOR)
                        .requestMatchers(HttpMethod.GET, "/management/home/").hasAnyAuthority(Constants.ROLE_MEMBER, Constants.ROLE_ADMINSITRATOR)
                        .requestMatchers(HttpMethod.GET,"/management/profile/posts/").hasAuthority(Constants.ROLE_MEMBER)
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtEntryPoint));
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}