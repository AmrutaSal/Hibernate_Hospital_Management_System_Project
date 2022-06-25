package com.hibernate.jpa.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="doctors")

public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doc_id")
	private int docid;
	
	@Column(name="name")
	private String Name;
	
	@Column(name="specilization")
	private String Specilization;
	
	@Column(name="phoneno")
	private int PhoneNo;
	
	@Column(name="location")
	private String Location;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="dept_id")
	private Department department;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String name, String specilization, int phoneNo, String location, Department department) {
		super();
		Name = name;
		Specilization = specilization;
		PhoneNo = phoneNo;
		Location = location;
		this.department = department;
	}

	public int getDocid() {
		return docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSpecilization() {
		return Specilization;
	}

	public void setSpecilization(String specilization) {
		Specilization = specilization;
	}

	public int getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Doctor [docid=" + docid + ", Name=" + Name + ", Specilization=" + Specilization + ", PhoneNo=" + PhoneNo
				+ ", Location=" + Location + ", department=" + department + "]";
	}

		
}
