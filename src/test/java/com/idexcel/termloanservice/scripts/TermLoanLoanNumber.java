package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;
import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.token.Token;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.JSONFileReader;
import com.idexcel.utilities.Payloads;
import com.idexcel.utilities.TestNGDataProvider;
import com.idexcel.utilities.Utils;
import com.idexcel.utilities.ValidationJSON;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;

public class TermLoanLoanNumber  extends AbstractRestAssuredResponse{
	
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;

	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader();

		 
 
	
	@Feature("TERM LOAN NUMBER WITH POSITIVE DATA")
	@Stories(value = { @Story(value = "Term laon Number with Positive data")})
	@Description("This is a test case which verifies the status code: creation of Term loan setup with Loan Number as Positive data")
	@Step("verifies Term loan number with Positive data")
	@Severity(SeverityLevel.BLOCKER)
@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void termLoanNumberWithPositiveData(String URI, String statuscode,String LoanNumber) throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
		try {
			Response responseOfPreview = callPOSTMethod(token, payloads.getPayloadforPreviewToCheckLoanNumberPositive(LoanNumber),URI);
			
			softassert.assertEquals(responseOfPreview.statusCode(), STATUS_CODE_400,"this is to verify status code of Term loan setup with Loan Number as Positive Data");
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		softassert.assertAll();
	 
}

	//Term loan Setup-Loan number Negative scenario
	
	@Feature("TERM LOAN NUMBER WITH NEGATIVE DATA")
	@Stories(value = { @Story(value = "Term Loan Number with Negative data")})
	@Description("This is a test case which verifies the status code: creation of Term loan Setup with Loan number as Negative data")
	@Step("verifies Term loan number with Negative data")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void termLoanNumberWithNegativeData(String LoanNumber,String URI, String statuscode) throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
		
		Response responseOfPreview = callPOSTMethod(token, Payloads.getPayloadforPreviewToCheckLoanNumberNegative(LoanNumber),URI);
		
		softassert.assertEquals(responseOfPreview.statusCode(), Integer.valueOf(statuscode).intValue(), "This is to verfiy status code of Term loan Setup-Loan number Negative scenario");
				
		softassert.assertAll();
	 
}
}
		
		
		
		
		
		
		

