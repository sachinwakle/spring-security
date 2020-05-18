package io.sawa.security.app.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetail implements UserDetails {
    private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> grantedAuthority;

    public MyUserDetail() {
    }

    public MyUserDetail(String username) {
	this.username = username;
    }

    public MyUserDetail(UserInfo user) {
	this.username = user.getUserName().trim();
	this.password = user.getPassword().trim();
	this.active = user.isActive();
	this.grantedAuthority = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
		.collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return this.grantedAuthority;
    }

    @Override
    public String getPassword() {
	return this.password;
    }

    @Override
    public String getUsername() {
	return this.username;
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
	return this.active;
    }

}
