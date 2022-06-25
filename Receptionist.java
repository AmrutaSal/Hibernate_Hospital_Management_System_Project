package com.hibernate.jpa.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="receptionists")

public class Receptionist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="receptionist_id")
	private int receptionistId;
	
	@Column(name="name")
	private String name;

	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

	public Receptionist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Receptionist( String name, Patient patient) {
		super();
		
		this.name = name;
		this.patient = patient;
	}

	public int getReceptionistId() {
		return receptionistId;
	}

	public void setReceptionistId(int receptionistId) {
		this.receptionistId = receptionistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Receptionist [receptionistId=" + receptionistId + ", name=" + name + ", patient=" + patient + "]";
	}
	
	
}
