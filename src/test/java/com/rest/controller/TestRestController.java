package com.rest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.Assert;
import junit.framework.TestCase;


public class TestRestController extends TestCase {
	
	@Test(expected = Exception.class)
	public void getRoutinginfoTest(String id){
		RestController test = new RestController();
		Object o = test.deleteRoutingInfo("222222229", "24.4.5.6.7");
				
	}
	
	
	@Test
	public void testAdd(){
		int a = 10;
		int b = 20;
		
		RestController rc = new RestController();
		int c = rc.add(a, b);
	}

}
