



package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.JSONFileReader;
import com.idexcel.utilities.Payloads;
import com.idexcel.utilities.TestNGDataProvider;
import com.idexcel.utilities.Utils;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class TermLoanEdit  extends AbstractRestAssuredResponse{
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;

	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader();
 
	//Term loan Edit negative---Active
		
		
		@Feature("TERM LOAN EDIT WHEN LOAN STATUS IS ACTIVE ")
		@Stories(value = { @Story(value = "Term loan Edit when loan status is Active") })
		@Description("This is a test case which verifies the status code: Term loan EDIT operation when loan Status is Active")
		@Step("verifies Term loan status code when loan status is Active")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
		public void termLoanEditOperation(String LoanName,String PaidOffDate, String statuscode,String URI) throws FileNotFoundException, IOException, ParseException
			{
			 
		

			Response callGETMethod = callGETMethod(token, data.getTermloanID());
			System.out.println("Response :"+callGETMethod.asString());
			String loanID = callGETMethod.jsonPath().getList("id").get(0).toString();
			System.out.println("loanID :"+loanID);
			Response responseOfCommit = callPUTMethod(token, payloads.getPayloadforPreviewToCheckEditOperationforNegative(PaidOffDate,LoanName,loanID), URI+loanID);
			
			Utils.callResponseLogsIfValidationFails(responseOfCommit);
			Utils.callResponseLogsIfValidationFails(callGETMethod);
			verifyingStatuscodes(responseOfCommit.statusCode(), Integer.valueOf(statuscode), "this is to verfiy status code of Term loan Edit operation ");
			softassert.assertAll();
		
		} 

	
	@Feature("TERM LOAN EDIT  FOR NEW INTEREST RATE POSITIVE AND NEGATIVE SCENARIO ")
	@Stories(value = { @Story(value = "Term laon Edit when Loan Status is Inactive") })
	@Description("This is a test case which verifies the status code: Term loan EDIT operation when loan status is Inactive")
	@Step("verifies Term loan  status ci=ode when loan status is inactive")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void newInterestRateValidation( String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String	Intrest,String Originationdate,String InitialPaymentdate,String	Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate,String  PreviewURI	,String CommitURI	,String StatusCodeForPreview, String StatuscodeForCommit, String URI, String	revisedInterestRate	, String revisedInterestRateEffectiveDate,	String Status ,String LoanStatus ) throws FileNotFoundException, IOException, ParseException {
	
	SoftAssert softassert = new SoftAssert();
	try {

		Response termLoan=callPOSTMethod(token, payloads.getLoanDetails(LoanNumber, LoanName, PrincipalAmount, Term, Termtype,	Intrest, Originationdate, InitialPaymentdate,Disburnsmentdate,interestRateType,	rateAdjustment, amortizationType,MaturityDate), PreviewURI);
		System.out.println("termLoan"+termLoan.asString());
		softassert.assertEquals(termLoan.statusCode(),Integer.valueOf(StatusCodeForPreview).intValue());
		
		String responseOfPreview=termLoan.jsonPath().getList("termLoan.id").get(0).toString();
		System.out.println("responseOfPreview:"+responseOfPreview);
		
		
		//Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
		//softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
	
	    //Response responseOfCommit=callPOSTMethod(token, payloads.getCommitRequestBodyOfLoan( responseOfPreview, LoanNumber, LoanName, PrincipalAmount, Term, Termtype,	Intrest, Originationdate, InitialPaymentdate, Disburnsmentdate,	interestRateType,	rateAdjustment, amortizationType,	MaturityDate),CommitURI);
		//System.out.println("responseOfCommit"+responseOfCommit.asString());
		//softassert.assertEquals(responseOfCommit.statusCode(),Integer.valueOf(StatuscodeForCommit).intValue(),"This is the status code to verfiy Term loan creation");
	
	
		//Response callGETMethod = callGETMethod(token, data.getTermloanID());
		//System.out.println("Response :"+callGETMethod.asString());
		//String loanID = callGETMethod.jsonPath().getList("id").get(0).toString();
		//System.out.println("loanID :"+loanID);
		//Response responsecodeofPUT = callPOSTMethod(token, Payloads.payloadsForNewInterestRate( LoanNumber,LoanName , InitialPaymentdate,Originationdate,Termtype, MaturityDate, Intrest,  PrincipalAmount, loanID, revisedInterestRate, revisedInterestRateEffectiveDate,LoanStatus), URI);
		
		//Utils.callResponseLogsIfValidationFails(responsecodeofPUT);
		//Utils.callResponseLogsIfValidationFails(callGETMethod);
		//verifyingStatuscodes(responsecodeofPUT.statusCode(), Integer.valueOf(Status), "this is to verfiy status code of Term loan EDIT operation");
		softassert.assertAll();
	
	}

	 catch(NullPointerException e) 
  {
  }
	
}}

