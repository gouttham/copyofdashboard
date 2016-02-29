package com.dashboard.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="db_profile")
public class ProfileBean {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int autoGen;
	
	
	
	@OneToOne
	@JoinColumn(name="profileId")
	private CredentialBean profileId;
	
	private String name;
	private String managerId;
	private String vertical;
	private String emailId;
	private String phoneNo;
	private String location;
	
	public int getAutoGen() {
		return autoGen;
	}
	public void setAutoGen(int autoGen) {
		this.autoGen = autoGen;
	}
	public CredentialBean getProfileId() {
		return profileId;
	}
	public void setProfileId(CredentialBean profileId) {
		this.profileId = profileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getVertical() {
		return vertical;
	}
	public void setVertical(String vertical) {
		this.vertical = vertical;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
