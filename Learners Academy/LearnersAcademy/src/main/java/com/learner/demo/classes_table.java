package com.learner.demo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;



@Entity 
@Table(name="Classes_data") 
public class classes_table {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="id") 
	private int id; 
	 
	/*@Column(name="Teacher_id") 
	private String teacherid; 

	@Column(name="subject_id") 
	private String subjectid; */
	 
	@Column(name="standard") 
	private String std;
	
	
	
	@Column(name="time") 
	private String time;
	@ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_id")
	 teacher teacher;
	@ManyToOne
	@MapsId("SubjectId")
	@JoinColumn(name = "Subject_id")
	 Subject Subject;
	


	
	public int getId() {
		return id;
	}
	public classes_table(String std, String time, com.learner.demo.teacher teacher, com.learner.demo.Subject Subject) {
		super();
		this.std = std;
		this.time = time;
		this.teacher = teacher;
		this.Subject = Subject;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(teacher teacher) {
		this.teacher = teacher;
	}
	public Subject getSubject() {
		return Subject;
	}
	public void setSubject(Subject Subject) {
		this.Subject = Subject;
	}
	public classes_table(int id, String std, String time, com.learner.demo.teacher teacher,
			com.learner.demo.Subject Subject) {
		super();
		this.id = id;
		this.std = std;
		this.time = time;
		this.teacher = teacher;
		this.Subject = Subject;
	}
	
	
	public classes_table() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "classes_table [id=" + id + ", std=" + std + ", time=" + time + ", teacher=" + teacher + ", Subject="
				+ Subject + "]";
	}
	
	
	
	
}
