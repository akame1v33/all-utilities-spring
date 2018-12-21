package com.myallutilities.utilities.constant;

public interface Pattern {


	String SPACE					= "[\\s]+";
	String MULTIPLE_SPACE 			= "\\s+";
	String REMOVE_SPECIAL_CHARACTER = "[^a-zA-Z0-9\\.]";
	String SPECIAL_CHARACTER 		= "[a-zA-Z0-9]";
	String MOBILE					= "^[0-9]{11}$";
	String ALPHA					= "^[A-Z\\s]+$";
	String ALPHANUMERIC 			= "^[A-Z0-9\\s\\.\\-]+$";
	String NUMERIC					= "\\d+";
	String MAIL 					= "^[a-zA-Z0-9\\.\\_\\%\\+\\-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
	String PHONE 					= "^\\(\\d{2,3}\\)\\d{3}-\\d{4}$";
	
	
	
	///MRCOS CUSTOM PATTERN
	//pattern
	String RCO 						= "([\\d]{6})";
	String CUSTOM_DATE_FORMAT		= "^[01]{1}[\\d]{1}\\/[0123]{1}\\d{1}\\/\\d{4}$";
	String ALPHANUMERIC_WITH_HYPEN 	= "^[A-Z0-9\\-]+$";
	
	
	String CLEAN_MONEY_FORMAT 		= "[^a-zA-Z0-9\\.]";
}
