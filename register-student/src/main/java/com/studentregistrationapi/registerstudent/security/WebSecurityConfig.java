package com.studentregistrationapi.registerstudent.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.studentregistrationapi.registerstudent.security.ApplicationUserRole.*;
import static org.springframework.security.config.Customizer.withDefaults;
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig  {


    private final PasswordEncoder passwordEncoder;




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }



  //  @Bean
  //  public WebSecurityCustomizer webSecurityCustomizer() {
  //      return (web) -> web.ignoring().antMatchers("/index*");
  //  }

    @Bean
    protected SecurityFilterChain filterChainAdmin(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests()
                .antMatchers("/admin**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
     }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails charitha = User.builder()
                .username("charitha")
                .password(passwordEncoder.encode("password"))
                .roles(APP_USER.name())
                .build();

        UserDetails imalki = User.builder()
                .username("imalki")
                .password(passwordEncoder.encode("password"))
                .roles(TEACHER.name())
                .build();

        UserDetails pinky = User.builder()
                .username("pinky")
                .password(passwordEncoder.encode("password"))
                .roles(STUDENT.name())
                .build();

        UserDetails apeksha = User.builder()
                .username("apeksha")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(charitha,imalki,pinky,apeksha);
    }
}


