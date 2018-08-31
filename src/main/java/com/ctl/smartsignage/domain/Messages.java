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
@Table(name="messages")
public class Messages {
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
	@Column(name="GROUP_ID")
	private  Long group_id;
	@Column(name="DATE_TIME")
	private  Date date_time;
	@Column(name="TYPE")
	private  String type;
	@Column(name="CONTENT")
	private  String content;
	@Column(name="IS_ACTIVE")
	private  int is_active;
	@Column(name="EXPIRY_DATE")
	private  Date expiry_date;
	@Column(name="UPDATED_ON")
	private  Date updated_on;
	public Long getGroup_id() {
		return group_id;
	}

	public Date getDate_time() {
		return date_time;
	}

	public String getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public int getIs_active() {
		return is_active;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}
}
