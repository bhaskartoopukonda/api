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

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class Floatinginterest extends AbstractRestAssuredResponse{



	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;


	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 

	@Feature("floatingInterest")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: floating interest")
	@Step("verifies floatinginterest module")
	@Severity(SeverityLevel.BLOCKER)
	//@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void baseInterestCode() throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
		{
     Response getBAseratecode=callGETMethod(token, data.getBaseCodeURI());
    softassert.assertEquals(getBAseratecode.statusCode(), STATUS_CODE_200,"this is to verfiy status code of base Interest rate API");
		System.out.println("getBAseratecode"+getBAseratecode.asString());
		
}

	}
	@Feature("floatingInterest")
	@Stories(value = { @Story(value = "Verify the functionality of creation of term loan with floating interest")})
	@Description("This is a test case which verifies the status code: floating interest")
	@Step("verifies floatinginterest module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
    public void floatingInterestRate(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount)throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
		{

			Response termLoan = callPOSTMethodWithQuery(token,payloads.floating(loanType_id, borrower_id, name, loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, revisedInterestRate, revisedInterestRateEffectiveDate, interestRateType, interestRateCode, rateAdjustment, totalInterest, amortizationType, fixedPrincipal, loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);

			System.out.println("termLoan"+termLoan.asString());
			//softassert.assertEquals(termLoan.statusCode(),Integer.valueOf(StatusCodeForPreview).intValue());
			softassert.assertEquals(termLoan.statusCode(),STATUS_CODE_200);
			
			String responseOfPreview=termLoan.jsonPath().getList("termLoan.id").get(0).toString();
			System.out.println("responseOfPreview:"+responseOfPreview);
			
			String loanNumber=termLoan.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
		
			Response responseOfCommit=callPOSTMethodWithQuery(token, payloads.floatingcommit(responseOfPreview,loanType_id,borrower_id,name,loanNumber,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,revisedInterestRate,revisedInterestRateEffectiveDate,interestRateType,interestRateCode,rateAdjustment,totalInterest,amortizationType,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
		    System.out.println("responseOfCommit"+responseOfCommit.getBody().asString());
		    softassert.assertEquals(responseOfCommit.statusCode(),STATUS_CODE_201);
		
		    Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());


			softassert.assertAll();}}

			@Feature("floatingInterest")
			@Stories(value = { @Story(value = "Verify the functionality of creation of term loan with floating interest wherein rateAdjustment will be negative")})
			@Description("This is a test case which verifies the creation of term with floating interest wherein Rate Adjustment will be negative")
			@Step("verifies floatinginterest module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void FloatingNEgative(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount)throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			{

				try {
					Response termLoan = callPOSTMethodWithQuery(token,payloads.floating(loanType_id, borrower_id, name, loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, revisedInterestRate, revisedInterestRateEffectiveDate, interestRateType, interestRateCode, rateAdjustment, totalInterest, amortizationType, fixedPrincipal, loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);

					System.out.println("termLoan"+termLoan.asString());
					//softassert.assertEquals(termLoan.statusCode(),Integer.valueOf(StatusCodeForPreview).intValue());
					softassert.assertEquals(termLoan.statusCode(),STATUS_CODE_400);
					
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				softassert.assertAll();
                 }
			}
			@Feature("floatingInterest")
			@Stories(value = { @Story(value = "Verify the functionality of creation of term loan with floating interest and verifying the preview")})
			@Description("This is a test case which verifies the status code: floating interest")
			@Step("verifies floatinginterest module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void floating(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount)throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
		{
		try {
			
			Response termLoan = callPOSTMethodWithQuery(token,payloads.floating(loanType_id, borrower_id, name, loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, revisedInterestRate, revisedInterestRateEffectiveDate, interestRateType, interestRateCode, rateAdjustment, totalInterest, amortizationType, fixedPrincipal, loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);

			System.out.println("termLoan"+termLoan.asString());
			//softassert.assertEquals(termLoan.statusCode(),Integer.valueOf(StatusCodeForPreview).intValue());
			softassert.assertEquals(termLoan.statusCode(),STATUS_CODE_200);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		softassert.assertAll();
        }
		}
	





		
			
		
			
	@Feature("outstanding-balances of all borrowers by using API")
	@Stories(value = { @Story(value = " Verify the function of getting outstanding-balances of all borrowers using API")})
	@Description("Verify and validate the outstanding-balances of all borrowers by using API")
	@Step("verifies Outstanding balance ")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups="Regression")
	public void outstandingalance() throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
		{
		try {
			Response outstandingbalance=callGETMethod(token, url3+"/api/v1/reports/term-loans/borrowers/outstanding-balances");
			System.out.println(outstandingbalance.getStatusCode());
			System.out.println("outstandingbalance"+outstandingbalance.asString());
			softassert.assertEquals(outstandingbalance.statusCode(), STATUS_CODE_200,"this is to verfiy status code of outstanding balance API API");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		softassert.assertAll();
		}
			
	}

//CYNCS_7104

@Feature("Interest rate code Validation")
@Stories(value = { @Story(value = "Verify and validate the Interest code Id with positive rate date")})
@Description("Verify and validate the Interest code Id with positive rate date")
@Step("verifies Interest rate codee")
@Severity(SeverityLevel.BLOCKER)
@Test(groups="Regression")
public void interestRatecodeAPI() throws FileNotFoundException, IOException, ParseException {
	
	SoftAssert softassert = new SoftAssert();
	{
	Response outstandingbalance=callGETMethod(token, url+"/api/internal/v2/get_interest_rate?rate_date=rate_date=05/06/2020&interest_rate_code_id=294");
	System.out.println("outstandingbalance"+outstandingbalance.asString());
	System.out.println("Hi test"+outstandingbalance.getStatusCode());
	softassert.assertEquals(outstandingbalance.statusCode(), STATUS_CODE_200,"this is to verfiy status code of Interest rate code Id API");
	}}


@Feature("Interest rate code Validation")
@Stories(value = { @Story(value = "Verify and validate the Interest code Id with negative rate date")})
@Description("Verify and validate the Interest code Id with negative rate date")
@Step("verifies Interest rate codee")
@Severity(SeverityLevel.BLOCKER)
@Test(groups="Regression")
public void interestRatecodeAPI01() throws FileNotFoundException, IOException, ParseException {
	
	SoftAssert softassert = new SoftAssert();
	{
	Response outstandingbalance=callGETMethod(token, url+"/api/internal/v2/get_interest_rate?rate_date=05/06/2020&interest_rate_code_id=294");
	System.out.println("outstandingbalance"+outstandingbalance.asString());
	softassert.assertEquals(outstandingbalance.statusCode(), STATUS_CODE_400,"this is to verfiy status code of Interest rate code  API");
	}}



@Feature("Interest rate code Validation")
@Stories(value = { @Story(value = "Verify and validate the Interest code Id with negative rate date")})
@Description("Verify and validate the Interest code Id with negative rate date")
@Step("verifies Interest rate codee")
@Severity(SeverityLevel.BLOCKER)
@Test(groups="Regression")
public void interestRatecodeAPI02() throws FileNotFoundException, IOException, ParseException {
	
	SoftAssert softassert = new SoftAssert();
	{
	Response outstandingbalance=callGETMethod(token, url+"/api/internal/v2/get_interest_rate?rate_date=07/06/2022&interest_rate_code_id=294");
	System.out.println("outstandingbalance"+outstandingbalance.asString());
	softassert.assertEquals(outstandingbalance.statusCode(), STATUS_CODE_400,"this is to verfiy status code of Interest rate code API");
	}}


@Feature("Interest rate code Validation")
@Stories(value = { @Story(value = "Verify and validate the Interest code Id with negative rate date")})
@Description("Verify and validate the Interest code Id with negative rate date")
@Step("verifies Interest rate codee")
@Severity(SeverityLevel.BLOCKER)
@Test(groups="Regression")
public void interestRatecodeAPI03() throws FileNotFoundException, IOException, ParseException {
	
	SoftAssert softassert = new SoftAssert();
	{
	Response outstandingbalance=callGETMethod(token, url+"/api/internal/v2/get_interest_rate?rate_date=03/06/2020&interest_rate_code_id=294");
	System.out.println("outstandingbalance"+outstandingbalance.asString());
	softassert.assertEquals(outstandingbalance.statusCode(), STATUS_CODE_400,"this is to verfiy status code of Interest rate code API");
	}}


@Feature("Interest rate code Validation")
@Stories(value = { @Story(value = "Verify and validate the Interest code Id with negative rate date")})
@Description("Verify and validate the Interest code Id with negative rate date")
@Step("verifies Interest rate codee")
@Severity(SeverityLevel.BLOCKER)
@Test(groups="Regression")
public void interestRatecodeAPI04() throws FileNotFoundException, IOException, ParseException {
	
	SoftAssert softassert = new SoftAssert();
	{
	Response outstandingbalance=callGETMethod(token, url+"/api/internal/v2/get_interest_rate?rate_date=05/06/2020&interest_rate_code_id=294");
	System.out.println("outstandingbalance"+outstandingbalance.asString());
	softassert.assertEquals(outstandingbalance.statusCode(), STATUS_CODE_400,"this is to verfiy status code of Interest rate code Id API");
	}}
}