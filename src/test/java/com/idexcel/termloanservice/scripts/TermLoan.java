
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

	public class TermLoan  extends AbstractRestAssuredResponse{
		
		
		private static final int STATUS_CODE_200 =200;
		private static final int STATUS_CODE_400 =400;
		private static final int STATUS_CODE_201 =201;
		private static final int STATUS_CODE_204 =204;
		private static final int STATUS_CODE_404 =404;

		static double dfee=0;
		static double dtotalPaymentDone=0;
		static double dadditionalDisbursement=0;
		static double dregularInterest=0;
		DataFromPropertyFile data = new DataFromPropertyFile();
		JSONFileReader json = new JSONFileReader();



		
	
//Term loan 
		
		@Feature("Verify the term type functionality of application by using Months ,Weeks and Days")
		@Stories(value = { @Story(value = "TERM LOAN SETUP")})
		@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
		@Step("Creation of Term loan with Positive details")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
		public void termSetup(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
		try
		 {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
			
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			
			
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		 }
			catch(Exception e) 
	        { 
				e.printStackTrace();
	        }
	       
			softassert.assertAll();
}
		@Feature("Verify the term type functionality of application by using Months ,Weeks and Days")
		@Stories(value = { @Story(value = "TERM LOAN SETUP")})
		@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
		@Step("Creation of Term loan with Positive details")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"sanity"})
		public void verifyOutstanding() {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
				System.out.println(getFee.getBody().asString());
				String LoanId=getFee.jsonPath().getList("id").get(0).toString();
				
				Response get_fee=callGETMethod(token,"termLoanId",LoanId,url3+"/api/v1/amortization-schedule");

				int length=get_fee.body().path("list.size()");
				//System.out.println("LoanId"+LoanId);
				 for(int i=0;i<length;i++) {
					 String fee=get_fee.jsonPath().getList("fee").get(i).toString();
					
					 Double fee1=Double.valueOf(fee);
					 dfee=dfee+fee1;
					 String totalPaymentDone=get_fee.jsonPath().getList("totalPaymentDone").get(i).toString();
					 
					 Double totalPaymentDone1=Double.valueOf(totalPaymentDone);
					 dtotalPaymentDone=dtotalPaymentDone+totalPaymentDone1;
					 String additionalDisbursement=get_fee.jsonPath().getList("additionalDisbursement").get(i).toString();
					
					 Double additionalDisbursement1=Double.valueOf(additionalDisbursement);
					 dadditionalDisbursement=dadditionalDisbursement+additionalDisbursement1;
					 String regularInterest=get_fee.jsonPath().getList("regularInterest").get(i).toString();
					 Double regularInterest1=Double.valueOf(regularInterest);
					 dregularInterest=dregularInterest+regularInterest1;
					
				 }
				 double dfee1=DecimalFormater.covertodecimal(dfee);
				 double dtotalPaymentDone1=DecimalFormater.covertodecimal(dtotalPaymentDone);
				double dadditionalDisbursement1= DecimalFormater.covertodecimal(dadditionalDisbursement);
				 double dregularInterest1=DecimalFormater.covertodecimal(dregularInterest);
				 //System.out.println("fee is"+dfee1);
				 //System.out.println("totalPaymentDone is "+dtotalPaymentDone1);
				 //System.out.println("additionalDisbursement is "+dadditionalDisbursement1);
				 //System.out.println("regularInterest is "+dregularInterest1);
				 double outstandingbalance_expected=dadditionalDisbursement1+dregularInterest1+dfee1-dtotalPaymentDone1;
				 System.out.println("outstandingbalance_expected is "+outstandingbalance_expected);
				 Response termsetup=callGETMethod(token,url3+"/api/v1/term-loans/"+LoanId);
				 //totalOutStandingBalance
				 float totalOutStandingBalance = termsetup.then().extract().path("totalOutStandingBalance");
				 System.out.println("totalOutStandingBalance is "+totalOutStandingBalance);
				 Double d1=(double) totalOutStandingBalance;
				 //System.out.println("my d1 value is "+d1);
				 double d2= DecimalFormater.covertodecimal(d1);
				 System.out.println("my d2 value "+d2);
				 softassert.assertEquals(outstandingbalance_expected, d2);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
		}
		

	}
					 
					 
					 
	