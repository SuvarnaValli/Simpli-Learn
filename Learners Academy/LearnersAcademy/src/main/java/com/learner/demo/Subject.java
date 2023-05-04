package com.learner.demo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity 
@Table(name="Subject_data") 
public class Subject {
//public static boolean studentsession=false; 
// properties 
@Id 
@GeneratedValue(strategy=GenerationType.AUTO) 
@Column(name="Subject_id") 
private int id; 
 
@Column(name="Subject_name") 
private String subname; 

@Column(name="subjectcode") 
private String subjectcode; 
 
@Column(name="standard") 
private String std;

/*@OneToMany(mappedBy = "Subject")
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

public String getSubname() {
	return subname;
}

public void setSubname(String subname) {
	this.subname = subname;
}

public String getSubjectcode() {
	return subjectcode;
}

public void setSubjectcode(String subjectcode) {
	this.subjectcode = subjectcode;
}

public String getStd() {
	return std;
}

public void setStd(String std) {
	this.std = std;
}

public Subject(int id, String subname, String subjectcode, String std) {
	super();
	this.id = id;                    
	this.subname = subname;
	this.subjectcode = subjectcode;
	this.std = std;
}


public Subject(String subname, String subjectcode, String std) {
	super();
	this.subname = subname;
	this.subjectcode = subjectcode;
	this.std = std;
}

public Subject() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Subject [id=" + id + ", subname=" + subname + ", subjectcode=" + subjectcode + ", std=" + std + "]";
} 




}
