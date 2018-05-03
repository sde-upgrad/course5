package org.upgrad.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.upgrad.repository.MoviesRepository;
import org.upgrad.repository.ShoppingcartRepository;
import org.upgrad.repository.ShowsRepository;
import org.upgrad.repository.UserEntityRepository;
import org.upgrad.model.Movies;
import org.upgrad.model.Shoppingcart;
import org.upgrad.model.Shows;
import org.upgrad.model.Userentity;
import sun.security.krb5.internal.Ticket;


@RestController
public class RestAPIController {

	@Autowired
	UserEntityRepository userEntityRepository;
	@Autowired
	MoviesRepository moviesRepository;

	@Autowired
	ShowsRepository showsRepository;

	@Autowired
	ShoppingcartRepository shoppingcartRepository;


	@GetMapping("/api/allmovies/")
	public Iterable<Movies> getAllMovies(){
		return moviesRepository.findAll();
	}

	@GetMapping("/api/upcomingmovies/")
	public Iterable<Movies> getAllUpcomingMovies(){
		return moviesRepository.findUpcomingMovies();
	}

	@GetMapping("/api/releasedmovies/")
	public Iterable<Movies> getAllReleasedMovies(){
		return moviesRepository.findReleasedMovies();
	}


	@RequestMapping("/api/findmoviebyid/")
	public String findMoviesById(@RequestParam("id") int id)
	{
		String result = moviesRepository.findById(id).get().toString();
		return result;
	}

	@GetMapping("/api/alltheshows/")
	public Iterable<Shows> getAllShows(){

		return showsRepository.findAll();
	}

	@GetMapping("/api/userexist/")
	public Boolean findUserExist(@RequestParam("uname") String name){

		String result= String.valueOf(userEntityRepository.findUserExist(name));

		if (result.equalsIgnoreCase("null"))
			return false;

		else
		return true;
	}

	@GetMapping("/api/signup/")
	public String PostRegistered(@RequestParam String uname,@RequestParam String password) {


		String result = String.valueOf(userEntityRepository.findUserExist(uname));


		if (!(result.equalsIgnoreCase("null")))
			return "user already exists";

		else {
			userEntityRepository.addUserCredentials(uname, password);
			return "done the user registration for "+ uname;
		}
	}

	@GetMapping("/api/allshowscity/")
	public List<Shows> getAllShowsByCity(@RequestParam("city")String city){
		return showsRepository.findAllShowsByCity(city);
	}

	@GetMapping("/api/bookmovieshowticket/")
	public String getShowTicket(@RequestParam("showid")int showId,@RequestParam("quantity")int quantity){
		String result= String.valueOf(showsRepository.findTicketAvailability(showId,quantity));
		if ((result.equalsIgnoreCase("null")))
			return "tickets not available";

		else{
			showsRepository.findBooking(showId,quantity);
			return quantity+" Tickets Booked for Show id " + showId;
		}

	}
	//@GetMapping("/signup/")
	//public List<Shows> getSignedUp(@RequestParam("username")String uname,){
	//	return UserEntityRepository.findSignUpPossiblity();
	//}

	@GetMapping("/api/allcity/")
	public List<String> getAllCities(){
		return showsRepository.findAllCity();
	}

	@GetMapping("/api/moviedesc/")
	public List<Movies> getMovieDesc(@RequestParam("name")String name){
		return moviesRepository.findMovieDetails(name);
	}


	@RequestMapping("/api/deleteashow/")
	public void deleteAShowById(@RequestParam("id") int id){
		showsRepository.deleteById(id);
	}



	@GetMapping("/api/shows/{data}")
	public List<Shows> shows(@RequestParam MultiValueMap<String, String> params){
		String language = params.get("AjaxID").get(0);
		String city = params.get("UserID").get(0);

		List<Shows> pvrs = new ArrayList<Shows>();
		showsRepository.findAll().forEach(pvrs::add);

		List<Shows> p = new  ArrayList<Shows>();
		for(int i = 0 ; i < pvrs.size() ; i++){
			Shows item = pvrs.get(i);
			if(item.getCity().equalsIgnoreCase(city) && item.getLanguage().equalsIgnoreCase(language)){
				p.add(item);
			}

		}

		return p;
	}

	@GetMapping("/api/movies/{data}")
    public Iterable<Movies> movies(@RequestParam MultiValueMap<String, String> params){
		 String language = params.get("AjaxID").get(0);
		 String city = params.get("UserID").get(0);
		 System.out.println("-->" + language + "--" + city);

        return moviesRepository.findAll();
    }


	@GetMapping("/api/shows/temp/")
    public Iterable<Shows> getShow(){
		 System.out.println("@@@@@@@@");

        return showsRepository.findAll();
    }

	@GetMapping("/api/movies/temp/")
    public Iterable<Movies> getTemp(){
		System.out.println("#################");
        return moviesRepository.findAll();
    }




	@GetMapping("/api/savecart/{data}")
    public void saveCart(@RequestParam MultiValueMap<String, String> params){
		 System.out.println("AjaxID: " + params.get("ajaxid"));
		 System.out.println("UserID: " + params.get("UserID"));
		 String userId = params.get("ajaxid").get(0);
		 String showIdStr = params.get("UserID").get(0);
		 String[] showArr = showIdStr.split("#");
		 for(int j = 0 ; j < showArr.length ; j++ ) {
			 System.out.println("-->>" + showArr[j]);
		 }

		 List<Shoppingcart> allcarts = new ArrayList<Shoppingcart>();
		 shoppingcartRepository.findAll().forEach(allcarts::add);
		 List<Shoppingcart> p = new ArrayList<Shoppingcart>();

		int tcartid = 0;
		int tuserid = 0;
		int tshowid = 0;
		int tnumberoftickets = 0;
		String tcartstring = "";

	     for(int i = 0 ; i < allcarts.size() ; i++) {
	    	 Shoppingcart item = allcarts.get(i);
	    		if(item.getUserid() == Integer.parseInt(userId)) {
	    			tcartid = item.getCartid();
	    			tuserid = item.getUserid();
	    			tshowid = item.getShowid();
	    			tnumberoftickets = item.getNumberoftickets();
	    			tcartstring = item.getCartstring();

	    			int id = item.getCartid();
	    			Optional<Shoppingcart> sh = shoppingcartRepository.findById(id);
	    			shoppingcartRepository.deleteById(sh.get().getCartid());
	    			shoppingcartRepository.saveAll(shoppingcartRepository.findAll());
	    		}
	    	}

	     tcartstring = showIdStr;

	     Shoppingcart sc = new Shoppingcart(tcartid, tuserid, tshowid, tnumberoftickets, tcartstring);
	     shoppingcartRepository.save(sc);
	     shoppingcartRepository.saveAll(shoppingcartRepository.findAll());
    }

	@GetMapping("/api/carts/all/")
    public Iterable<Shoppingcart> showCarts(){
		 return shoppingcartRepository.findAll();
    }

	@GetMapping("/api/loadcart/{data}")
    public String loadCart(@RequestParam MultiValueMap<String, String> params){
		 System.out.println("AjaxID: " + params.get("ajaxid"));
		 System.out.println("UserID: " + params.get("UserID"));
		 String userId = params.get("ajaxid").get(0);
		 String showIdStr = params.get("UserID").get(0);
		 return "{id: 1, title: anshul, visible: false},{id: 1, title: abhijeet, visible: false}";
	}


	@GetMapping("/api/loginattempt/{data}")
    public String loginAttempt(@RequestParam MultiValueMap<String, String> params){
		System.out.println("UserId: " + params.get("ajaxid"));
		System.out.println("Password: " + params.get("password"));

		List<Userentity> allUsers = new ArrayList<Userentity>();
		userEntityRepository.findAll().forEach(allUsers::add);

		String userid = params.get("ajaxid").get(0);
		String password = params.get("password").get(0);
		boolean isValid = false;
		System.out.println("-->>" + userid);
		System.out.println("-->>" + password);
		int userEntityId = 0;

		for(int j = 0 ; j < allUsers.size() ; j++) {
			Userentity obj = allUsers.get(j);
			System.out.println("################Inside loop--" + obj.getName()+ ";;;"+obj.getPassword());

			if(obj.getName().equalsIgnoreCase(userid) &&
					obj.getPassword().equals(password)) {
				System.out.println("Inside loop--");
				isValid = true;
				userEntityId = obj.getUserid();
			}
		}
		System.out.println("[{\"status\":\"ok\",\"userEntityId\":" + userEntityId + "}]");
		if(isValid)
			return "[{\"status\":\"ok\",\"userEntityId\":" + userEntityId + "}]\"";
		else
			return "[{\"status\":\"error\"}]";
	}

	@GetMapping("/api/allusers/")
    public Iterable<Userentity> allUsersInfo(){
		return userEntityRepository.findAll();
	}




}
