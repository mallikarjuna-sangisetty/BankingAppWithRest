package com.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.model.BankRTable;
import com.rest.model.Status;
import com.rest.services.DataServices;
import com.rest.util.Utility;

@Controller("/banking")
@Secured("ROLE_ADMIN")
//@RequestMapping("/banking")
public class RestController {

	private static final int RNUMBER_INVALDI_CODE = 105;
	private static final String RNUMBER_INVALDI_MESSAGE = "Invalid Routing number";
	
	private static final int RNUMBER_NOTEXIST_DB_CODE = 102;
	private static final String RNUMBER_NOTEXIST_DB_MESSAGE = "Routing number does not exist in db";
	
	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping
	public @ResponseBody Object getAll() {
		Status status1  = new Status();
		status1.setCode(200);
		status1.setMessage("Simple call");
		return status1;
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Object getRoutinginfo(@PathVariable("id") String id) {
		
		BankRTable bankRTable = null;
		//Validation goes here
		if( !Utility.validateNumber(id)){
			Status status  = new Status();
			status.setCode(RNUMBER_INVALDI_CODE);
			status.setMessage(RNUMBER_INVALDI_MESSAGE+" "+id);
			return status;
		}
		try {
			bankRTable = dataServices.getEntityById(id);

			if( bankRTable == null){
				Status status  = new Status();
				status.setCode(RNUMBER_NOTEXIST_DB_CODE);
				status.setMessage(RNUMBER_NOTEXIST_DB_MESSAGE);
				return status;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankRTable;
	}
	
	@RequestMapping(value="/pet1/{petId}",method=RequestMethod.POST)
	public @ResponseBody Object updatePet(@PathVariable("petId") long petId,@RequestParam String name,@RequestParam String status){
		Status status1  = new Status();
		status1.setCode(200);
		status1.setMessage("Pet Updated successfully");
		return status1;
	}
	
	
	
	@RequestMapping(value="/pet1/{petId}",method=RequestMethod.DELETE)
	public @ResponseBody Object DeletePet(@PathVariable("petId") long petId,@RequestParam String name,@RequestParam String status){
		Status status1  = new Status();
		status1.setCode(204);
		status1.setMessage("Pet Deleted successfully");
		return status1;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	Object saveRoutingInfo(@PathVariable("id") String id,@RequestParam String ip) {
		
		BankRTable bankRTable = null;
		//Validation goes here
		if( !Utility.validateNumber(id)){
			Status status  = new Status();
			status.setCode(RNUMBER_INVALDI_CODE);
			status.setMessage(RNUMBER_INVALDI_MESSAGE+" "+id);
			return status;
		}
		try {
			BankRTable table = new BankRTable();
			table.setId(id);
			table.setNetmask(ip);
			table.setDestination("destination");
			table.setGateway("Gateway");
			table.setMetric(10);
			table.setNetmask("net");
			
			int rows = dataServices.saveEntity(table);

			if( bankRTable == null){
				Status status  = new Status();
				status.setCode(0200);
				status.setMessage("Successful");
				return status;
			}
		} catch (Exception e) {
			logger.info("", e);
		}
		return bankRTable;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Object updateRoutingInfo(@PathVariable("id") String id,@RequestParam String ip) {
		
		BankRTable bankRTable = null;
		//Validation goes here
		if( !Utility.validateNumber(id)){
			Status status  = new Status();
			status.setCode(RNUMBER_INVALDI_CODE);
			status.setMessage(RNUMBER_INVALDI_MESSAGE+" "+id);
			return status;
		}
		try {
			BankRTable table = new BankRTable();
			table.setId(id);
			table.setNetmask(ip);
			table.setDestination("destination");
			table.setGateway("Gateway");
			int rows = dataServices.updateEntity(table);

			if( bankRTable == null){
				Status status  = new Status();
				status.setCode(0200);
				status.setMessage("Successful");
				return status;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankRTable;
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Object deleteRoutingInfo(@PathVariable("id") String id,@RequestParam String ip) {
		
		BankRTable bankRTable = null;
		//Validation goes here
		if( !Utility.validateNumber(id)){
			Status status  = new Status();
			status.setCode(RNUMBER_INVALDI_CODE);
			status.setMessage(RNUMBER_INVALDI_MESSAGE+" "+id);
			return status;
		}
		try {
			BankRTable table = new BankRTable();
			table.setId(id);
			table.setNetmask(ip);
			table.setDestination("destination");
			table.setGateway("Gateway");
			int rows = dataServices.deleteEntity(table);

			if( bankRTable == null){
				Status status  = new Status();
				status.setCode(0200);
				status.setMessage("Successful");
				return status;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankRTable;
	}
	int add(int a,int b){
		return a+b;
	}
}
