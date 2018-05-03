package org.upgrad.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Movies {
 
	@Id
    private int id;
    private String name;
    private String day;
    private String description;
    private String released;
    private int rating;
	private Date release_date;





    public Movies() {}
 
    public Movies(int id, String name, String day, String description, String released, int rating,Date releaseDate) {
    	this.id = id;
        this.name = name;
        this.day = day;
        this.description = description;
        this.released = released;
        this.rating = rating;
        this.release_date=releaseDate;
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


	public Date getReleaseDate() {
		return release_date;
	}

	public void setReleaseDate(Date releaseDate) {
		this.release_date = releaseDate;
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
