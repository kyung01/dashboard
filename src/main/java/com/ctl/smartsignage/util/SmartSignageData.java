package com.ctl.smartsignage.util;

import java.util.Date;

/**
 * @author Arun Kumar Tiwari
 */
public class SmartSignageData 
{
	private String parkingName;
	private Long parkingId;
	private int relays;
	private Date syncDatetime;
	private Long syncWaitingTime;
	public Date getSyncDatetime() {
		return syncDatetime;
	}
	public void setSyncDatetime(Date syncDatetime) {
		this.syncDatetime = syncDatetime;
	}
	public String getParkingName() {
		return parkingName;
	}
	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}
	public Long getParkingId() {
		return parkingId;
	}
	public void setParkingId(Long parkingId) {
		this.parkingId = parkingId;
	}
	public int getRelays() {
		return relays;
	}
	public void setRelays(int relays) {
		this.relays = relays;
	}
	public Long getSyncWaitingTime() {
		return syncWaitingTime;
	}
	public void setSyncWaitingTime(Long syncWaitingTime) {
		this.syncWaitingTime = syncWaitingTime;
	}
	
}
