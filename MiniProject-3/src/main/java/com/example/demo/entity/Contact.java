package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactId;
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	
	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;
	
	@Column(name = "CONTACT_EMAIL")
	private String  contactEmail;
	
	@CreationTimestamp    
	@Column(name = "CREATED_DATE", updatable=false) 
	private LocalDate  createdDate; 
	
	
	@UpdateTimestamp 
	@Column(name = "UPDATED_DATE",insertable = false) 
	private LocalDate updatedDate; 
	
	
	//KIMDA VARIABLE EDI ACTIVE SWICTH RASAM IT REPRESENT WHETHER THE RECORD IS ACTIVE OR INACTIVE OK.
	@Column(name = "ACTIVE_SW")
	private String activeSw;


	public Integer getContactId() {
		return contactId;
	}


	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}


	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public Long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getContactEmail() {
		return contactEmail;
	}


	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}


	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}


	public LocalDate getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getActiveSw() {
		return activeSw;
	}


	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}


	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactNumber=" + contactNumber
				+ ", contactEmail=" + contactEmail + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", activeSw=" + activeSw + "]";
	}
	
	
	
			
	

	

	//@Entity pettam kabatti [embeded] database lo table create application run avvagane [application.prperties] lo kuda alane ichham ok.
	
}
