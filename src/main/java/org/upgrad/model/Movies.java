package org.upgrad.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movies {
 
	@Id
    private int id;
    private String name;
    private String day;
    private String description;
    private String released;
    private int rating;
 
    public Movies() {}
 
    public Movies(int id, String name, String day, String description, String released, int rating) {
    	this.id = id;
        this.name = name;
        this.day = day;
        this.description = description;
        this.released = released;
        this.rating = rating;
    }
    
    
    public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day='" + day + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}