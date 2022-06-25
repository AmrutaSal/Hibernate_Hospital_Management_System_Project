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
@Table (name="bills")

public class Bill {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="billno")
	private String billNo;
	
	@Column(name="patientname")
	private String PatientName;
	
	@Column(name="amount")
	private float amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patient_id")
	private Patient patient;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(float amount, Patient patient) {
		super();
		this.amount = amount;
		this.patient = patient;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getPatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Bill [billNo=" + billNo + ", PatientName=" + PatientName + ", amount=" + amount + ", patient=" + patient
				+ "]";
	}

		
	
}
