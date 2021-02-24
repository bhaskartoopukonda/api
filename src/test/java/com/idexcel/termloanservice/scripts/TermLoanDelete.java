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

public class TermLoanDelete  extends AbstractRestAssuredResponse{
	
	

	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;

	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader();



	

//Term loan 
	
	@Feature("TERM LOAN SETUP")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	//@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void termLoanDeleteCRUDOperation(String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String	Intrest,String Originationdate,String InitialPaymentdate,String	Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate,String PreviewURI,String CommitURI,String StatusCodeForPreview,String StatuscodeForCommit ) throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		{
	try
	 {
		
		
		
		Response termLoan=callPOSTMethod(token, payloads.getLoanDetails( LoanNumber, LoanName, PrincipalAmount, Term, Termtype,	Intrest, Originationdate, InitialPaymentdate,Disburnsmentdate,interestRateType,	rateAdjustment, amortizationType,MaturityDate), PreviewURI);
		System.out.println("termLoan"+termLoan.asString());
		softassert.assertEquals(termLoan.statusCode(),Integer.valueOf(StatusCodeForPreview).intValue());
		
		String responseOfPreview=termLoan.jsonPath().getList("termLoan.id").get(0).toString();
		System.out.println("responseOfPreview:"+responseOfPreview);
		
		
		
	
		Response responseOfCommit=callPOSTMethod(token, payloads.getCommitRequestBodyOfLoan( responseOfPreview, LoanNumber, LoanName, PrincipalAmount, Term, Termtype,	Intrest, Originationdate, InitialPaymentdate, Disburnsmentdate,	interestRateType,	rateAdjustment, amortizationType,	MaturityDate),CommitURI);
		System.out.println("responseOfCommit"+responseOfCommit.asString());
		softassert.assertEquals(responseOfCommit.statusCode(),Integer.valueOf(StatuscodeForCommit).intValue(),"This is the status code to verfiy Term loan creation");		
					
					Response callGETMethod = callGETMethod(token, data.getTermloanID());
				System.out.println("Response :"+callGETMethod.asString());
				String loanID = callGETMethod.jsonPath().getList("id").get(0).toString();
				System.out.println("loanID :"+loanID);

				softassert.assertEquals(callGETMethod.statusCode(), STATUS_CODE_200);
/*
				Response responsetoDelete=callDELETEMethod(token, Utils.createJsonArray(loanID), data.gettermloansApi());
				System.out.println("responsetoDelete:"+responsetoDelete.statusCode());
				softassert.assertEquals(responsetoDelete.statusCode(), STATUS_CODE_400,"This is to verfiy status code when term loan is deleted");
		
				
				Response termLoanResponse = callGETMethod(token,data.gettermloansApi()+loanID);
					
				System.out.println("deletedGet "+termLoanResponse.statusCode());
				softassert.assertEquals(termLoanResponse.statusCode(),STATUS_CODE_200,"This is to verfiy the status code of deleted Term loan");*/
	 }
	catch(NullPointerException e) 
    { 
    }
				softassert.assertAll();
	}
		
		
	}
	}
		
		
		
		

