package com.idexcel.utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileandEnv {
	
	public static Map<String , String> fileandenv = new HashMap<String,String>();
	public static Properties propMain = new Properties();
	public static Properties propPreset = new Properties();
	
	public static Map<String,String> envAndFile(){
		String environment = System.getProperty("environment");
		
		try {
			if(environment.equalsIgnoreCase("UAT")) {
			FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir")+
					"/envinput/staging.properties");
			propMain.load(fisDev);
			fileandenv.put("url", propMain.getProperty("url"));
			}else if(environment.equalsIgnoreCase("STAGING")){
				FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir")+
						"/envinput/prodtest.properties");
				propMain.load(fisDev);
				fileandenv.put("url", propMain.getProperty("url"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileandenv;
		
	}
	public static Map<String,String> getConfigReader(){
		if(fileandenv==null) {
			fileandenv = envAndFile();
		}
		return fileandenv;
	}

}
