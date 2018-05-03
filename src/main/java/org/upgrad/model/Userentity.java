package org.upgrad.model;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Userentity {

	@Id
	private int userid;	
	private String name;
	private String password;

	public Userentity() {}
	public Userentity(int userid, String name, String password) {
		super();
		this.userid = userid;
		this.name = name;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
}
