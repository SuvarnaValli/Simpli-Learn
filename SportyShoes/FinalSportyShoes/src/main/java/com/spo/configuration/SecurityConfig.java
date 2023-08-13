package com.spo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.spo.service.CustomUserDetailService;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

		 

	@Autowired 
	GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;
	@Autowired
	CustomUserDetailService customUserDetailService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
                .csrf(csrf -> csrf
                                .disable())

                       .authorizeHttpRequests(requests -> requests
                                .requestMatchers (new MvcRequestMatcher( null, "/")).permitAll()
                                .requestMatchers (new MvcRequestMatcher( null,  "/shop/**")).permitAll()
                                .requestMatchers ( new MvcRequestMatcher( null, "/register")).permitAll()
                                .requestMatchers (new MvcRequestMatcher( null,  "/h2-console/**")).permitAll()
                               .requestMatchers(new MvcRequestMatcher( null, "/admin/**")).hasRole("ADMIN")

                               .anyRequest()
                               .authenticated())

                        .formLogin(form -> form
                                .loginPage("/login")
                                .permitAll()
                                .failureUrl("/login?error=true")
                                .defaultSuccessUrl("/")
                                .usernameParameter("email")
                                .passwordParameter("password"))

                        .oauth2Login(log -> log
                                .loginPage("/login")
                                .successHandler(googleOAuth2SuccessHandler))
                        .logout(out -> out
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login")
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")
                              )
                   . exceptionHandling((exceptionHandling) ->
         			exceptionHandling
     				.accessDeniedPage(null));

    	 
    	  			
    	  				
               	  http.headers().frameOptions().disable();
           	       
          	        return http.build();
      
    }
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
  
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring().requestMatchers(new MvcRequestMatcher( null, "/resources/**"))
        				.requestMatchers(new MvcRequestMatcher( null, "/static/**"))
        				.requestMatchers(new MvcRequestMatcher( null,"/images/**"))
        				.requestMatchers(new MvcRequestMatcher( null, "/footwearImages/**"))
        				.requestMatchers(new MvcRequestMatcher( null, "/css/**"))
        				.requestMatchers(new MvcRequestMatcher( null, "/js/**")));
        				}
}
