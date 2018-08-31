package com.ctl.smartsignage.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
/**
 * @author Shivansh Bhatnagar
 */
@Entity
@Table(name = "users")
public class User extends BaseDomain{
  
	private static final long serialVersionUID = 1L;
    
    
    @Column(name="COMPANY_ID")
	private  int company_id;
    public int getCompany_id(){
		return company_id;
	}
    @Column(name = "USER_NAME")
    private String userName;
    @Size(max = 25)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "GROUP")
    private String group;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "PROFILE_PIC")
    private String profile_pic;
    @Column(name = "LAST_LOGIN")
    private String last_login;
    @Column(name = "UPDATED_ON")
    private Date updated_on;
   
    
    
   
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	  public String getRole() {
			return role;
		}

		public String getGroup() {
			return group;
		}

		public String getLocation() {
			return location;
		}

		public String getProfile_pic() {
			return profile_pic;
		}

		public String getLast_login() {
			return last_login;
		}

		public Date getUpdated_on() {
			return updated_on;
		}

		public void setCompany_id(int company_id) {
			this.company_id = company_id;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public void setGroup(String group) {
			this.group = group;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public void setProfile_pic(String profile_pic) {
			this.profile_pic = profile_pic;
		}

		public void setLast_login(String last_login) {
			this.last_login = last_login;
		}

		public void setUpdated_on(Date updated_on) {
			this.updated_on = updated_on;
		}


}
