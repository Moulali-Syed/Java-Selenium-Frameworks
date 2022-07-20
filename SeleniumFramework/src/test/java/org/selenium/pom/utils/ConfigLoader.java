package org.selenium.pom.utils;

import java.util.Properties;

import org.selenium.pom.constants.EnvType;

public class ConfigLoader {

	private final Properties properties;
	//create a private static instance variable of class , of return type class --------------(1)
	private static ConfigLoader configLoader;
	
	//only this class should be able to create its own instance, so make constructor as private------(2)
	private ConfigLoader() {
		//setting a default value as STAGE, as second parameter
		String env = System.getProperty("env",String.valueOf(EnvType.STAGE));
		switch(EnvType.valueOf(env)) {
		case STAGE:
			properties = PropertyUtils.propertyLoader("src/test/java/resources/config.properties");
			break;
		case PRODUCTION:
			properties = PropertyUtils.propertyLoader("src/test/java/resources/prod_config.properties");
			break;
		default:
			throw new IllegalStateException("Invalid env type: "+env);
		}
	}
	
	//method to provide instance of this class------------------------------------------------(3)
	public static ConfigLoader getInstance() {
		if(configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}
	
	
	//creating methods to read from the config.properties file
	public String getBaseUrl() {
		String prop = properties.getProperty("baseUrl");
		if(prop!=null) {
			return prop;
		}else {
			
			throw new RuntimeException("property baseUrl is not specified in the config.properties file");
		}
	}
	
	public String getUsername() {
		String prop = properties.getProperty("username");
		if(prop!=null) {
			return prop;
		}else {
			
			throw new RuntimeException("property username is not specified in the config.properties file");
		}
	}
	
	public String getPassword() {
		String prop = properties.getProperty("password");
		if(prop!=null) {
			return prop;
		}else {
			
			throw new RuntimeException("property password is not specified in the config.properties file");
		}
	}
}
