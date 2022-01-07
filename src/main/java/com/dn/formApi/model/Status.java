package com.dn.formApi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form_status")
public class Status {

	@Id
	private String email;
	private String status;
	
	public Status(String email, String status) {
		super();
		this.email = email;
		this.status = status;
	}
	
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Status [email=" + email + ", status=" + status + "]";
	}
	
	
}
