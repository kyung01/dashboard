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
@Table(name="phone")
public class Phone {
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
	
	@Column(name="IMEI_NUMBER")
	private  String imei_number;
	@Column(name="PHONE_NUMBER")
	private  Date phone_number;
	@Column(name="MODEL")
	private  String model;
	@Column(name="OS")
	private  String os;
	@Column(name="MAC_ADDRESS")
	private  int mac_address;
	@Column(name="SERVICE_PROVIDER")
	private  Date service_provider;
	@Column(name="PHONE_ACCOUNT_NUMBER")
	private  Date phone_account_number;
	@Column(name="DELAY")
	private  int delay;
	@Column(name="UPDATED_ON")
	private  Date updated_on;
	
	public String getImei_number() {
		return imei_number;
	}

	public Date getPhone_number() {
		return phone_number;
	}

	public String getModel() {
		return model;
	}

	public String getOs() {
		return os;
	}

	public int getMac_address() {
		return mac_address;
	}

	public Date getService_provider() {
		return service_provider;
	}

	public Date getPhone_account_number() {
		return phone_account_number;
	}

	public int getDelay() {
		return delay;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setImei_number(String imei_number) {
		this.imei_number = imei_number;
	}

	public void setPhone_number(Date phone_number) {
		this.phone_number = phone_number;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public void setMac_address(int mac_address) {
		this.mac_address = mac_address;
	}

	public void setService_provider(Date service_provider) {
		this.service_provider = service_provider;
	}

	public void setPhone_account_number(Date phone_account_number) {
		this.phone_account_number = phone_account_number;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}
}
