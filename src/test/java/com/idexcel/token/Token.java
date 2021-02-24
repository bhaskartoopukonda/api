package com.idexcel.token;

import static io.restassured.RestAssured.given;

import com.idexcel.utilities.DataFromPropertyFile;

import io.restassured.RestAssured;
public class Token  {

	String LOGIN_POST2;
    String environment2;
    String url2;
	//TestDataReader data = new TestDataReader();
	String TokenID;
	//JSONFileReader json = new JSONFileReader();
	DataFromPropertyFile data = new DataFromPropertyFile();

/*	
	protected SoftAssert softassert = new SoftAssert();
	//@Step("click on this to check actual&expected status code for above method:")	
	public <T> void verifyingStatuscodes(T actual, T expected, T message ){
			softassert.assertEquals(actual, expected);
	}*/
	//public String getAccessToken() {
	  public String getAccessToken() {
		  
		 environment2 = System.getProperty("environment");
		 url2 = System.getProperty("url");
		 
		if(environment2.equalsIgnoreCase("STAGING")) {
			
			 LOGIN_POST2="/users/sign_in";
		}
		
		else if(environment2.equalsIgnoreCase("UAT")){
			
			LOGIN_POST2="/api/v1/users/sign_in";
		}
		
        else if(environment2.equalsIgnoreCase("PRODUCTION")){
			
			LOGIN_POST2="/api/v1/users/sign_in";
		}
       else if(environment2.equalsIgnoreCase("Dev")){
			
			LOGIN_POST2="/api/v1/users/sign_in";
		}
		RestAssured.urlEncodingEnabled=false;
		//String response = given()
		 TokenID = given()
				.headers("Accept","application/json","Content-Type","application/json")
				.body(data.getcredentials())
				.when().log().all()
				/*.post(Configuration.url.url+APIPath.apiPath.LOGIN_POST).getCookie("cync_authorization");*/
				.post(url2+LOGIN_POST2).getCookie("cync_authorization");
		
			
				
		System.out.println(TokenID);
		//System.out.println(response);
		return TokenID;
		//System.out.println(response);
		
		
	}
}

