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


public class TermLoanLoanName extends AbstractRestAssuredResponse {
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 


		
	
	//Term loan setup loan name for-Negative

		@Feature("TERM LOAN NAME WITH NEGATIVE DATA")
		@Stories(value = { @Story(value = "Term loan Name with Negative data") })
		@Description("This is a test case which verifies the status code: creation of Term loan setup  with Loan Name as Negative data")
		@Step("verifies Term loan Name with Negative data")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void termLoanNameWithNegativedata(String commitURI, String Loanname,String statuscode) throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			
			Response callGETMethod = callGETMethod(token, data.getTermloanID());
			System.out.println("Response :"+callGETMethod.asString());
			String loanID = callGETMethod.jsonPath().getList("id").get(0).toString();
			System.out.println("loanID :"+loanID);
			Response responseOfCommit = callPOSTMethod(token, payloads.getPayloadforPreviewToCheckLoanNameNegative(loanID,Loanname),commitURI);
			
			softassert.assertEquals(responseOfCommit.statusCode(), Integer.valueOf(statuscode).intValue(), "This is to verify Statuas code of Term loan setup loan name for Negative data");
			softassert.assertAll();
		
		}
		
	 
}
