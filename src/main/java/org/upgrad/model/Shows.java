package org.upgrad.model;

import org.springframework.stereotype.Indexed;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="shows",indexes = {@Index(name="showIndex",columnList = "showid",unique=true)})
public class Shows {

	@Id
	private int showid;	
	private String language;
	private String city;
	private int availability;
	int movieid;
	private Date date;
	
	public Shows() {}
	public Shows(int showid, String language, String city,int availability,int movieid,Date date) {
		super();
		this.showid = showid;
		this.language = language;
		this.city = city;
		this.availability = availability;
		this.movieid=movieid;
		this.date=date;
	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
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
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
