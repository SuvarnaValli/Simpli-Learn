package com.admin.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="admin_data") 
public class admin { 
public static boolean adminsession=false; 
// properties 
@Id 
@GeneratedValue(strategy=GenerationType.AUTO) 
@Column(name="id") 
private int id; 
 
@Column(name="adminname") 
private String adminname; 
 
@Column(name="password") 
private String password;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public String getAdminname() {
	return adminname;
}

public void setAdminname(String adminname) {
	this.adminname = adminname;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public admin(int id, String adminname, String password) {
	super();
	this.id = id;
	this.adminname = adminname;
	this.password = password;
}

public admin() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "admin [id=" + id + ", adminname=" + adminname + ", password=" + password + "]";
}

public admin( String password) {
	super();
	
	this.password = password;
}

public admin(String adminname, String password) {
	super();
	this.adminname = adminname;
	this.password = password;
}




}
