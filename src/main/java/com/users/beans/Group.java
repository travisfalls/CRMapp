package com.users.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String groupName;
	private String meetingDay;
	
	public Group(){
		
	}
	
	public Group(String groupName, String meetingDay) {
		super();
		this.groupName = groupName;
		this.meetingDay = meetingDay;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getMeetingDay() {
		return meetingDay;
	}

	public void setMeetingDay(String meetingDay) {
		this.meetingDay = meetingDay;
	}

	
	@Override
	public String toString() { //Concatenating labels and information
		return "User [id=" + id + ", groupName=" + groupName + ", meetingDay=" + meetingDay + "]";
	}
	
	
}
