package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DownloadDocuments extends AbstractRestAssuredResponse{
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;
	private static final int STATUS_CODE_500 =500;


	
	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 

	@Feature("Documents")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("Verify the download document functionality of the API using document id")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
    public void downloadDocument() throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
		{
		try {
			Response rspn1=callGETMethod(token,data.uploadedFileList());
			String documentId = rspn1.jsonPath().getString("id[0]");
			String fileName=rspn1.jsonPath().getString("fileName[0]");
			Response respn = callGETMethod(token,  "documentId", documentId,"fileName", fileName, url3+"/api/v1/term-loans/document/download");
			int code = respn.getStatusCode();
			System.out.println("hi test ....."     +code);
			softassert.assertEquals(code, STATUS_CODE_200);
			softassert.assertAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		softassert.assertAll();
		}
		
		
	}
}
