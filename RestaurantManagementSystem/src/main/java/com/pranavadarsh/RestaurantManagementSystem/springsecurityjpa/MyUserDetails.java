package com.pranavadarsh.RestaurantManagementSystem.springsecurityjpa;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class MyUserDetails implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String userName;

    String password;

    boolean isEnabled;

    String authorities;

    public MyUserDetails(String userName, String password, boolean isEnabled, String authorities){
        this.userName = userName;
        this.password = password;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
    }

    public MyUserDetails(){
    }

    /* piyush approach GFG 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        String[]auth = this.authorities.split(":");
        for(int i=0;i<auth.length; i++){
            GrantedAuthority obj = new SimpleGrantedAuthority(auth[i]);
            authorities.add(obj);
        }

        System.out.println(authorities);
        return authorities;
    }
    */
    
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // (GrantedAuthority <== Interface) and (SimpleGrantedAuthority <== Class)
		
		List<SimpleGrantedAuthority> authorites = new ArrayList<SimpleGrantedAuthority>();// List<GrantedAuthority> authorities = new ArrayList<>(); it will also work
		
		String[] roles=this.authorities.split(":"); //getRoles().split(":") are giving string based roles separated by collan(:) Note:- getRoles is a String.
		for(int i=0;i<roles.length;i++) {
			authorites.add(new SimpleGrantedAuthority(roles[i]));
			System.out.println("Inside MyUserDetails "+roles[i]);
		}
			
		return authorites;

	}

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(String authorities) {
        this.authorities = authorities;
    }
}
