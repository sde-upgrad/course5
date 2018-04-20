package org.jeet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestAPIController {
	
	@Autowired
	MoviesRepository moviesRepository;
	
	@GetMapping("/movies")
    public Iterable<Movies> movies(){
        return moviesRepository.findAll();
    }
    
    

}
