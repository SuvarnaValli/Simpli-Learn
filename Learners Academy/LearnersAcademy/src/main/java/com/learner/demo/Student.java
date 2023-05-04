package com.learner.demo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity 
	@Table(name="student_data") 
	public class Student { 
	// properties 
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="id") 
	private int id; 
	 
	@Column(name="student_name") 
	private String name; 
	
	@Column(name="first_name") 
	private String fname; 
	 
	@Column(name="last_name") 
	private String lname; 
	 
	 
	@Column(name="gender") 
	private String gender; 
	 
	@Column(name="d_of_birth") 
	private String dob; 
	 
	@Column(name="d_of_join") 
	private String doj; 
	 
	@Column(name="address") 
	private String address; 
	 
	@Column(name="standard") 
	private String standard; 
	
	@Column(name="fee") 
	private double fee;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	/*public void setDob(String dob) {
		//SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
	 try{
		 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dob);  
	 }catch(ParseException e1) { 
		 e1.printStackTrace(); 
		 } 
		this.dob = dob;
	}*/

	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public Student(int id, String name, String fname, String lname, String gender, String dob, String doj,
			String address, String standard, double fee) {
		super();
		this.id = id;
		this.name = name;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
		this.address = address;
		this.standard = standard;
		this.fee = fee;
	}

	public Student(String name, String fname, String lname, String gender, String dob, String doj, String address,
			String standard, double fee) {
		super();
		this.name = name;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
		this.address = address;
		this.standard = standard;
		this.fee = fee;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender
				+ ", dob=" + dob + ", doj=" + doj + ", address=" + address + ", standard=" + standard + ", fee=" + fee
				+ "]";
	} 
	
	

}
