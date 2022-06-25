package com.hibernate.jpa.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="rooms")

public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_no")
	private int RoomNo;
	
	@Column(name="loction")
	private String Loction;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String loction) {
		super();
		
		Loction = loction;
	}

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}

	public String getLoction() {
		return Loction;
	}

	public void setLoction(String loction) {
		Loction = loction;
	}

	@Override
	public String toString() {
		return "Room [RoomNo=" + RoomNo + ", Loction=" + Loction + "]";
	}
	
		
}
