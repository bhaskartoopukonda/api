package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.token.BaseTest;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.JSONFileReader;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class Documents extends AbstractRestAssuredResponse{
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;
	private static final int STATUS_CODE_500 =500;
  
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 
	//AbstractRestAssuredResponse arResponse = new AbstractRestAssuredResponse();
    
	@Feature("Documents")
	@Stories(value = { @Story(value = "documents list validation")})
	@Description("This is a test case which verifies the list of documents status code: ")
	@Step("verifies document list")
	@Severity(SeverityLevel.MINOR)
	@Test(groups= {"sanity", "smoke","regression" })
	public void DocumentList() throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		Response getFee=callGETMethod(token, data.getDocumentList());
		System.out.println(getFee.body().asString());
		
		int code=getFee.getStatusCode();
		System.out.println(code);
		softassert.assertEquals(code,STATUS_CODE_200);
		//String jsonResponse = getFee.jsonPath().getString("borrower[1].id");
		//System.out.println(jsonResponse);
		//softassert.assertEquals(jsonResponse, 11622);
		
	}
	
	

}
