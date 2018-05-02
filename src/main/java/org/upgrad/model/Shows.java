package org.upgrad.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shows {
	
	@Id
	private int showid;	
	private String language;
	private String city;
	private String pvrcinema;
	private String moviename;
	private String description;
	private int availability;
	private String day;
	
	public Shows() {}
	public Shows(int showid, String language, String city, String pvrcinema, String moviename, int availability, String description, String day) {
		super();
		this.showid = showid;
		this.language = language;
		this.city = city;
		this.pvrcinema = pvrcinema;
		this.moviename = moviename;
		this.availability = availability;
		this.description = description;
		this.day = day;
	}
	
	
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getShowid() {
		return showid;
	}
	public void setShowid(int showid) {
		this.showid = showid;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPvrcinema() {
		return pvrcinema;
	}
	public void setPvrcinema(String pvrcinema) {
		this.pvrcinema = pvrcinema;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	

}