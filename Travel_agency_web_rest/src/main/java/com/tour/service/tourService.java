package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.tour.controller.Person;
import com.tour.entity.person;


@Service
public class tourService
{
	@Autowired
	private tourRepsitory tourRepo;
	public void addperson(person newperson)
	{
		person.save(newperson);
		System.out.println("person Added successfully");
		
		
	}
	public List<person> allPerson()
	{
		return person.findAll();
		
	}
	public Person getPerson(Integer id)
	{
		return tourRepo.findById(id).orElseThrow(()->new 
				ResourceNotFoundException("person not found of id:"+id));
	
}

	public String deletepersonString(Integer id)
	{
		person foundPerson= tourRepo.findById(id).orElseThrow(()->new 
				ResourceNotFoundException("person not found of id:"+id));
		tourRepo.delete(foundPerson);
         return "person deleted successfully";
         
	
	}
	public List<person> updateMobile( Integer id,Person updatedMobile)
	{

		Person existingperson = ((Object) tourRepo.findById(id)).orElseThrow(()->new 
				ResourceNotFoundException("person not found of id:"+id));
		
	     person updatedPerson;
		Double updatedPrice=updatedPerson.getPrice();
	    
	     
	     existingperson.setPrice(updatedPrice);
	    
		return  person.findAll();
		
	}
	
	
	
	
	
}
	
