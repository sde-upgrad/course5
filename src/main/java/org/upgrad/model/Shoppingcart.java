package org.upgrad.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shoppingcart {

	@Id
	private int cartid;
	private int userid;
	private int showid;
	private int numberoftickets;
	private String cartstring;
	
	public Shoppingcart() {}
	
	public Shoppingcart(int cartid, int userid, int showid, int numberoftickets, String cartstring) {
		super();
		this.cartid = cartid;
		this.userid = userid;
		this.showid = showid;
		this.numberoftickets = numberoftickets;
		this.cartstring = cartstring;
	}
	
	

	public String getCartstring() {
		return cartstring;
	}



	public void setCartstring(String cartstring) {
		this.cartstring = cartstring;
	}



	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getShowid() {
		return showid;
	}

	public void setShowid(int showid) {
		this.showid = showid;
	}

	public int getNumberoftickets() {
		return numberoftickets;
	}

	public void setNumberoftickets(int numberoftickets) {
		this.numberoftickets = numberoftickets;
	}
	
	
	
	
}
