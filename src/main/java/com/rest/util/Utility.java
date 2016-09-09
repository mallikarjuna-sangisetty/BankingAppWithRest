package com.rest.util;

import java.util.regex.Pattern;

public class Utility {

	public static boolean validateNumber(String id){

		if( id != null && !id.isEmpty()){
			Pattern pattern = Pattern.compile(".*[^0-9].*");
			if ( pattern.matcher(id).matches() || id.length() != 9)
				return false;
			else
				return true;
		}else
			return false;
	}
}
