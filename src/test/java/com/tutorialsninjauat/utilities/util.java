package com.tutorialsninjauat.utilities;

import java.util.Date;

public class util {
	
	public static String generateEmailTimeStamp()
	{
		Date date = new Date();
		String timestamp= date.toString().replace(" ","_").replace(":","_");
		return "tutorial"+timestamp+"@gmail.com";
	}

}
