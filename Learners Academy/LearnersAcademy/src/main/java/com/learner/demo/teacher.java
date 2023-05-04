package com.learner.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import javax.persistence.ManyToMany;
import javax.persistence.Table;
//import javax.persistence.*;
@Entity 
@Table(name="teacher_data") 
public class teacher {
//public static boolean teachersession=false; 
// properties 
@Id 
@GeneratedValue(strategy=GenerationType.AUTO) 
@Column(name="teacher_id") 
private int id; 
 
@Column(name="teacher_name") 
private String tname; 

@Column(name="email") 
private String email; 
 
@Column(name="password") 
private String password; 
 
 
@Column(name="gender") 
private String gender; 
 
@Column(name="d_of_birth") 
private String dob; 
 
@Column(name="mobile") 
private String mobile; 
 
@Column(name="address") 
private String address; 
 
@Column(name="Subject") 
private String Subject;

/*@OneToMany(mappedBy = "teacher")
Set<classes_table> class_table;




public Set<classes_table> getClass_table() {
	return class_table;
}

public void setClass_table(Set<classes_table> class_table) {
	this.class_table = class_table;
}*/

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTname() {
	return tname;
}

public void setTname(String tname) {
	this.tname = tname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getSubject() {
	return Subject;
}

public void setSubject(String Subject) {
	this.Subject = Subject;
}

public teacher(int id, String tname, String email, String password, String gender, String dob, String mobile,
		String address, String Subject) {
	super();
	this.id = id;
	this.tname = tname;
	this.email = email;
	this.password = password;
	this.gender = gender;
	this.dob = dob;
	this.mobile = mobile;
	this.address = address;
	this.Subject = Subject;
}

public teacher(String tname, String email, String password, String gender, String dob, String mobile, String address,
		String Subject) {
	super();
	this.tname = tname;
	this.email = email;
	this.password = password;
	this.gender = gender;
	this.dob = dob;
	this.mobile = mobile;
	this.address = address;
	this.Subject = Subject;
}

public teacher() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "teacher [id=" + id + ", tname=" + tname + ", email=" + email + ", password=" + password + ", gender="
			+ gender + ", dob=" + dob + ", mobile=" + mobile + ", address=" + address + ", Subject=" + Subject + "]";
} 




}