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
import com.idexcel.utilities.DecimalFormater;
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

public class TermLoanAllGet  extends AbstractRestAssuredResponse{
	
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;

	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader();

		 

	//TermLoan set-All get method
		
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies the status code of all get methods in termloan API")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void tolisttermloantypes(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,url3+"/api/v1/term-loans/loan-types");
				System.out.println(respn.getBody().asString());
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies the status code of all get methods in termloan API")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void toListtermloancurrencies(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,url3+"/api/v1/term-loans/currencies");
				System.out.println(respn.getBody().asString());
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies the status code of all get methods in termloan API")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void toListTermTypes(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,url3+"/api/v1/term-loans/term-types");
				System.out.println(respn.getBody().asString());
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies the status code of all get methods in termloan API")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void toGetActiveandInactive(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,url3+"/api/v1/term-loans/status-lov");
				System.out.println(respn.getBody().asString());
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies the status code of all get methods in termloan API")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void listAlltheActiveTermOfAborrower(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,"clientId","11622","statusList","active",url3+"/api/v1/term-loans");
				System.out.println(respn.getBody().asString());
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies the status code of all get methods in termloan API")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void listAlltheInactiveTermOfAborrower(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,"clientId","11622","statusList","inactive",url3+"/api/v1/term-loans");
				System.out.println(respn.getBody().asString());
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies to get requested term loan details")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void Togetrequestedtermloandetails(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,url3+"/api/v1/term-loans/"+data.termloanId());
				System.out.println(respn.getBody().asString());
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies to get requested term loan details")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void getAmortizationTypes(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,url3+"/api/v1/term-loans/amortization-types");
				System.out.println(respn.getBody().asString());
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies to To calculate fixed principal")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void toCalculateFixedPrincipal(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,"fixedPrincipal","2000","isEditedFixedPrincipal","false","principal","2000","terms","20",url3+"/api/v1/term-loans/calculate-fixed-principal");
				System.out.println(respn.getBody().asString());
				double principal=2000;
                double term=20;
                double acalc=principal/term;
                double expt_amount = DecimalFormater.covertodecimal(acalc);
				String amount=respn.getBody().asString();
				System.out.println("amount is "+amount);
				Double actual_amount=Double.valueOf(amount);
                
				softassert.assertEquals(actual_amount, expt_amount);
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies To calculate maturity date")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"smoke" })
		public void toCalculateMaturityDate(String termType){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,"initialPaymentDate","02/07/2021","originationDate","01/07/2021","termType",termType,"terms","20",url3+"/api/v1/term-loans/calculate-maturity-date");
				System.out.println(respn.getBody().asString());
				
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}

		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies To get all the comments for requested term loan")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void toGetAllComments(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,url3+"/api/v1/term-loans/comments/"+data.termloanId());
				System.out.println(respn.getBody().asString());
				
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies To get all the comments for requested term loan")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void baseinterestcodeid(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,"ids","337",url3+"/api/v1/term-loans/interest-rate-code");
				System.out.println(respn.getBody().asString());
				
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies To get all the comments for requested term loan")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void interestRatesHistory(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,"ids","337",url3+"/api/v1/term-loans/interest-rates-history/"+data.termloanId());
				System.out.println(respn.getBody().asString());
				
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies To get all the comments for requested term loan")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void interestTypes(){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,url3+"/api/v1/term-loans/interest-types");
				System.out.println(respn.getBody().asString());
				
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
		@Feature("Term Loan Get API")
		@Stories(value = { @Story(value = "Term loan All Get API") })
		@Description("This is a test case which verifies To calculate maturity date")
		@Step("verifies Term loan all GET API")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"smoke" })
		public void menuSubscription(String menuName){
			SoftAssert softassert = new SoftAssert();

			try {
				Response respn = callGETMethod(token,"menuName",menuName,url3+"/api/v1/term-loans/menu-subscription");
				System.out.println(respn.getBody().asString());
				
				
				softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			softassert.assertAll();

		}
	 
}
		
		
		
		
		
		
		

