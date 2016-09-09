package com.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.model.Pet;
import com.rest.model.Status;
import com.rest.services.DataServices;

@Controller("/pet")
@Secured("ROLE_ADMIN")
@RequestMapping("/pet")
public class PetController {

	private static final int RNUMBER_INVALDI_CODE = 105;
	private static final String RNUMBER_INVALDI_MESSAGE = "Invalid Routing number";
	
	private static final int RNUMBER_NOTEXIST_DB_CODE = 102;
	private static final String RNUMBER_NOTEXIST_DB_MESSAGE = "Routing number does not exist in db";
	
	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(PetController.class);

	
	@RequestMapping(value = "/findByStatus/{status}", method = RequestMethod.GET)
	public @ResponseBody Object getRoutinginfo(@PathVariable("status") String status) {
		
		Pet p = null;
		//Validation goes here
		if( status.equals("sold")){
			Status status1  = new Status();
			status1.setCode(400);
			status1.setMessage("Invalid status value");
			return status1;
		}
		try {

			p = new Pet();
			p.setCategory("Dog");
			p.setId(1);
			p.setName("Puppy");
			p.setStatus(status);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	
	@RequestMapping(value = "/{petId}", method = RequestMethod.DELETE)
	public @ResponseBody Object delete(@PathVariable("petId") int petId) {
		
		Pet p = null;
		try {

			p = new Pet();
			p.setCategory("Dog");
			p.setId(petId);
			p.setName("Puppy");
			p.setStatus("Deleted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}
