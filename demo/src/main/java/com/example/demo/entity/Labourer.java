package com.example.demo.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="labour_details")
public class Labourer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="labourer_id")
	private int id;

	@NotNull
	@Pattern(regexp="^[a-zA-Z ]{1,50}")
	@Column(name="first_name")
	private String firstName;

	@NotNull
	@Pattern(regexp="^[a-zA-Z ]{1,50}")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@Past
	@Column(name="date_of_birth")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@NotNull
	@Column(name="permanent_address")
	private String permanentAddress;
	
	@NotNull
	@Pattern(regexp="[a-zA-Z ]{3,50}")
	@Column(name="permanent_address_city")
	private String permanentAddressCity;
	
	@NotNull
	@Pattern(regexp="[a-zA-Z ]{3,50}")
	@Column(name="permanent_address_state")
	private String permanentAddressState;
	
	@NotNull
	@Column(name="permanent_address_pin_code")
	@Pattern(regexp="^[1-9][0-9]{5}$")
	private String permanentAddressPinCode;
	
	@NotNull
	@Column(name="adhaar_no")
	@Pattern(regexp="[0-9]{12}")
	private String aadharNumber;
	
	@NotNull
	@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}")
	@Column(name="pan_no")
	private String panNum;
	
	@NotNull
	@Pattern(regexp="[0-9]{1,2}")
	@Column(name="skill_1")
	private String skill_1;
	
	@NotNull
	@Pattern(regexp="[0-9]{1,2}")
	@Column(name="skill_2")
	private String skill_2;
	
	@NotNull
	@Pattern(regexp="[0-9]{1,2}")
	@Column(name="skill_3")
	private String skill_3;
	
	@NotNull
	@Column(name="active_status")
	private boolean activeStatus;

	@NotNull
	@Column(name="currently_employed")
	private boolean currentlyEmployed;
	
	@NotNull
	@Column(name="phone_number")
	private String phoneNum;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified_date")
	private Date lastModifiedDate;
	
	public Labourer()
	{
		
	}

	public Labourer(String firstName, String lastName, Date dateOfBirth, String permanentAddress,
			String permanentAddressCity, String permanentAddressState, String permanentAddressPinCode, String aadharNumber,
			String panNum, String skill_1, String skill_2, String skill_3, boolean activeStatus, boolean currentlyEmployed,
			String phoneNum, Date creationDate, Date lastModifiedDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.permanentAddress = permanentAddress;
		this.permanentAddressCity = permanentAddressCity;
		this.permanentAddressState = permanentAddressState;
		this.permanentAddressPinCode = permanentAddressPinCode;
		this.aadharNumber = aadharNumber;
		this.panNum = panNum;
		this.skill_1 = skill_1;
		this.skill_2 = skill_2;
		this.skill_3 = skill_3;
		this.activeStatus = activeStatus;
		this.currentlyEmployed = currentlyEmployed;
		this.phoneNum = phoneNum;
		this.creationDate = creationDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPermanentAddressCity() {
		return permanentAddressCity;
	}

	public void setPermanentAddressCity(String permanentAddressCity) {
		this.permanentAddressCity = permanentAddressCity;
	}

	public String getPermanentAddressState() {
		return permanentAddressState;
	}

	public void setPermanentAddressState(String permanentAddressState) {
		this.permanentAddressState = permanentAddressState;
	}

	public String getPermanentAddressPinCode() {
		return permanentAddressPinCode;
	}

	public void setPermanentAddressPinCode(String permanentAddressPinCode) {
		this.permanentAddressPinCode = permanentAddressPinCode;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNum() {
		return panNum;
	}

	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}

	public String getSkill_1() {
		return skill_1;
	}

	public void setSkill_1(String skill_1) {
		this.skill_1 = skill_1;
	}

	public String getSkill_2() {
		return skill_2;
	}

	public void setSkill_2(String skill_2) {
		this.skill_2 = skill_2;
	}

	public String getSkill_3() {
		return skill_3;
	}

	public void setSkill_3(String skill_3) {
		this.skill_3 = skill_3;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public boolean isCurrentlyEmployed() {
		return currentlyEmployed;
	}

	public void setCurrentlyEmployed(boolean currentlyEmployed) {
		this.currentlyEmployed = currentlyEmployed;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "Labourer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", permanentAddress=" + permanentAddress + ", permanentAddressCity="
				+ permanentAddressCity + ", permanentAddressState=" + permanentAddressState
				+ ", permanentAddressPinCode=" + permanentAddressPinCode + ", aadharNumber=" + aadharNumber
				+ ", panNum=" + panNum + ", skill_1=" + skill_1 + ", skill_2=" + skill_2 + ", skill_3=" + skill_3
				+ ", activeStatus=" + activeStatus + ", currentlyEmployed=" + currentlyEmployed + ", phoneNum="
				+ phoneNum + ", creationDate=" + creationDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	
}