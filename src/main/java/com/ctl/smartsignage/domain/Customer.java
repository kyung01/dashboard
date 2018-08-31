package com.ctl.smartsignage.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
/**
 * @author Shivansh Bhatnagar
 */
@Entity
@Table(name="customer")
public class Customer {
	
	private User user;
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

		@Column(name="PHONE_ID")
		private  Long phone_id;
		@Column(name="COUNTRY_ID")
		private  Long country_id;
	    @Column(name = "FIRSTNAME")
	    private String firstname;
	    @Column(name = "LASTNAME")
	    private String lastname;
	    @Column(name = "EMAIL")
	    private String email;
	    @Size(max = 25)
	    @Column(name = "PASSWORD")
	    private String password;
	    @Column(name = "STREET")
	    private String street;
	    @Column(name = "CITY")
	    private String city;
	    @Column(name = "STATE_NAME")
	    private String state_name;
	    @Column(name = "POSTAL_CODE")
	    private String postal_code;
	    @Column(name = "ALT_PHONE")
	    private String alt_phone;
	    @Column(name = "ORGANIZATION")
	    private String organization;
	    @Column(name = "TOKEN")
	    private String token;
	    @Column(name = "DEVICE_TYPE")
	    private String device_type;
	    @Column(name = "DEVICE_TOKEN")
	    private String device_token;
	    @Column(name = "UPDATED_ON")
	    private Date updated_on;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "PHONE_ID")
	    public User getUser() {
	        return user;
	    }
		public Long getPhone_id() {
			return phone_id;
		}

		public Long getCountry_id() {
			return country_id;
		}

		public String getFirstname() {
			return firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}

		public String getStreet() {
			return street;
		}

		public String getCity() {
			return city;
		}

		public String getState_name() {
			return state_name;
		}

		public String getPostal_code() {
			return postal_code;
		}

		public String getAlt_phone() {
			return alt_phone;
		}

		public String getOrganization() {
			return organization;
		}

		public String getToken() {
			return token;
		}

		public String getDevice_type() {
			return device_type;
		}

		public String getDevice_token() {
			return device_token;
		}

		public Date getUpdated_on() {
			return updated_on;
		}

		public void setPhone_id(Long phone_id) {
			this.phone_id = phone_id;
		}

		public void setCountry_id(Long country_id) {
			this.country_id = country_id;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public void setState_name(String state_name) {
			this.state_name = state_name;
		}

		public void setPostal_code(String postal_code) {
			this.postal_code = postal_code;
		}

		public void setAlt_phone(String alt_phone) {
			this.alt_phone = alt_phone;
		}

		public void setOrganization(String organization) {
			this.organization = organization;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public void setDevice_type(String device_type) {
			this.device_type = device_type;
		}

		public void setDevice_token(String device_token) {
			this.device_token = device_token;
		}

		public void setUpdated_on(Date updated_on) {
			this.updated_on = updated_on;
		}
}
