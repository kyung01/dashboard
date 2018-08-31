package com.ctl.smartsignage.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="message_group")
/**
 * @author Shivansh Bhatnagar
 */
public class MessageGroup {
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
	
	@Column(name="NAME")
	private  String name;
	@Column(name="DESCRIPTION")
	private  String description;
	@Column(name="UPDATED_ON")
	private  Date updated_on;
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}
}
