package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GracePeriod extends AbstractRestAssuredResponse{


	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;


	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 

	@Feature("Checking a GracePeriosd Fuctionality")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("Verify the term loan creation")
	@Severity(SeverityLevel.BLOCKER)
	//always
	//@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void gracePeriod(String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String	Intrest,String Originationdate,String InitialPaymentdate,String	Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate, String PreviewURI	,String CommitURI	,String StatusCodeForPreview, String StatuscodeForCommit,String	GraceURI	) throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
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
	
				
			Response graceperiod=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/term-loans/gracedays/"+loanID+"/null");
			
			softassert.assertEquals(graceperiod.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
			
			
			}}
	@Feature("Grace period")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("Verifying the grace period update functionality")
	@Step("verify grace period update")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void gracePeriodDate(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		
		SoftAssert softassert = new SoftAssert();
		{

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
			Response graceperiod=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/term-loans/gracedays/"+responseOfPreview+"/2");
					
		    softassert.assertEquals(graceperiod.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
		    Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
			
			
			
			softassert.assertAll();
			
			
			}
	}
	
	
	
	
		@Feature("Verifying the edit functionality of first period end date")
		@Stories(value = { @Story(value = "grace period status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void gracePeriodEndDate(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
			
			SoftAssert softassert = new SoftAssert();
			{

				try {
					Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
		        	
		        	System.out.println("Status code "+response.getStatusCode());
		        	softassert.assertEquals(response.getStatusCode(), STATUS_CODE_200);
		        	
		  			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		  			
		  			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
		  			System.out.println("loanNumber is from body "+loanNumber);
					
					String periodEndDate = response.jsonPath().getString("paymentDate[0]");
					System.out.println("Date is ...."+periodEndDate);
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
					Date date1=df.parse(periodEndDate);
					System.out.println("Actual date is "+date1);
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					Calendar c = Calendar.getInstance();
					c.setTime(sdf.parse(periodEndDate));
					c.add(Calendar.DAY_OF_MONTH, 3); 
					String newDate = sdf.format(c.getTime());
					System.out.println("Date after Addition: "+newDate);
					Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
					
					System.out.println(response1.getStatusCode());
					softassert.assertEquals(response1.getStatusCode(), STATUS_CODE_201);
					
					String numberofperiod="1";
					
					Response graceperiod=callPUTMethodforNormalPUTOperationWithQuery(token,url3+"/api/v1/amortization-schedule/gracedays/"+responseOfPreview,"date",newDate,"period",numberofperiod);
					softassert.assertEquals(graceperiod.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
					
					 Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
					 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				softassert.assertAll();
								
			}
				}
			

			@Feature("Verifying the functionality of grace Period End Date can't be less than Payment Due Date")
			@Stories(value = { @Story(value = "grace period status code validation")})
			@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
			@Step("verifies grace period module")
			@Severity(SeverityLevel.BLOCKER)
	        @Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
			public void gracePeriodPaymentdueDate(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
				
				SoftAssert softassert = new SoftAssert();
				{


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
						
							String periodEndDate = response.jsonPath().getString("paymentDate[0]");
							System.out.println("Date is ...."+periodEndDate);
							DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
							Date date1=df.parse(periodEndDate);
							System.out.println("Actual date is "+date1);
							SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
							Calendar c = Calendar.getInstance();
							c.setTime(sdf.parse(periodEndDate));
							c.add(Calendar.DAY_OF_MONTH, -1); 
							String newDate = sdf.format(c.getTime());
							String numberofperiod="2";
								Response graceperiod=callPUTMethodforNormalPUTOperationWithQuery(token,url3+"/api/v1/amortization-schedule/gracedays/"+responseOfPreview,"date",newDate,"period",numberofperiod);
								softassert.assertEquals(graceperiod.statusCode(), STATUS_CODE_400, "Period End Date can't be less than Payment Due Date ");
							   	System.out.println("Status code is "+graceperiod.statusCode());
							
							
							   	Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
								 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
							

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					softassert.assertAll();
                   					
					}
			}
		
				@Feature("Verify the functionality of editing 2nd period after updating grace period")
				@Stories(value = { @Story(value = "termaloan status code validation")})
				@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
				@Step("verifies update 2nd period")
				@Severity(SeverityLevel.BLOCKER)
			    @Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
				public void periodEndDateGraceDays(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
					
					SoftAssert softassert = new SoftAssert();
					{

						
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
							
							Response graceperiod=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/term-loans/gracedays/"+responseOfPreview +"/10");
							softassert.assertEquals(graceperiod.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
							
							Response getPeriodEndDate = callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
							System.out.println(getPeriodEndDate.jsonPath().getString("periodEndDate"));
							String periodEndDate = getPeriodEndDate.jsonPath().getString("periodEndDate[1]");
							System.out.println("periodEndDate is ......."+periodEndDate);
							System.out.println("Date is ...."+periodEndDate);
							DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
							Date date1=df.parse(periodEndDate);
							System.out.println("Actual date is "+date1);
							SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
							Calendar c = Calendar.getInstance();
							c.setTime(sdf.parse(periodEndDate));
							c.add(Calendar.DAY_OF_MONTH, 3); 
							String newDate = sdf.format(c.getTime());
							System.out.println("newDate is ..."+newDate);
							
							Response graceperiodenddate=callPUTMethodforNormalPUTOperationWithQuery(token,url3+"/api/v1/amortization-schedule/gracedays/"+responseOfPreview,"date",newDate,"period","2");
							softassert.assertEquals(graceperiodenddate.statusCode(), STATUS_CODE_204 );
							
							
						     Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
							 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						
						softassert.assertAll();
						}
					
		
				}

				@Feature("Verify the functionality of setting grace period as zero after setting a grace period and updating the 2nd period")
				@Stories(value = { @Story(value = "termaloan status code validation")})
				@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
				@Step("verifies chargecode module")
				@Severity(SeverityLevel.BLOCKER)
				@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
				public void gracedaysToZero(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
					
					SoftAssert softassert = new SoftAssert();
					{
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
 					
 						Response graceperiod=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/term-loans/gracedays/"+responseOfPreview+"/10");
 						softassert.assertEquals(graceperiod.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
 						
 						Response getPeriodEndDate = callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
 						System.out.println(getPeriodEndDate.jsonPath().getString("periodEndDate"));
 						String periodEndDate = getPeriodEndDate.jsonPath().getString("periodEndDate[1]");
 						System.out.println("periodEndDate is ......."+periodEndDate);
 						System.out.println("Date is ...."+periodEndDate);
 						DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
 						Date date1=df.parse(periodEndDate);
 						System.out.println("Actual date is "+date1);
 						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
 						Calendar c = Calendar.getInstance();
 						c.setTime(sdf.parse(periodEndDate));
 						c.add(Calendar.DAY_OF_MONTH, 3); 
 						String newDate = sdf.format(c.getTime());
 						System.out.println("newDate is ..."+newDate);
 						
 						
 						Response graceperiodenddate=callPUTMethodforNormalPUTOperationWithQuery(token,url3+"/api/v1/amortization-schedule/gracedays/"+responseOfPreview,"date",newDate,"period","2");
 						softassert.assertEquals(graceperiodenddate.statusCode(), STATUS_CODE_204 );
 						
 						Response graceperiods=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/term-loans/gracedays/"+responseOfPreview+"/0");
 						softassert.assertEquals(graceperiods.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
 						
 						 Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
						 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
					} catch (Exception e) {
						e.printStackTrace();
					}	
                     softassert.assertAll();
						}
					
		
				}
					@Feature("Verify that Next Period Start Date can't be greater than Next Period End Date")
					@Stories(value = { @Story(value = "termaloan status code validation")})
					@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
					@Step("verifies chargecode module")
					@Severity(SeverityLevel.BLOCKER)
					@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
					public void gracePeriodGreaterThanPeriodEnd(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
						
						SoftAssert softassert = new SoftAssert();
						{


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
							
								
								Response graceperiod=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/term-loans/gracedays/"+responseOfPreview+"/10");
								softassert.assertEquals(graceperiod.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
								
								Response getPeriodEndDate = callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
								System.out.println(getPeriodEndDate.jsonPath().getString("periodEndDate"));
								String periodEndDate = getPeriodEndDate.jsonPath().getString("periodEndDate[1]");
								System.out.println("periodEndDate is ......."+periodEndDate);
								System.out.println("Date is ...."+periodEndDate);
								
								
								Response updategraceperiod=callPUTMethodforNormalPUTOperationWithQuery(token,url3+"/api/v1/amortization-schedule/gracedays/"+responseOfPreview,"date",periodEndDate,"period","1");
								softassert.assertEquals(updategraceperiod.statusCode(), STATUS_CODE_400, "This to verify that Next Period Start Date can't be greater than Next Period End Date");
								
								
								 Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
								 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

								
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
							softassert.assertAll();
							  
							}
						
			
	}
					@Feature("Verify the reupdate grace period after updating the 2nd period")
					@Stories(value = { @Story(value = "termaloan status code validation")})
					@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
					@Step("verifies chargecode module")
					@Severity(SeverityLevel.BLOCKER)
					@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
					public void periodEndDateGraceDayschanges(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
						
						SoftAssert softassert = new SoftAssert();
						{
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
							
							
							Response graceperiod=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/term-loans/gracedays/"+responseOfPreview+"/10");
							softassert.assertEquals(graceperiod.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
							
							Response getPeriodEndDate = callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
							System.out.println(getPeriodEndDate.jsonPath().getString("periodEndDate"));
							String periodEndDate = getPeriodEndDate.jsonPath().getString("periodEndDate[0]");
							System.out.println("periodEndDate is ......."+periodEndDate);
							System.out.println("Date is ...."+periodEndDate);
							DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
							Date date1=df.parse(periodEndDate);
							System.out.println("Actual date is "+date1);
							SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
							Calendar c = Calendar.getInstance();
							c.setTime(sdf.parse(periodEndDate));
							c.add(Calendar.DAY_OF_MONTH, 3); 
							String newDate = sdf.format(c.getTime());
							System.out.println("newDate is ..."+newDate);
							
							Response graceperiodenddate=callPUTMethodforNormalPUTOperationWithQuery(token,url3+"/api/v1/amortization-schedule/gracedays/"+responseOfPreview,"date",periodEndDate,"period","1");
							softassert.assertEquals(graceperiodenddate.statusCode(), STATUS_CODE_204 ,"This to verify the functionality of edit garce period of 2nd perid end ");
							//this is code for edit grace period on loan level after editing 2nd period
							Response graceperiods=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/term-loans/gracedays/"+responseOfPreview+"/4");
							softassert.assertEquals(graceperiods.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
							Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
							 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

						
						} catch (Exception e) {
							e.printStackTrace();
						}

                        softassert.assertAll();
							}
						
			
					}

					@Feature("Verify the set up grace period as zero after updating 2nd period")
					@Stories(value = { @Story(value = "termaloan status code validation")})
					@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
					@Step("verifies grace period module")
					@Severity(SeverityLevel.BLOCKER)
					@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
					public void gracedays(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
						
						SoftAssert softassert = new SoftAssert();
						{

							
                           Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				        	
				        	System.out.println("Status code "+response.getStatusCode());
				        	softassert.assertEquals(response.getStatusCode(), STATUS_CODE_200);
				        	
				  			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				  			
				  			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				  			System.out.println("loanNumber is from body "+loanNumber);
							
				  		     Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
								
								System.out.println(response1.getStatusCode());
								softassert.assertEquals(response1.getStatusCode(), STATUS_CODE_201);
							
							
							Response graceperiod=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/term-loans/gracedays/"+responseOfPreview+"/10");
							softassert.assertEquals(graceperiod.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
							
							
							try {
								String sdate=initialPaymentDate;
								SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
								Calendar c = Calendar.getInstance();
								c.setTime(sdf.parse(sdate));
								
							    c.add(Calendar.DAY_OF_MONTH, 44);
							    String newdate = sdf.format(c.getTime());
							    System.out.println("Hi this is my date   "+newdate);
								Response graceperiodenddate=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/amortization-schedule/gracedays/"+responseOfPreview+"?"+"date="+newdate+"&"+"period=2");
									softassert.assertEquals(graceperiodenddate.statusCode(), STATUS_CODE_204 );
								
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
							
							Response graceperiods=callPUTMethodforNormalPUTOperation(token,url3+"/api/v1/term-loans/gracedays/"+responseOfPreview+"/0");
							softassert.assertEquals(graceperiods.statusCode(), STATUS_CODE_204, "this is to verify status code of grace period update");
							
							 Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
							 softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

							
						
							}
						softassert.assertAll();
			
					}				








}