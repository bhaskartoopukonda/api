package com.idexcel.token;

import java.net.MalformedURLException;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.PayloadProd;
import com.idexcel.utilities.PayloadStaging;
import com.idexcel.utilities.PayloadUat;
import com.idexcel.utilities.Payloads;
import static io.restassured.RestAssured.given;

public class BaseTest {
	Properties systemProperties = System.getProperties();
	public Payloads payloads=new Payloads();
	public static String url;
	public static String url2;
	public static String url3;
	public static String Environment;
	public static Logger logger;
	String LOGIN_POST;
	DataFromPropertyFile data = new DataFromPropertyFile();
	public static String token;
	//Token tokenvalue = new Token();
	public String Tokenvalue2;
	
	
	
	@Parameters({"os","environment"})
	@BeforeTest(alwaysRun = true)
	public void SetEnvironment(@Optional("Windows") String os,@Optional("Staging") String environment) throws MalformedURLException {
		    System.out.println("OS name :" + os);
		    System.out.println("environment name :" + environment);

			  logger=Logger.getLogger("BaseTest");
			  PropertyConfigurator.configure("log4j.properties");
		    
			  

			switch (os.toUpperCase()) {
			
			case "WINDOWS":
				
				switch (environment.toUpperCase()) {
				case "STAGING":
					System.setProperty("environment", "STAGING");
					System.setProperty("url","https://staging.cyncsoftware.com");
					System.setProperty("url2","https://stagingtermloan.cyncsoftware.com");
					LOGIN_POST="/users/sign_in";
					break;

				case "UAT":
					System.setProperty("environment","UAT");
					System.setProperty("url","https://uattest.cyncsoftware.com");
					System.setProperty("url2","https://uattermloan.cyncsoftware.com");
					LOGIN_POST="/api/v1/users/sign_in";
					break;
					
				case "PRODUCTION":
					System.setProperty("environment","PRODUCTION");
					System.setProperty("url","https://prodtest.cyncsoftware.com");
					System.setProperty("url2","https://termloan.cyncsoftware.com");
					LOGIN_POST="/api/v1/users/sign_in";
					break;

				case "DEV":
					System.setProperty("environment","DEV");
					System.setProperty("url","https://devrorapi.cyncsoftware.com");
					System.setProperty("url2","https://devtermloan.cyncsoftware.com");
					LOGIN_POST="/api/v1/users/sign_in";
					break;

		
			}
				
				       
				          //System.setProperty("token",Token);
				
				
				/*String Tokenvalue2=tokenvalue.getAccessToken();
				System.setProperty("token",Tokenvalue2);*/
		
	}
			 url2 = System.getProperty("url");	
			 System.out.println(url2);
		
			 Tokenvalue2 = given()
						.headers("Accept","application/json","Content-Type","application/json")
						.body(data.getcredentials())
						.when().log().all()
						//.post(Configuration.url.url+APIPath.apiPath.LOGIN_POST).getCookie("cync_authorization");
						.post(url2+LOGIN_POST).getCookie("cync_authorization");
			
			 System.setProperty("token",Tokenvalue2);
}
	
	
	@BeforeMethod
	public void SetPayload() throws InterruptedException {
		
		 url = System.getProperty("url");		 
		 Environment=System.getProperty("environment");	
		 token=System.getProperty("token");
		 System.out.println(Environment);
		 url3 =System.getProperty("url2");
		 
 		if(Environment.equalsIgnoreCase("STAGING"))
 			
		 {
 			 payloads=new PayloadStaging();
 			 //LOGIN_POST2="/users/sign_in";
		}
		else if(Environment.equalsIgnoreCase("UAT")){
			
			 payloads=new PayloadUat(); 
			//LOGIN_POST2="/api/v1/users/sign_in";
		}
		else if(Environment.equalsIgnoreCase("PRODUCTION")){
			
			 payloads=new PayloadProd(); 
			 //LOGIN_POST2="/api/v1/users/sign_in";
			 
		}
 		
		else if(Environment.equalsIgnoreCase("DEV")){
			
			 payloads=new PayloadProd(); 
			 //LOGIN_POST2="/api/v1/users/sign_in";
			 
		}
  
	}
	
	
/*	
	public void SetToken() {
	RestAssured.urlEncodingEnabled=false;
	 Token = given()
			.headers("Accept","application/json","Content-Type","application/json")
			.body(data.getcredentials())
			.when().log().all()
			//.post(Configuration.url.url+APIPath.apiPath.LOGIN_POST).getCookie("cync_authorization");
			.post(url+LOGIN_POST2).getCookie("cync_authorization");
			//.post(url+LOGIN_POST).getCookie("_session_id");
	 
	      System.setProperty("token",Token );
	}*/
  
 
}
