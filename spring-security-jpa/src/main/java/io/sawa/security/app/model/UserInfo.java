package io.sawa.security.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean active;

    private String password;

    private String roles;

    private String userName;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getRoles() {
	return roles;
    }

    public void setRoles(String roles) {
	this.roles = roles;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    @Override
    public String toString() {
	return "UserInfo [id=" + id + ", active=" + active + ", password=" + password + ", roles=" + roles
		+ ", userName=" + userName + "]";
    }

}
