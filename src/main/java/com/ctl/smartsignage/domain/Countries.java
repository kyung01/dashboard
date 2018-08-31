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
@Table(name="countries")
public class Countries {
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
	
	@Column(name="Prefix")
	private  String prefix;
	@Column(name="Name")
	private  String name;
	@Column(name="NameH")
	private  String nameh;
	@Column(name="ShortName")
	private  String shortname;
	@Column(name="CreatedBy")
	private  Long createdby;
	@Column(name="CreatedOn")
	private  Date createdon;
	@Column(name="ModifiedBy")
	private  Long modifiedby;
	@Column(name="ModifiedOn")
	private  Date modifiedon;
	@Column(name="IsActive")
	private  String isactive;
	@Column(name="UPDATED_ON")
	private  Date updated_on;
	
	
	public String getPrefix() {
		return prefix;
	}

	public String getName() {
		return name;
	}

	public String getNameh() {
		return nameh;
	}

	public String getShortname() {
		return shortname;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public Long getModifiedby() {
		return modifiedby;
	}

	public Date getModifiedon() {
		return modifiedon;
	}

	public String getIsactive() {
		return isactive;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}
}
