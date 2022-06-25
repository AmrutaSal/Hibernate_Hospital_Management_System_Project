package com.hibernate.jpa.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="patients")

public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="patient_name")
	private String PatientName;

	@Column(name="phone_no")
	private int PhoneNo;
	
	@Column(name="address")
	private String Address;
	
	@Column(name="age")
	private int Age;
	
	@Column(name="sex")
	private String sex;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patients_doctors", 
	joinColumns = { @JoinColumn (name = "patient_id")},
	inverseJoinColumns = { @JoinColumn (name = "doc_id")})
	private Set<Doctor> doctors = new HashSet<Doctor>();
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="room_no")
	private Room room;


	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient(String patientName, int phoneNo, String address, int age, String sex,
			Set<Doctor> doctors, Room room) {
		super();
		PatientName = patientName;
		PhoneNo = phoneNo;
		Address = address;
		Age = age;
		this.sex = sex;
		this.doctors = doctors;
		this.room = room;
	}


	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public String getPatientName() {
		return PatientName;
	}


	public void setPatientName(String patientName) {
		PatientName = patientName;
	}


	public int getPhoneNo() {
		return PhoneNo;
	}


	public void setPhoneNo(int phoneNo) {
		PhoneNo = phoneNo;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	

	public Set<Doctor> getDoctors() {
		return doctors;
	}


	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", PatientName=" + PatientName + ", PhoneNo=" + PhoneNo
				+ ", Address=" + Address + ", Age=" + Age + ", sex=" + sex + ", doctors="
				+ doctors + ", room=" + room + "]";
	}


		
	


}
