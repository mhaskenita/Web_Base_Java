package com.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.tour.person;



@RestController
public class TourController 
{
	@Autowired
	 private TourService tourService;
	 // http://localhost:8083/add === post
	 @PostMapping("/add")
	 public void addperson(@RequestBody TourController newtour)
	 {
		 tourService.addPerson(newtour);
		 
	 }
	//http://localhost:8084/add === Get
	 @GetMapping("/person")
	  public List<person>getAllPerson()
	  {
	 	 return tourService.allPerson();
	  }
	 
	  
	  @GetMapping("/Tour/{id}")
	  public person getPersonById(@PathVariable Integer id)
	  {
		  person foundperson=null;
	  	try {
  		foundperson=tourService.getperson(id);
	  		return tourService.getperson(id);
	
		  
	  }
	  	catch (Exception e)  
	  	{  	
	  		e.printStackTrace();
	  	}
	  	return foundperson; 
  }
	//http://localhost:8084/delete/{id} ----delete
	  @DeleteMapping("/delete/{id}")
	  public String deleteperson(@PathVariable Integer id)
	  {
	  	try {
	  		return tourService.deletePerson(id);
	  		
	  	} 
	  	catch (Exception e) {
	  		return e.getMessage();
	  	}
	  	
	
  			  			
		}
	  //http://localhost:8084/update/{id}
	  	
	  	@PutMapping("/update/{id}")
	  	  public String updatedPersonById(@PathVariable Integer id,@RequestBody Person updatedperson) 
	  	   {
		  
		try {
			return tourService.updateperson(id, updatedperson);
		}
		catch (Exception e) 
		{
		return e.getMessage();
	    }
  	

}
	  
	  


	  
	  
}
