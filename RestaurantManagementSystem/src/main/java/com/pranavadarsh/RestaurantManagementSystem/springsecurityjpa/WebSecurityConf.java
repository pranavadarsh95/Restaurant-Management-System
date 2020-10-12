package com.pranavadarsh.RestaurantManagementSystem.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

    
  // MyAuthService ==> Class and UserDetailsService ==> Interface
    
    @Autowired
    UserDetailsService userDetailsService;  // if we use  MyAuthService userDetailsService; this will also work

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/user").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }*/
    
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
	    
		
	    .antMatchers("/RestaurantDetail/saveRestaurant","/RestaurantDetail/getRestaurant/**").hasAnyAuthority("ADMIN", "RESTAURANT_OWNER")
        .antMatchers("/userDetail/getUser/**").hasAnyAuthority("ADMIN", "USER")
        .antMatchers("/ReservationDetail/getReservation/**").hasAnyAuthority("ADMIN", "RESTAURANT_OWNER","USER")
        .antMatchers("/ReservationDetail/bookReservation","/RestaurantDetail/getALLRestaurants","/userDetail/saveUserWithoutLogin").permitAll()
        .antMatchers("/ReservationDetail/**","/RestaurantDetail/**","/userDetail/**").hasAuthority("ADMIN")
        .antMatchers("/**").permitAll()
        .and().formLogin();
	}
    

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}