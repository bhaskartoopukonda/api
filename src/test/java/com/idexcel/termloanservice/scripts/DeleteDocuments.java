package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
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

public class DeleteDocuments extends AbstractRestAssuredResponse{
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;
	private static final int STATUS_CODE_500 =500;


	
	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 
	
	@Feature("Verify the delete document functionality of the API using document id")
	@Stories(value = { @Story(value = "document delete status code varification")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies documets delete functionality")
	@Severity(SeverityLevel.MINOR)
	@Test(groups= {"smoke"})
	public void deleteDocumets() throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		{
		try {
			Response rspn=callGETMethod(token,"termLoanId",data.termloanId(),"delFlag","true","level","client","clientId",data.clientId(),url3+"/api/v1/term-loans/document");
			String documentId = rspn.jsonPath().get("id[0]").toString();
			String fileName=rspn.jsonPath().getString("fileName[0]");
			System.out.println("my file name is   "   +fileName);
			System.out.println("my file name is   "   +fileName);
			System.out.println("my file name is   "   +fileName);
			System.out.println("documentId is "+documentId);
			
			//Response drspn=callDELETEMethodWithQuery(token,url3+"/api/v1/term-loans/document","termLoanId",data.termloanId(),"delFlag","true","level","client","clientId","11622");
			Response drspn = callDELETEMethod(token,url3+"/api/v1/term-loans/document/"+documentId);
			//System.out.println(drspn.getBody().asString());
		    int code =drspn.getStatusCode();
			
			System.out.println("my delete code is   "+code);
			softassert.assertEquals(code, STATUS_CODE_204);
			

		} catch (Exception e) {
			// TODO: handle exception
		}		
		}
		softassert.assertAll();
	}
	@Feature("List of Deleted document")
	@Stories(value = { @Story(value = "deleted document list varification")})
	@Description("This is test case which verifies the list of deleted document")
	@Step("verifies documets delete functionality")
	@Severity(SeverityLevel.MINOR)
	@Test(groups= {"smoke"})
	public void listOutDeletedDocuments() throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		Response rspn=callGETMethod(token,data.listOutDeletedDocuments());
		System.out.println(rspn.body().asString());
		int code = rspn.statusCode();
		softassert.assertEquals(code, STATUS_CODE_200);
	}
}
