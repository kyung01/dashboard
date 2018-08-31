package com.ctl.smartsignage.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Shivansh Bhatnagar
 */
@Entity
@Table(name="company")
public class Company {
	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue
	private Long id;
	public Long getId(){
		return id;
	}
	
	public void setId ( Long id_in){
		this.id=id_in;
	}
	
	@Column(name="COMPANY_NAME")
	private  String company_name;
	@Column(name="ADDRESS")
	private  String address;
	@Column(name="ZIPCODE")
	private  String zipcode;
	@Column(name="CITY")
	private  String city;
	@Column(name="STATE")
	private  String state;
	@Column(name="COUNTRY")
	private  String country;
	@Column(name="PHONE")
	private  Long phone;
	@Column(name="DESCRIPTION")
	private  String description;
	@Column(name="LOGO")
	private  String logo;
	@Column(name="UPDATED_ON")
	private  Date updated_on;
	
	
	public String getCompany_name() {
		return company_name;
	}

	public String getAddress() {
		return address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public Long getPhone() {
		return phone;
	}

	public String getDescription() {
		return description;
	}

	public String getLogo() {
		return logo;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}
}
