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

public class PeriodRevision extends AbstractRestAssuredResponse{


	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;


	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader();   {
		
	}
	
		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevsion(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
	        	
	        	System.out.println("Status code "+response.getStatusCode());
	        	softassert.assertEquals(response.getStatusCode(), STATUS_CODE_200);
	        	
	  			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
	  			
	  			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
	  			System.out.println("loanNumber is from body "+loanNumber);
	  							
	            Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				softassert.assertEquals(response1.getStatusCode(), STATUS_CODE_201);
			
				 Response getperiodPriview = callGETMethodWithFiveQuery(token,"clientId",data.clientId(),"updatedTerm","3", 
							"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevision());
				  Response putRevisionDetil=callPUTMethodWithFiveQuaryParameter(token,"clientId",data.clientId(),"updatedTerm","3", 
							"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevisionCommit());
				  System.out.println("putRevisionDetil"+putRevisionDetil.asString());
				 softassert.assertEquals(putRevisionDetil.statusCode(), STATUS_CODE_204, "this is to verify status code of Period revesion update");
				 Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}

		
		

		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevsionForGreaterTerm(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				String disbursementAmount2=response.jsonPath().getList("termLoan.disbursementAmount").get(0).toString();
				System.out.println("disbursementAmount2 is from body "+disbursementAmount2);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				
			
				Response getperiodPriview = callGETMethodWithFiveQuery(token,"clientId",data.clientId(),"updatedTerm","13", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevision());
				
				Response putRevisionDetil=callPUTMethodWithFiveQuaryParameter(token,"clientId",data.clientId(),"updatedTerm","13", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevisionCommit());
				System.out.println("putRevisionDetil"+putRevisionDetil.asString());
				softassert.assertEquals(putRevisionDetil.statusCode(), STATUS_CODE_204, "this is to verify status code of Period revesion update");
				
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}

		
		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevsionNegativeTerm(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				String disbursementAmount2=response.jsonPath().getList("termLoan.disbursementAmount").get(0).toString();
				System.out.println("disbursementAmount2 is from body "+disbursementAmount2);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				
				
				Response getperiodPriview = callGETMethodWithFiveQuery(token,"clientId",data.clientId(),"updatedTerm","1000", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevision());
				
				Response putRevisionDetil=callPUTMethodWithFiveQuaryParameter(token,"clientId",data.clientId(),"updatedTerm","1000", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevisionCommit());
				System.out.println("putRevisionDetil"+putRevisionDetil.asString());
				softassert.assertEquals(putRevisionDetil.statusCode(), STATUS_CODE_404, "this is to verify status code of Period revesion update");
				
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}

		
		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevsionAsIncorrectTerm(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				String disbursementAmount2=response.jsonPath().getList("termLoan.disbursementAmount").get(0).toString();
				System.out.println("disbursementAmount2 is from body "+disbursementAmount2);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
			
				Response getperiodPriview = callGETMethodWithFiveQuery(token,"clientId",data.clientId(),"updatedTerm","13", 
						"fromPeriod","0","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevision());
				
				Response putRevisionDetil=callPUTMethodWithFiveQuaryParameter(token,"clientId",data.clientId(),"updatedTerm","13", 
						"fromPeriod","0","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevisionCommit());
				
				System.out.println("putRevisionDetil"+putRevisionDetil.asString());
				softassert.assertEquals(putRevisionDetil.statusCode(), STATUS_CODE_404, "this is to verify status code of Period revesion update");
				 Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}

	
		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevsionAsTermAsSpecial(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				String disbursementAmount2=response.jsonPath().getList("termLoan.disbursementAmount").get(0).toString();
				System.out.println("disbursementAmount2 is from body "+disbursementAmount2);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
			
				Response getperiodPriview = callGETMethodWithFiveQuery(token,"clientId",data.clientId(),"updatedTerm","@#", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevision());
				
				Response putRevisionDetil=callPUTMethodWithFiveQuaryParameter(token,"clientId",data.clientId(),"updatedTerm","@#", 
						"fromPeriod","0","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevisionCommit());		
				
				
				System.out.println("putRevisionDetil"+putRevisionDetil.asString());
				softassert.assertEquals(putRevisionDetil.statusCode(), STATUS_CODE_400, "this is to verify status code of Period revesion update");
				
				 Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}

		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevsionAsTermAsalpha(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				String disbursementAmount2=response.jsonPath().getList("termLoan.disbursementAmount").get(0).toString();
				System.out.println("disbursementAmount2 is from body "+disbursementAmount2);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				
				Response getperiodPriview = callGETMethodWithFiveQuery(token,"clientId",data.clientId(),"updatedTerm","ABC", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevision());
				
				Response putRevisionDetil=callPUTMethodWithFiveQuaryParameter(token,"clientId",data.clientId(),"updatedTerm","ABC", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevisionCommit());
				
				
				System.out.println("putRevisionDetil"+putRevisionDetil.asString());
				softassert.assertEquals(putRevisionDetil.statusCode(), STATUS_CODE_400, "this is to verify status code of Period revesion update");
				
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}
		

		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevsionAsTermAsdecimal(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				String disbursementAmount2=response.jsonPath().getList("termLoan.disbursementAmount").get(0).toString();
				System.out.println("disbursementAmount2 is from body "+disbursementAmount2);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				
				Response getperiodPriview = callGETMethodWithFiveQuery(token,"clientId",data.clientId(),"updatedTerm","9.5", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevision());
				
				Response putRevisionDetil=callPUTMethodWithFiveQuaryParameter(token,"clientId",data.clientId(),"updatedTerm","9.5", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevisionCommit());
				
				System.out.println("putRevisionDetil"+putRevisionDetil.asString());
				softassert.assertEquals(putRevisionDetil.statusCode(), STATUS_CODE_400, "this is to verify status code of Period revesion update");
				
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}

		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevsionAsTermAsnegativev(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				String disbursementAmount2=response.jsonPath().getList("termLoan.disbursementAmount").get(0).toString();
				System.out.println("disbursementAmount2 is from body "+disbursementAmount2);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				
				
				Response getperiodPriview = callGETMethodWithFiveQuery(token,"clientId",data.clientId(),"updatedTerm","-13", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevision());
				
				Response putRevisionDetil=callPUTMethodWithFiveQuaryParameter(token,"clientId",data.clientId(),"updatedTerm","-13", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevisionCommit());
			
				System.out.println("putRevisionDetil"+putRevisionDetil.asString());
				softassert.assertEquals(putRevisionDetil.statusCode(), STATUS_CODE_400, "this is to verify status code of Period revesion update");
				
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}


		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevsionAsTermAsspace(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				String disbursementAmount2=response.jsonPath().getList("termLoan.disbursementAmount").get(0).toString();
				System.out.println("disbursementAmount2 is from body "+disbursementAmount2);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				
			
				Response getperiodPriview = callGETMethodWithFiveQuery(token,"clientId",data.clientId(),"updatedTerm"," ", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevision());
				
				Response putRevisionDetil=callPUTMethodWithFiveQuaryParameter(token,"clientId",data.clientId(),"updatedTerm"," ", 
						"fromPeriod","1","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevisionCommit());
				
				System.out.println("putRevisionDetil"+putRevisionDetil.asString());
				softassert.assertEquals(putRevisionDetil.statusCode(), STATUS_CODE_400, "this is to verify status code of Period revesion update");
				
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}


		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevsionAsTermAsZero(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				String disbursementAmount2=response.jsonPath().getList("termLoan.disbursementAmount").get(0).toString();
				System.out.println("disbursementAmount2 is from body "+disbursementAmount2);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				Response getperiodPriview = callGETMethodWithFiveQuery(token,"clientId",data.clientId(),"updatedTerm","0", 
						"fromPeriod","0","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevision());
				
				Response putRevisionDetil=callPUTMethodWithFiveQuaryParameter(token,"clientId",data.clientId(),"updatedTerm","0", 
						"fromPeriod","0","retainPaymentDue","true","termLoanId",responseOfPreview,data.periodRevisionCommit());
				
				
				System.out.println("putRevisionDetil"+putRevisionDetil.asString());
				softassert.assertEquals(putRevisionDetil.statusCode(), STATUS_CODE_400, "this is to verify status code of Period revesion update");
				
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
			
		}
		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("Verify that system should not allow to reduce the period lesser than the period “Charge/Fees” are applied")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void updateTheTerm(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount){
			SoftAssert softassert = new SoftAssert();
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				
				String period=response.jsonPath().getString("period");
				System.out.println(period);
				String[] period1= period.split(",");
				System.out.println("my test period is "+period1.length);
				int actual_period_count =period1.length;
				System.out.println("actual_period_count  "+actual_period_count);
				System.out.println("responseOfPreview:"+responseOfPreview);
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				Response getResponse = callGETMethodWithQuery(token, data.getAmortizationApis() ,responseOfPreview);
				System.out.println(getResponse.body().asString());
				
				
				Response periodRevision = callGETMethodWithFiveQuery(token, "clientId", borrower_id,"updatedTerm","9","fromPeriod", "3",
						"retainPaymentDue","true","termLoanId",responseOfPreview,
						data.periodRevision());
				
				System.out.println("Hi test  "+periodRevision.getStatusCode());
				
				Response periodRevision1 = callPUTMethodWithFiveQuaryParameter(token, "clientId", borrower_id,"updatedTerm","9","fromPeriod", "3",
						"retainPaymentDue","true","termLoanId",responseOfPreview,
						data.periodRevisionCommit());
				
				softassert.assertEquals(periodRevision1.getStatusCode(), STATUS_CODE_204);
				System.out.println("Hi after this we have to check");
				
				Response updateTerm = callGETMethod(token, url3+"/api/v1/term-loans/"+responseOfPreview);
				System.out.println("hi test "+updateTerm.getBody().asString());
				
				String period2=updateTerm.jsonPath().getString("terms");
				System.out.println("updated period "+period2);
				int noOfperiods=Integer.valueOf(period2).intValue();
				softassert.assertEquals(noOfperiods,9);
				
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}
		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("Verify the validation message when the user try to reduce the per period lesser than the period “Charge/Fees” are applied.")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevisionwithChargeFee(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount){
			SoftAssert softassert = new SoftAssert();
			try {
				
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String period=response.jsonPath().getString("period");
				System.out.println(period);
				String[] period1= period.split(",");
				System.out.println("my test period is "+period1.length);
				int actual_period_count =period1.length;
				System.out.println("actual_period_count  "+actual_period_count);
				
				System.out.println("responseOfPreview:"+responseOfPreview);
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				Response responseOfCommit = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);

				System.out.println(responseOfCommit.body().asString());
				Response getResponse = callGETMethodWithQuery(token, data.getAmortizationApis() ,responseOfPreview);
				System.out.println(getResponse.body().asString());
				
				Response otherfee = callPOSTMethod(token,payloads.getPayloadforManualFeePostWithArgument(loanNumber,loanName,principalAmount,interestRate,originationDate,disbursementDate,maturityDate,initialPaymentDate,responseOfPreview),url3+"/api/v1/charges-template/term-loan/"+responseOfPreview);
				System.out.println(otherfee.getBody().asString());
				System.out.println(otherfee.getStatusCode());
				Response addfee = callPOSTMethod(token,payloads.getPayloadforAddManualFeePostWithArgument(loanNumber, loanName, principalAmount, interestRate, originationDate, disbursementDate, maturityDate, initialPaymentDate, responseOfPreview),url3+"/api/v1/term-loan-charges/add-fee/"+responseOfPreview);
				
				
				System.out.println(addfee.getStatusCode());
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}
		@Feature("Period Revesion")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("Verify and validate the Revision Term To Term should be greater than or equal to Term Period [Period Number]")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void periodRevisionGreaterThanTerm(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount){
			SoftAssert softassert = new SoftAssert();
			try {
				
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				String period=response.jsonPath().getString("period");
				System.out.println(period);
				String[] period1= period.split(",");
				System.out.println("my test period is "+period1.length);
				int actual_period_count =period1.length;
				System.out.println("actual_period_count  "+actual_period_count);
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				Response responseOfCommit = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);

				System.out.println(responseOfCommit.body().asString());
				
				Response getResponse = callGETMethodWithQuery(token, data.getAmortizationApis() ,responseOfPreview);
				System.out.println(getResponse.body().asString());
				System.out.println("Hi after this we have to check");
				Response periodRevision = callGETMethodWithFiveQuery(token, "clientId", borrower_id,"updatedTerm","9","fromPeriod", "3",
						"retainPaymentDue","true","termLoanId",responseOfPreview,
						data.periodRevision());
				
				System.out.println("Hi test  "+periodRevision.getStatusCode());
				
				Response periodRevision1 = callPUTMethodWithFiveQuaryParameter(token, "clientId",borrower_id,"updatedTerm","9","fromPeriod", "3",
						"retainPaymentDue","true","termLoanId",responseOfPreview,
						data.periodRevisionCommit());
				
				softassert.assertEquals(periodRevision1.getStatusCode(), STATUS_CODE_204);
				System.out.println("Hi after this we have to check");
				
				Response updateTerm = callGETMethod(token, url3+"/api/v1/term-loans/"+responseOfPreview);
				System.out.println("hi test "+updateTerm.getBody().asString());
				
				String period2=updateTerm.jsonPath().getString("terms");
				System.out.println("updated period "+period2);
				int noOfperiods=Integer.valueOf(period2).intValue();
				softassert.assertEquals(noOfperiods,9);
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

				
							} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}}







