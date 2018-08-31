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
@Table(name="beacon_location")
public class BeaconLocation {
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
	
	@Column(name="BEACON_ID")
	private  String beacon_id;
	@Column(name="LATITUDE")
	private  String latitude;
	@Column(name="LONGITUDE")
	private  String longitude;
	@Column(name="STATUS")
	private  int status;
	@Column(name="IS_STABLE")
	private  int is_stable;
	@Column(name="OFFLINE_MODE")
	private  int offline_mode;
	@Column(name="UPDATED_ON")
	private  Date updated_on;
	
	
	public String getBeacon_id() {
		return beacon_id;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public int getStatus() {
		return status;
	}

	public int getIs_stable() {
		return is_stable;
	}

	public int getOffline_mode() {
		return offline_mode;
	}

	public Date getUpdated_on() {
		return updated_on;
	}
}
