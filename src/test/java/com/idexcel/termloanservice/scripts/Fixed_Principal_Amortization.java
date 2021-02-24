package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.DecimalFormater;
import com.idexcel.utilities.JSONFileReader;
import com.idexcel.utilities.TestNGDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.response.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Fixed_Principal_Amortization extends AbstractRestAssuredResponse{
	
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;


	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 
	
	
	@Feature("Verify to update regular payment for a amortization period")
	@Stories(value = { @Story(value = "Amortization")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
	public void termloanwithFixedAmortization(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
		
		
		SoftAssert softassert = new SoftAssert();

		try {
			
			int inum1 = Integer.valueOf(principalAmount);
	    	int inum2 = Integer.valueOf(terms);
	    	float inum3= inum1/inum2;
	    	BigDecimal bd = new BigDecimal(inum3).setScale(2, RoundingMode.HALF_UP);
	    	double salary = bd.doubleValue();
	    	//String fixedPrincipal = Float.toString(inum3); 
	    	String fixedPrincipal = String.valueOf(salary);
			    
				Response termLoan=callPOSTMethodWithQuery(token, payloads.getLoanDetailsWithTermType(loanType_id, borrower_id, name, loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal, loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				System.out.println("termLoan"+termLoan.asString());
				System.out.println("status code "+termLoan.getStatusCode());
				softassert.assertEquals(termLoan.statusCode(),STATUS_CODE_200);
				
				String responseOfPreview=termLoan.jsonPath().getList("termLoan.id").get(0).toString();
				System.out.println("responseOfPreview:"+responseOfPreview);
				
				String expected_fixedPrincipal= termLoan.jsonPath().getList("termLoan.fixedPrincipal").get(0).toString();
				System.out.println("expected_fixedPrincipal  "+expected_fixedPrincipal);
				
				softassert.assertEquals(fixedPrincipal, expected_fixedPrincipal);
				
				String loanNumber=termLoan.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				Response responseOfCommit=callPOSTMethodWithQuery(token,payloads.getLoanCommitsWithTermType(responseOfPreview, loanType_id, borrower_id, name, loanNumber, loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println("responseOfCommit"+responseOfCommit.asString());
				System.out.println("responseOfCommit code "+responseOfCommit.getStatusCode());
				softassert.assertEquals(responseOfCommit.statusCode(),STATUS_CODE_201);
			
			
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		 softassert.assertAll();	
		
			}
	@Feature("Verify to update regular payment for a amortization period")
	@Stories(value = { @Story(value = "Amortization")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
	public void termloanFixedAmortization(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest ,String amortizationType,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
		
		 SoftAssert softassert = new SoftAssert();
		
		   try {
			   
			  
			    
				Response termLoan=callPOSTMethodWithQuery(token, payloads.termloanFloatingPreview(loanType_id, borrower_id, name, loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, divisor, interestRateType, interestRateCode, rateAdjustment, totalInterest,amortizationType, loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				System.out.println("termLoan"+termLoan.asString());
				System.out.println("status code "+termLoan.getStatusCode());
				softassert.assertEquals(termLoan.statusCode(),STATUS_CODE_200);
				
				String responseOfPreview=termLoan.jsonPath().getList("termLoan.id").get(0).toString();
				System.out.println("responseOfPreview:"+responseOfPreview);
				
				String expected_fixedPrincipal= termLoan.jsonPath().getList("termLoan.fixedPrincipal").get(0).toString();
				System.out.println("expected_fixedPrincipal  "+expected_fixedPrincipal);
				
				String loanNumber=termLoan.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				Response responseOfCommit=callPOSTMethodWithQuery(token, payloads.getFloatingFixedCommit(responseOfPreview, loanType_id, borrower_id, name, loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, divisor, interestRateType, interestRateCode, rateAdjustment, totalInterest, amortizationType, loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);

				System.out.println("responseOfCommit"+responseOfCommit.getStatusCode());
			    softassert.assertEquals(responseOfCommit.getStatusCode(),STATUS_CODE_201);
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		   softassert.assertAll();	
	}
	@Feature("Verify to update regular payment for a amortization period")
	@Stories(value = { @Story(value = "Amortization")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
	public void termloanPreviewCalc(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
	    
		try {
			
			int inumf1 = Integer.valueOf(principalAmount);
	    	int inumf2 = Integer.valueOf(terms);
	    	float inumf= inumf1/inumf2;
	    	BigDecimal bd = new BigDecimal(inumf).setScale(2, RoundingMode.HALF_UP);
	    	double salary = bd.doubleValue();
	    	//String fixedPrincipal = Float.toString(inum3); 
	    	String fixedPrincipal = String.valueOf(salary);
			    
			Response termLoan=callPOSTMethodWithQuery(token, payloads.getLoanDetailsWithTermType(loanType_id, borrower_id, name, loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType,fixedPrincipal, loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			//System.out.println("termLoan"+termLoan.asString());
			//System.out.println("status code "+termLoan.getStatusCode());
			softassert.assertEquals(termLoan.statusCode(),STATUS_CODE_200);
			Double inum1 = Double.valueOf(disbursementAmount);
			Double inum2 = Double.valueOf(interestRate);
			Double inum3 = Double.valueOf(divisor);
			Double inum4= inum1*(inum2/inum3)/100;
			System.out.println("inum4 is interest"+inum4);
			Double interest1=DecimalFormater.covertodecimal(inum4);
			String string_interest=String.valueOf(interest1);
			String regularInterest=termLoan.jsonPath().getList("regularInterest").get(0).toString();
			softassert.assertEquals(string_interest, regularInterest);
	    	//BigDecimal bd = new BigDecimal(inum3).setScale(2, RoundingMode.HALF_UP);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();	

	}

}
