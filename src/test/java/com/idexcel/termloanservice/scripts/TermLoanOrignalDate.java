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

public class TermLoanOrignalDate  extends AbstractRestAssuredResponse{
	
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;

	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader();

		 


		//Term loan Initial Date-negative
	@Feature("TERM LOAN WITH ORIGNAL DATE AS NEGATIVE DATA")
	@Stories(value = { @Story(value = "Term loan with orignal date as Negative") })
	@Description("This is a test case which verifies the status code: Term loan with orignal date as Negative data")
	@Step("verifies Term loan Orignal date with Negative date")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void termLoanOrignalDateAsNegative(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
	
	
	
	
		try {
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			System.out.println(response.getStatusCode());
			softassert.assertEquals(response.statusCode(), STATUS_CODE_400, "This is to verfiy status code for Orignal date as Negative");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	softassert.assertAll();
	}
	
	/*
		// Term Loan for Maturity date Positive negative
	
	
	
	@Feature("TERM LOAN WITH ORIGNAL DATE AS NEGATIVE DATA")
	@Stories(value = { @Story(value = "Term loan with orignal date as Negative") })
	@Description("This is a test case which verifies the status code: Term loan with orignal date as Negative data")
	@Step("verifies Term loan Orignal date with Negative date")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void termLoanMaturityDate(String Orignaldate,String Maturitydate,String statuCode) throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
	
	
	
	
		Response responseOfCommittNegative = callPOSTMethod(token, Payloads.getCommitRequestBody(Orignaldate),data.getCommitURI());
		
		System.out.println("responseOfCommittNegative:"+responseOfCommittNegative.asString());
	
	softassert.assertEquals(responseOfCommittNegative.statusCode(), Integer.valueOf(statuCode).intValue(), "This is to verfiy status code for Orignal date as Negative");
	softassert.assertAll();
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
}
		
		
		
		
		
		
		

