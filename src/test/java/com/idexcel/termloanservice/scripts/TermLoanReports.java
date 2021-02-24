package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.DecimalFormater;
import com.idexcel.utilities.GetDate;
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

public class TermLoanReports extends AbstractRestAssuredResponse{
	
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	static double disb=0;
	static double regInt=0;
	static double sumchargecode=0;
	static double InterestPayment=0;
	static double PaymentDone=0;
	static double PrincipalPayment=0;
	static double FeePayment=0;

	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 
		

		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get list of all term loan for requested borrower")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void toGetlistofalltermloanforrequestedBorrower()throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				Response reports= callGETMethod(token, "clientId",data.clientId(),url3+"/api/v1/reports/term-loan");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		 
	}
		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get loan commitment summary for requested term loan")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void getcommitSummary()throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String activityDate=sdf.format(date);
				System.out.println("activityDate is "+activityDate);
				Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
				String LoanId=getFee.jsonPath().getList("id").get(0).toString();
				Response reports= callGETMethod(token, "activityDate",activityDate,"termLoanId",LoanId,url3+"/api/v1/reports/term-loan/commit-summary");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		 
	}
		
		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get loan commitment summary for requested term loan")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void getDueAson()throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String activityDate=sdf.format(date);
				System.out.println("activityDate is "+activityDate);
				Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
				String LoanId=getFee.jsonPath().getList("id").get(0).toString();
				Response reports= callGETMethod(token, "activityDate",activityDate,"termLoanId",LoanId,url3+"/api/v1/reports/term-loan/due-as-on");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		 
	}
		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get all the dues as on today")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"smoke"})
		public void duesAsofToday(String dueDaysFilterBy)throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				Response reports= callGETMethod(token, "clientId",dueDaysFilterBy,url3+"/api/v1/reports/term-loan/dues-as-of-today");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		 
	}
	
		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get loan fee summary for requested term loan")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void feeSummary()throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String activityDate=sdf.format(date);
				System.out.println("activityDate is "+activityDate);
				Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
				String LoanId=getFee.jsonPath().getList("id").get(0).toString();
				Response reports= callGETMethod(token, "activityDate",activityDate,"termLoanId",LoanId,url3+"/api/v1/reports/term-loan/fee-summary");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		}
		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get loan immediate next due details for report")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void nextduedetails()throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String activityDate=sdf.format(date);
				System.out.println("activityDate is "+activityDate);
				Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
				String LoanId=getFee.jsonPath().getList("id").get(0).toString();
				Response reports= callGETMethod(token, "activityDate",activityDate,"termLoanId",LoanId,url3+"/api/v1/reports/term-loan/next-due-details");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		}
		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get loan payment summary for requested term loan")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void paymentSummary()throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String activityDate=sdf.format(date);
				System.out.println("activityDate is "+activityDate);
				Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
				String LoanId=getFee.jsonPath().getList("id").get(0).toString();
				Response reports= callGETMethod(token, "activityDate",activityDate,"termLoanId",LoanId,url3+"/api/v1/reports/term-loan/payment-summary");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		}
		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get list of all periods for requested term loan")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void toGetlistofallperiodsforrequestedtermloan()throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String activityDate=sdf.format(date);
				System.out.println("activityDate is "+activityDate);
				Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
				System.out.println(getFee.getBody().asString());
				String LoanId=getFee.jsonPath().getList("id").get(0).toString();
				System.out.println("hi test is ....");
				System.out.println("LoanId is "+LoanId);
				Response reports= callGETMethod(token,"termLoanId",LoanId,url3+"/api/v1/reports/term-loan/periods");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		}
		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get loan all schedules")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void toGetloanallschedules()throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String activityDate=sdf.format(date);
				System.out.println("activityDate is "+activityDate);
				Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
				String LoanId=getFee.jsonPath().getList("id").get(0).toString();
				Response reports= callGETMethod(token,"termLoanId",LoanId,url3+"/api/v1/reports/term-loan/schedules");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		}
		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get list of all term loan for requested borrower")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void getOutstandingBalanceOnborrowerlevel()throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				Response reports= callGETMethod(token,url3+"/api/v1/reports/term-loans/borrowers/outstanding-balances");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		 
	}
		@Feature("TERM LOAN REPORT")
		@Stories(value = { @Story(value = "Term loan Report")})
		@Description("This is a test case which verifies To get list of all term loan for requested borrower")
		@Step("verifies Term loan Report ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(groups= {"smoke"})
		public void reportCalculation()throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			try {
				Response reports= callGETMethod(token, "clientId",data.clientId(),url3+"/api/v1/reports/term-loan");
				System.out.println(reports.getBody().asString());
				softassert.assertEquals(reports.statusCode(),STATUS_CODE_200, "This is the status code to verify Term Loan reports ");
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String activityDate=sdf.format(date);
				System.out.println("activityDate is "+activityDate);
				Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
				System.out.println(getFee.getBody().asString());
				String LoanId=getFee.jsonPath().getList("id").get(0).toString();
				String interestRate=getFee.jsonPath().getList("interestRate").get(0).toString();
				String principalAmount=getFee.jsonPath().getList("principalAmount").get(0).toString();
				System.out.println("hi test is ....");
				System.out.println("LoanId is "+LoanId);
				String originationDate=getFee.jsonPath().getList("originationDate").get(0).toString();
				String maturityDate=getFee.jsonPath().getList("maturityDate").get(0).toString();
				Response reports1= callGETMethod(token,"termLoanId",LoanId,url3+"/api/v1/reports/term-loan/periods");
				System.out.println(reports1.getBody().asString());
				String reportDate=reports1.jsonPath().getList("reportDate").get(3).toString();
				System.out.println("reportDate is "+reportDate);
				Date date1=GetDate.StringToDate(reportDate);
				System.out.println("date1 is "+date1);
				String sdate=GetDate.converTingDateIntoString(date1);
				System.out.println("sdate is "+sdate);
				Response get_time=callGETMethod(token,"termLoanId",LoanId,url3+"/api/v1/amortization-schedule");
				//String paymentDate=get_time.jsonPath().get("paymentDate[0]").toString();
				
				int length=get_time.body().path("list.size()");
				for(int i=0;i<length;i++) {
					
					String totalInterestPayment=get_time.jsonPath().getString("totalInterestPayment["+i+"]");
					Double dtotalInterestPayment = Double.valueOf(totalInterestPayment);
					InterestPayment=InterestPayment+dtotalInterestPayment;
					
					String totalPaymentDone=get_time.jsonPath().getString("totalPaymentDone["+i+"]");
					Double dtotalPaymentDone = Double.valueOf(totalPaymentDone);
					PaymentDone=PaymentDone+dtotalPaymentDone;
					
					String totalPrincipalPayment=get_time.jsonPath().getString("totalPrincipalPayment["+i+"]");
					Double dtotalPrincipalPayment = Double.valueOf(totalPrincipalPayment);
					PrincipalPayment=PrincipalPayment+dtotalPrincipalPayment;
					
					String totalFeePayment=get_time.jsonPath().getString("totalFeePayment["+i+"]");
					Double dtotalFeePayment = Double.valueOf(totalFeePayment);
					FeePayment=FeePayment+dtotalFeePayment;
				}
				
				 for(int i=0;i<length;i++) {
					 String additionalDisbursement=get_time.jsonPath().getString("additionalDisbursement["+i+"]");
					 Double dadditionalDisbursement = Double.valueOf(additionalDisbursement);
					 disb=dadditionalDisbursement+disb;
					 
					 String regularInterest=get_time.jsonPath().getString("regularInterest["+i+"]");
					 Double dregularInterest = Double.valueOf(regularInterest);
					String paymentDate= get_time.jsonPath().getString("paymentDate["+i+"]");
					
					 regInt=regInt+dregularInterest;
					 
					   String fee=get_time.jsonPath().getString("fee["+i+"]");
						System.out.println("fee is "+fee);
						Double dfee = Double.valueOf(fee);
						sumchargecode=sumchargecode+dfee;
						System.out.println("sumchargecode is "+sumchargecode);
					
					 if(paymentDate.equalsIgnoreCase(sdate)){
						 break;
					 }
					 
				 }
				 
				 System.out.println("My test info is"+disb);
				 System.out.println("My dregularInterest info is"+regInt);
				 System.out.println("sumchargecode is "+sumchargecode);
				double calc1=disb+regInt+sumchargecode;
				double calc2=InterestPayment+PaymentDone+PrincipalPayment+FeePayment;
				double Obalance=calc1-calc2;
				System.out.println("Obalance is "+Obalance);
				double Obalance1 = DecimalFormater.covertodecimal(Obalance);
				String SObalance1=String.valueOf(Obalance1);
				Response reports2= callGETMethod(token, "activityDate",reportDate,"termLoanId",LoanId,url3+"/api/v1/reports/term-loan/due-as-on");
				System.out.println(reports2.getBody().asString());
				Float outStandingBalance=reports2.then().extract().path("termLoanCommitSummary.outStandingBalance");
				Float annualRate=reports2.then().extract().path("termLoanCommitSummary.annualRate");
				String maturityDate1=reports2.then().extract().path("termLoanCommitSummary.maturityDate");
				String originationDate1=reports2.then().extract().path("termLoanCommitSummary.originationDate");
				Float principalAmount1=reports2.then().extract().path("termLoanCommitSummary.principalAmount");
				String sprincipalAmount1=String.valueOf(principalAmount1);
				String sannualRate=String.valueOf(annualRate);
				System.out.println("annualRate is "+annualRate);
				System.out.println("outStandingBalance is "+outStandingBalance);
				String SoutStandingBalance= String.valueOf(outStandingBalance);
				softassert.assertEquals(SObalance1,SoutStandingBalance);
				softassert.assertEquals(sannualRate, interestRate);
				softassert.assertEquals(maturityDate, maturityDate1);
				softassert.assertEquals(originationDate, originationDate1);
				softassert.assertEquals(principalAmount, sprincipalAmount1);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			softassert.assertAll();
		 
	}

}
