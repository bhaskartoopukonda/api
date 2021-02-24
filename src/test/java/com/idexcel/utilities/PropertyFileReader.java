package com.idexcel.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Shivaraj.Budeppa
 *
 */
public class PropertyFileReader {

			public String getDataprovider(String filepath, String key) {
				try {
					FileReader file = new FileReader(filepath);
					Properties prop = new Properties();
					prop.load(file);
					String property = prop.getProperty(key);
					return property;
				}catch (Exception e) {
					e.printStackTrace();	
					return null;
				} 
			}
			
	/*
	 * public String setData(String documentId,String fileName ,String key,String
	 * filepath){
	 * 
	 * try { FileReader file = new FileReader(filepath); Properties prop = new
	 * Properties(); prop.load(file); String property = prop.getProperty(key);
	 * 
	 * prop.setProperty("documentId", documentId); prop.setProperty("fileName",
	 * fileName); return property; }catch (Exception e) { e.printStackTrace();
	 * return null; }
	 * 
	 * 
	 * }
	 * 
	 */
		
}
