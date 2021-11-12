package com.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import com.constants.FrameworkConstant;

/**
 * Represents the property file reader.
 * @author Nisha Vekariya
 * @version 1.0
 */
public class PropertyFileHelper {

	/**
	 * Get the property value based on property name
	 * @param propertyname -> name of property
	 * @return propertyValue -> value of property
	 */
	public static String get(String propertyname) {
		
		String propertyValue="";
		Properties property = new Properties();
		try(FileInputStream file = new FileInputStream(FrameworkConstant.propertyFilePath);) {
			property.load(file);
			propertyValue = property.getProperty(propertyname);
			checkPropertyValueNull(propertyname, propertyValue);
		}
		catch(Exception e) {
			throw new ExceptionHelper("Exception while reading data for Property name " + propertyname + 
					" . Please check configuration property file.");
		}
		return propertyValue;
	}
	
	/**
	 * Verify the null value for property value, else throw the exception.
	 * @param propertyname -> name of property
	 * @return propertyValue -> value of property
	 */
	private static void checkPropertyValueNull(String propertyname, String propertyValue){
		if(Objects.isNull(propertyValue)){
			throw new ExceptionHelper("Property name " + propertyname + 
					" is not found. Please check configuration property file TestRunDetails.properties");
		}
	}
	
	/**
	 * Set the property value based on property name
	 * @param propertyname -> name of property
	 * @return propertyValue -> value of property
	 */
	public static void set(String propertyname, String propertyValue){
		//Set the property
		if(propertyValue != null ){
			Properties property = new Properties();
			try(FileInputStream file = new FileInputStream(FrameworkConstant.propertyFilePath)){
				property.load(file);
				property.setProperty(propertyname, propertyValue);
			}catch(Exception e) {
				throw new ExceptionHelper("Exception while getting data from the property file.");
			}
		}
	}
	
}
