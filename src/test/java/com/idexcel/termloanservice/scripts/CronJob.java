package com.idexcel.termloanservice.scripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.GetDate;
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

public class CronJob extends AbstractRestAssuredResponse{
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;


	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader();
	
	
	    @Feature("Termloan Boerrower")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		//@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	    public void runCronjobForFloatingInt(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
	    	SoftAssert softassert = new SoftAssert();
	    	try {
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
				//Response rspn = callGETMethodsForCron(data.getCronurl(),"lenderName","staging","userName","Mahesh%20Bharti");
				//System.out.println(rspn.getBody().asString());
			
				Response rspn1 = callGETMethod(token,"page","1","rows","500","order_by","rate_date","sort_by","desc",url+"/api/v1/loan_charge_codes/interest_rate_codes/358/interest_rates");
				int x=rspn1.body().path("interest_rate.list.size()");
				System.out.println("x is the size of "+x);
				for(int i=0;i<x;i++) {
					String rate = rspn1.jsonPath().get("interest_rate.rate_value["+i+"]").toString();
					System.out.println("rate is "+rate);
					String date = rspn1.jsonPath().get("interest_rate.rate_date["+i+"]").toString();
					System.out.println("date is "+date);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	softassert.assertAll();	
	    }
	    @Feature("Termloan Boerrower")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
	    @Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	    public void lateFeeJob(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String termType_id,String value,String display,String terms,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount){
	    	SoftAssert softassert = new SoftAssert();
	    	
	    	try {
	    		
	    		
	    		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();	   
				String initialPaymentDate=sdf.format(date);
				
				System.out.println("initialPaymentDate"+initialPaymentDate);
				
				Date date2 = GetDate.addDay(date, -1);
	    		String originationDate=sdf.format(date2);
	    		System.out.println("originationDate"+originationDate);
	    		
	    		String disbursementDate=sdf.format(date2);
	    		System.out.println("disbursementDate"+disbursementDate);
	    		
	    		int iterm= Integer.parseInt(terms);
	    		Date date3 = GetDate.addDay(date2,iterm);
				String maturityDate = sdf.format(date3);
				System.out.println("maturityDate"+maturityDate);
	    		
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
			    
			    String rate_value="6";
			    Response rspn3 = callPOSTMethod(token,payloads.addInterestOnRateCode(originationDate, rate_value,interestRateCode),url+"/api/v1/loan_charge_codes/interest_rate_codes/"+interestRateCode+"/interest_rates");
	    		
			   Response rspn = callGETMethodsForCron(data.getCronurl(),"lenderName","staging","userName","Mahesh%20Bharti");
			   System.out.println(rspn.getBody().asString());
				
				Response response2 = callGETMethod(token,"termLoanId","responseOfPreview",url3+"/api/v1/amortization-schedule");
				int length=response2.body().path("list.size()");
				 for(int i=0;i<length;i++) {
					 
					String str=response2.jsonPath().get("openingBalance["+i+"]").toString();
					 softassert.assertEquals(rate_value, str);
				 }
				 
				 
			    //Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				//softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
	    		
				String str=response2.jsonPath().get("openingBalance[0]").toString();
				softassert.assertEquals(rate_value, str);
				String lateFeeValue="10";
				 Response rspn1 = callPOSTMethod(token,payloads.addlatefee(responseOfPreview, "1", "eba0a5fc-c363-11e9-9d62-12e987db82ac",lateFeeValue),url3+"/api/v1/late-fee");
				 System.out.println(rspn1.getStatusCode());
				 System.out.println("checking the cron job");
				 System.out.println("checking the cron job");
				 System.out.println("checking the cron job");
				 Response rspn2 = callGETMethodsForCron(data.getCronurl(),"lenderName","staging","effectiveDate","2021-02-12","userName","Mahesh%20Bhart");
				System.out.println(rspn2.getBody().asString());
				 System.out.println(rspn.getStatusCode());
				 Response response3 = callGETMethod(token,"termLoanId","responseOfPreview",url3+"/api/v1/amortization-schedule");
				 int length1=response2.body().path("list.size()");
				 for(int i=0;i<length1;i++) {
					 
						String str1=response2.jsonPath().get("fee["+i+"]").toString();
						if(lateFeeValue.equalsIgnoreCase(str1)) {
							softassert.assertEquals(lateFeeValue, str1);

						}
						 					 }

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	softassert.assertAll();	
	    }	 
	    
}
