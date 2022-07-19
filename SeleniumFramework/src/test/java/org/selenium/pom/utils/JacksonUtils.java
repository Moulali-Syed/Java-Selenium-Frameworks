package org.selenium.pom.utils;

import java.io.IOException;
import java.io.InputStream;

import org.selenium.pom.objects.BillingAddress;
import com.fasterxml.jackson.databind.ObjectMapper;

//this class  will return the java object
public class JacksonUtils {

//	public static BillingAddress deserializeJson(InputStream is,BillingAddress billingAddress) throws IOException {
//		
//		//create object of ObjectMapper
//		ObjectMapper objectMapper = new ObjectMapper();
//		//then use the readValue method that takes 2 arguments filePath of json file and object of the class
//		return objectMapper.readValue(is, billingAddress.getClass());
//		
//		
//	}
	
	
	public static <T> T deserializeJson(String fileName,Class<T> T) throws IOException {
	
//		InputStream is = getClass().getClassLoader().getResourceAsStream("myBillingAddress.json");

		//we are using JacksonUtils.class instead of getClass() because we are using static method
		InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);

		//create object of ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		//then use the readValue method that takes 2 arguments filePath of json file and object of the class
		return objectMapper.readValue(is, T);		
	}
}