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
@Table(name="beacons")
public class Beacon {
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
	@Column(name="BEACON_NAME")
	private  String beacon_name;
	@Column(name="MAC_ADDRESS")
	private  String mac_address;
	@Column(name="IS_EDDYSTONE")
	private  int is_eddystone;
	@Column(name="IS_IBEACON")
	private  int is_beacon;
	@Column(name="STABILITY")
	private  String stability;
	@Column(name="STATUS")
	private  int status;
	@Column(name="OFFLINE_MODE")
	private  String offline_mode;
	@Column(name="IS_REGISTERED")
	private  String is_registered;
	@Column(name="UPDATED_ON")
	private  Date updated_on;
	
	
	public String getMac_address() {
		return mac_address;
	}

	public int getIs_eddystone() {
		return is_eddystone;
	}

	public int getIs_beacon() {
		return is_beacon;
	}

	public String getStability() {
		return stability;
	}

	public int getStatus() {
		return status;
	}

	public String getOffline_mode() {
		return offline_mode;
	}

	public String getIs_registered() {
		return is_registered;
	}

	public Date getUpdated_on() {
		return updated_on;
	}
}
