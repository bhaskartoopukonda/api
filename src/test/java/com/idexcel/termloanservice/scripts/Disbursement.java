package com.idexcel.termloanservice.scripts;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.DecimalFormater;
import com.idexcel.utilities.GetDate;
import com.idexcel.utilities.JSONFileReader;
import com.idexcel.utilities.TermLoanCalculation;
import com.idexcel.utilities.TestNGDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class Disbursement extends AbstractRestAssuredResponse{
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;

	int statuscode;
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader();

	
	
	
	@Feature("Verify the 'Balance to be disbursed' text box should display the value = Principal Amount - (Sum of all disbursements done so far for this loan)")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursermentAmtTest(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws ParseException {
		
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
			
			Response response2 = callGETMethod(token,url3+"/api/v1/term-loans/"+responseOfPreview);
			
			System.out.println(response2.getStatusCode());
			
			String disbursementAmount1 = response2.jsonPath().getString("soFarDisbursement");
			String balanceDisbursement = response2.jsonPath().getString("balanceDisbursement");
			
			System.out.println("disbursementAmount1  "+disbursementAmount1);
			softassert.assertEquals(disbursementAmount2,disbursementAmount1);
			Double soFarDisbursement = Double.valueOf(disbursementAmount1);
			System.out.println("soFarDisbursement "+soFarDisbursement);
			Double balanceDisbursement1 = Double.valueOf(balanceDisbursement);
			System.out.println("balanceDisbursement1 "+balanceDisbursement1);
			Double principalAmount1 = Double.valueOf(principalAmount);
			System.out.println("principalAmount "+principalAmount1);
			Double balanceDisbursement2=principalAmount1-balanceDisbursement1;
			softassert.assertEquals(balanceDisbursement1, balanceDisbursement2);
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		}
		 catch (Exception e) {
			 e.printStackTrace();
		

}
		softassert.assertAll();	
	}
	@Feature("Disbursement Calculation")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursementCalc(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		    System.out.println("length "+length);
		    for(int i=0;i<length;i++) {
		    	//response.jsonPath().get("openingBalance["+i+"]").toString()
		    	String str=response.jsonPath().get("openingBalance["+i+"]").toString();
		    	Double openingBalance = Double.valueOf(str);
		    	System.out.println("openingBalance  "+openingBalance);
		    	String str1=response.jsonPath().get("regularInterest["+i+"]").toString();
		    	Double regularInterest = Double.valueOf(str1);
		    	
		    	System.out.println("regularInterest "+regularInterest);
		    	String str2=response.jsonPath().get("interestRate["+i+"]").toString();
		    	Double Interest = Double.valueOf(str2);
		    	Double double_divisor = Double.valueOf(divisor);
		    	System.out.println("Interest "+Interest);
		    	Double Interestcal=openingBalance*(Interest/double_divisor)/100;
		    	DecimalFormat df2 = new DecimalFormat("#.##");
		    	String d1= df2.format(Interestcal);
		    	Double Interests = Double.valueOf(d1);
		    	//double Interests= Math.round(Interestcal);
		    	System.out.println("Interestcal "+Interests);
		    	softassert.assertEquals(regularInterest, Interests);
		    }
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();	
	}
	@Feature("Disbursement Calculation")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.MINOR)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disburseAmtScrCalc(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			Response response2 = callGETMethod(token,"termLoanId","responseOfPreview",url3+"/api/v1/amortization-schedule");
			
			 for(int i=0;i<length;i++) {
			    	//response.jsonPath().get("openingBalance["+i+"]").toString()
			    	String str=response.jsonPath().get("openingBalance["+i+"]").toString();
			    	Double openingBalance = Double.valueOf(str);
			    	//System.out.println("openingBalance  "+openingBalance);
			    	
			    	String str2=response.jsonPath().get("interestRate["+i+"]").toString();
			    	Double Interest = Double.valueOf(str2);
			    	//System.out.println("My Interest"+Interest);
			    	
			    	String str3 = response.jsonPath().get("termLoan.terms["+i+"]").toString();
			    	Double dterms = Double.valueOf(str3);
			    	//System.out.println("My dterms"+dterms);
			    	Double rate= (Interest/100)/dterms;
			    	//System.out.println("my rate is "+rate);
			    	
			    	String str4=response.jsonPath().get("period["+i+"]").toString();
			    	Double currentPeriod = Double.valueOf(str4);
			    	int power = (int) (dterms - currentPeriod + 1);
			    	//System.out.println("Power is "+power);
			    	double temp = Math.pow(1 + rate, power);
			    	//System.out.println("temp is "+temp);
			    	double temp1=temp*rate;
			    	//System.out.println("temp1 is "+temp1);
			    	
			    	double temp2=temp-1;
			    	//System.out.println("temp2 is "+temp2);
			    	double temp3=temp1/temp2;
			    	//System.out.println("temp3 is "+temp3);
			    	
			    	double temp4=temp3*openingBalance;
			    	//System.out.println("temp4 is "+temp4);
			    	
			    	DecimalFormat df2 = new DecimalFormat("#.##");
			    	String d1= df2.format(temp4);
			    	Double regularPaymentDue_cal = Double.valueOf(d1);
			    	//System.out.println("regularPaymentDue_cal "+regularPaymentDue_cal);
			    	String str5 = response.jsonPath().get("regularPaymentDue["+i+"]").toString();
			    	Double PaymentDue = Double.valueOf(str5);
			    	softassert.assertEquals(regularPaymentDue_cal, PaymentDue);
			    	
			    	String str6 = response.jsonPath().get("regularPrincipal["+i+"]").toString();
			    	Double regularPrincipal = Double.valueOf(str6);
			    	System.out.println("regularPrincipal "+regularPrincipal);
			    	String str7=response.jsonPath().get("interestRate["+i+"]").toString();
			    	Double Interest1 = Double.valueOf(str7);
			    	Double double_divisor = Double.valueOf(divisor);
			    	//System.out.println("Interest "+Interest1);
			    	Double Interestcal=openingBalance*(Interest1/double_divisor)/100;
			    	Double regularPrincipal_calc=regularPaymentDue_cal-Interestcal;
			    	DecimalFormat df = new DecimalFormat("0.00");
			    	
			    	String regularPrincipal_calc1= df.format(regularPrincipal_calc);
			    	Double regularPrincipal_calc2 = Double.valueOf(regularPrincipal_calc1);
			    	//System.out.println("regularPrincipal_calc2 "+regularPrincipal_calc2);
			    	softassert.assertEquals(regularPrincipal,regularPrincipal_calc2);
			    }
			 
			
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();	
	}
	@Feature("Disbursement Calculation")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disburseAmtCal(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		   
		    System.out.println("length is "+length);
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			Date date1=GetDate.converTingStringIntoDate(initialPaymentDate);
			Date date = GetDate.addMonth(date1, 4);
			
			String newDate = GetDate.converTingDateIntoString(date);
			callPOSTMethodWithQuery(token,payloads.disbursementPayment(disbursementAmount, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			callPOSTMethodWithQuery(token,payloads.disbursementPayment(disbursementAmount, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			
			Response response2 = callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
			for(int i=0;i<length;i++) {
		    	//response.jsonPath().get("openingBalance["+i+"]").toString()
		    	String str=response2.jsonPath().get("openingBalance["+i+"]").toString();
		    	Double openingBalance = Double.valueOf(str);
		    	System.out.println("openingBalance  "+openingBalance);
		    	String str2=response2.jsonPath().get("interestRate["+i+"]").toString();
		    	Double Interest = Double.valueOf(str2);
		    	//System.out.println("My Interest"+Interest);
		    	String str3 = response2.jsonPath().get("regularPaymentDue["+i+"]").toString();
		    	Double regularPaymentDue = Double.valueOf(str3);
		    	System.out.println("regularPaymentDue is "+regularPaymentDue);
		    	
		    	String str4 = response2.jsonPath().get("termLoan.terms["+i+"]").toString();
		    	Integer dterms = Integer.valueOf(str4);
		    	
		    	String str5=response2.jsonPath().get("period["+i+"]").toString();
		    	Integer currentPeriod = Integer.valueOf(str5);
		    	
				
				  Double rate= (Interest/100)/dterms;
				  
				 
		    	double temp4=TermLoanCalculation.calculateRegularPaymentDue(openingBalance, rate, dterms, currentPeriod);
		    	Double regularPaymentDue_cal = DecimalFormater.covertodecimal(temp4);
		    	System.out.println("regularPaymentDue_cal "+regularPaymentDue_cal);
		    	softassert.assertEquals(regularPaymentDue_cal, regularPaymentDue);
		    	Double interestRate1=Double.valueOf(interestRate);
		    	Double double_divisor = Double.valueOf(divisor);
		    	
		    	Double Interestcal=openingBalance*(interestRate1/double_divisor)/100;
		    	Double dInterest =DecimalFormater.covertodecimal(Interestcal);
		    	System.out.println("Interestcal is "+dInterest);
		    	
		    	String str6=response2.jsonPath().get("regularInterest["+i+"]").toString();
		    	Double regularInterest = Double.valueOf(str6);
		    	softassert.assertEquals(dInterest, regularInterest);
		    	//Double disbursementAmount1 = Double.valueOf(disbursementAmount);
		    	
		    }

			System.out.println("disburseAmtCal");
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		softassert.assertAll();
	}
	@Feature("Verify and validate the functionality of payment due editable/Principal due after editing ")
	@Stories(value = { @Story(value = "Principal due edited should be equals to ture")})
	@Description("This is a test case which verifies the status code, principal due ,principal due edited ,opening and closing balance")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void editPaymentDue(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			
			int length=response.body().path("list.size()");
			String amortizationScheduleId=response.jsonPath().getString("id[3]");
			String paymentDate=response.jsonPath().getString("paymentDate[3]");
			String openingBalance=response.jsonPath().getString("openingBalance[3]");
			String regularInterest=response.jsonPath().getString("regularInterest[3]");
			String regularPrincipal=response.jsonPath().getString("regularPrincipal[3]");
			//String regularPaymentDue=response.jsonPath().getString("regularPaymentDue[3]");
			String regularPaymentDue="1000";
			String totalPaymentDue=response.jsonPath().getString("totalPaymentDue[3]");
			String endingBalance=response.jsonPath().getString("endingBalance[3]");
			String balanceDue=response.jsonPath().getString("balanceDue[3]");
			String period=response.jsonPath().getString("period[3]");
			String periodStartDate=response.jsonPath().getString("periodStartDate[3]");
			String periodEndDate=response.jsonPath().getString("periodEndDate[3]");
			String totalInterest=response.jsonPath().getString("termLoan.totalInterest[3]");
			String revisedInterestRateEffectiveDate=response.jsonPath().getString("termLoan.revisedInterestRateEffectiveDate[3]");
			
			String soFarDisbursement=response.jsonPath().getString("termLoan.soFarDisbursement[3]");
			String balanceDisbursement=response.jsonPath().getString("termLoan.balanceDisbursement[3]");
			//System.out.println("totalInterest "+totalInterest);
			Double Interest = Double.valueOf(interestRate);
			Integer term = Integer.valueOf(terms);
			Response response1 = callPUTMethod(token, "amortizationScheduleId", amortizationScheduleId, "interestChanged","false",payloads.editPaymentDuePayload(amortizationScheduleId, period, interestRate, paymentDate, openingBalance, regularInterest, regularPrincipal, regularPaymentDue, totalPaymentDue, endingBalance, balanceDue, responseOfPreview, loanNumber, loanName, loanType_id, principalAmount, totalInterest, revisedInterestRateEffectiveDate, interestRateType, interestRateCode, divisor, termType_id, value, display, terms, originationDate, disbursementDate, maturityDate, initialPaymentDate, borrower_id, loanName, loanStatus_id, soFarDisbursement, balanceDisbursement, disbursementAmount, periodStartDate, periodEndDate),url3+"/api/v1/amortization-schedule/recalculate-for-preview" );
			System.out.println(response1.body().asString());
			Double rate= (Interest/100)/term;
			for(int i=0;i<length;i++) {
				
				String str=response1.jsonPath().get("openingBalance["+i+"]").toString();
		    	Double openingBalance1 = Double.valueOf(str);
		    	System.out.println("openingBalance  "+openingBalance1);
		    	String str4=response.jsonPath().get("period["+i+"]").toString();
		    	Integer currentPeriod = Integer.valueOf(str4);
		    	String strpd=response1.jsonPath().get("regularPaymentDue["+i+"]").toString();
		    	Double regularPaymentDue1 = Double.valueOf(strpd);
		    	//double regularPaymentDuefmt = DecimalFormater.covertodecimal(regularPaymentDue1);
		    	//double regularPaymentDuefmt = Math.round(regularPaymentDue1*100)/100;
				//System.out.println("regularPaymentDue1 is "+regularPaymentDue1);
		    	double regularPaymentDueCal=TermLoanCalculation.calculateRegularPaymentDue(openingBalance1, rate, term,currentPeriod);
		    	double regularPaymentDueCal1 = DecimalFormater.covertodecimal(regularPaymentDueCal);
		    	//System.out.println(" regularPaymentDueCal is "+regularPaymentDueCal1);
		    	//softassert.assertEquals(regularPaymentDue1, regularPaymentDueCal1);
		    	if(i==3) {
		    		String paymentDueEdited=response1.jsonPath().get("paymentDueEdited["+i+"]").toString();
		    		softassert.assertEquals(paymentDueEdited, "true");
		    		
		    	}
		    	
		    	
		    	
		    	
			}
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		softassert.assertAll();
	}
	@Feature("Disbursement Date Validation")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursementDateVld(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount,String StatusCode)
	{
		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			
			
			statuscode = Integer.valueOf(StatusCode);
			softassert.assertEquals(response.getStatusCode(),statuscode);

		} catch (Exception e) {
			e.printStackTrace();
		}
		softassert.assertAll();
	}
	@Feature("Verify and validate the disbursement date ,wherein disbursement date should be greater than maturity date")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursementAmtDateVLD(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			Date date1=GetDate.converTingStringIntoDate(initialPaymentDate);
			Date date = GetDate.addMonth(date1, 11);
			
			String newDate = GetDate.converTingDateIntoString(date);
			System.out.println("newDate IS "+newDate);
			Response rspn = callPOSTMethodWithQuery(token,payloads.disbursementPayment(disbursementAmount, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			Response rspn1 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(disbursementAmount, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			System.out.println("rspn1 is "+rspn.statusCode());
			softassert.assertEquals(rspn1.getStatusCode(), STATUS_CODE_400);
			System.out.println("disbursementAmtDateVLD");
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();

	}
	@Feature("Verify and validate the disbursement date ,wherein disbursement date should be less than maturity date")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursementDateVLD1(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			Date date1=GetDate.converTingStringIntoDate(maturityDate);
			Date date = GetDate.addMonth(date1, -2);
			
			String newDate = GetDate.converTingDateIntoString(date);
			System.out.println("newDate IS "+newDate);
			Response rspn = callPOSTMethodWithQuery(token,payloads.disbursementPayment(disbursementAmount, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			Response rspn1 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(disbursementAmount, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			System.out.println("rspn1 is "+rspn.statusCode());
			softassert.assertEquals(rspn1.getStatusCode(), STATUS_CODE_201);
			System.out.println("disbursementDateVLD1");
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();
}
	@Feature("Verify and validate the disbursement date ,wherein Disbursement date should be <= calculated initial payment date ")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursementDateVLD2(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			softassert.assertEquals(response.getStatusCode(),STATUS_CODE_400 );
		    
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();
}
	@Feature("Verify and validate the Disbursement amount while term loam preview ,Where in Disbursement amount should be less than or equal to loan Principal amount and should not greater than Principal amount")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursementAmtVLD(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount,String StatusCode) {
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			statuscode = Integer.valueOf(StatusCode);
			//softassert.assertEquals(response.getStatusCode(),Integer.valueOf(StatusCode));
			softassert.assertEquals(response.getStatusCode(),statuscode);
			
		    
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();
}
	@Feature("Verify and validate the disbursement date ,wherein disbursement date should be greater equals to maturity date")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursementAmtDateVLD1(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			Date date1=GetDate.converTingStringIntoDate(maturityDate);
			
			
			String newDate = GetDate.converTingDateIntoString(date1);
			System.out.println("newDate IS "+newDate);
			Response rspn = callPOSTMethodWithQuery(token,payloads.disbursementPayment(disbursementAmount, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			Response rspn1 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(disbursementAmount, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			System.out.println("rspn1 is "+rspn.statusCode());
			softassert.assertEquals(rspn1.getStatusCode(), STATUS_CODE_400);
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();

	}
	@Feature("Verify and validate the disbursement date ,wherein disbursement date should be less than maturity date")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursementOrgVLD1(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			Date date1=GetDate.converTingStringIntoDate(originationDate);
			Date date = GetDate.addMonth(date1, -2);
			
			String newDate = GetDate.converTingDateIntoString(date);
			System.out.println("newDate IS "+newDate);
			Response rspn = callPOSTMethodWithQuery(token,payloads.disbursementPayment(disbursementAmount, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			Response rspn1 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(disbursementAmount, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			System.out.println("rspn1 is "+rspn.statusCode());
			softassert.assertEquals(rspn1.getStatusCode(), STATUS_CODE_400);
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();

}
	@Feature("Verify and validate the disbursement date ,wherein disbursement date should be less than maturity date")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursementAmtVLD1(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			Date date1=GetDate.converTingStringIntoDate(originationDate);
			Date date = GetDate.addMonth(date1, -2);
			Integer principalAmount1 = Integer.valueOf(principalAmount);
			int principalAmount2=principalAmount1+1000;
			String principalAmount3= String.valueOf(principalAmount2);
			System.out.println(" Hi principalAmount3 is "+principalAmount3);
			String newDate = GetDate.converTingDateIntoString(date);
			System.out.println("newDate IS "+newDate);
			Response rspn = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount3, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			Response rspn1 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount3, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			System.out.println("rspn1 is "+rspn.statusCode());
			softassert.assertEquals(rspn1.getStatusCode(), STATUS_CODE_400);
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();

}
	@Feature("Verify and validate the disbursement date ,wherein disbursement date should be less than maturity date")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disbursementAmtVLD2(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			Date date1=GetDate.converTingStringIntoDate(initialPaymentDate);
			Date date = GetDate.addMonth(date1, 2);
			Integer principalAmount1 = Integer.valueOf(principalAmount);
			int principalAmount2=principalAmount1-principalAmount1;
			String principalAmount3= String.valueOf(principalAmount2);
			System.out.println(" Hi principalAmount3 is "+principalAmount3);
			String newDate = GetDate.converTingDateIntoString(date);
			System.out.println("newDate IS "+newDate);
			Response rspn = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount3, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			Response rspn1 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount3, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			System.out.println("rspn1 is "+rspn.statusCode());
			softassert.assertEquals(rspn1.getStatusCode(), STATUS_CODE_400);
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();

}
	@Feature("Verify and validate the disbursement date ,wherein disbursement date should be less than maturity date")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void multpdisbursementDate(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		SoftAssert softassert = new SoftAssert();
		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
			System.out.println("Hi Test....");
			System.out.println("responseOfPreview "+responseOfPreview);
		    int length=response.body().path("list.size()");
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			Response response2=callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
			String openingBalance=response2.jsonPath().getString("openingBalance[3]");
			
			Double dopeningBalance = Double.valueOf(openingBalance);
			
			System.out.println(response2.getBody().asString());
			
			Date date1=GetDate.converTingStringIntoDate(initialPaymentDate);
			Date date = GetDate.addMonth(date1, 2);
			Integer principalAmount1 = Integer.valueOf(principalAmount);
			int principalAmount2=principalAmount1-3000;
			String principalAmount3= String.valueOf(principalAmount2);
			System.out.println(" Hi principalAmount3 is "+principalAmount3);
			String newDate = GetDate.converTingDateIntoString(date);
			System.out.println("newDate IS "+newDate);
			Response rspn = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount3, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			Response rspn1 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount3, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			
			System.out.println("rspn1 is "+rspn.statusCode());
			softassert.assertEquals(rspn1.getStatusCode(), STATUS_CODE_201);
			
			Response response4=callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
			String additionalDisbursement1=response4.jsonPath().getString("additionalDisbursement[3]");
			
			  Double double_divisor = Double.valueOf(divisor);
			
			 Double Interest = Double.valueOf(interestRate);

			Double dadditionalDisbursement1 = Double.valueOf(additionalDisbursement1);
			Double openingbalcalc=dadditionalDisbursement1+dopeningBalance;
			
			Double calInt=TermLoanCalculation.calculateInterestOnDayWise(openingbalcalc, Interest, 2);
			Double Interestcal=DecimalFormater.covertodecimal(calInt);
			String SInterestcal=String.valueOf(Interestcal);
			
			System.out.println(" Interestcal  is "+Interestcal);
			
			Response response6 = callGETMethod(token, "period","4", url3+"/api/v1/term-loan-charges/charges-and-payments/"+responseOfPreview);
			System.out.println(response6.getBody().asString());
	    	String amount=response6.jsonPath().get("scheduleRoi.amount[0]").toString();
	    	System.out.println(" amount is "+amount);
	    	//softassert.assertEquals(SInterestcal, amount);
			
			Date date2 = GetDate.addDay(date, 2);
            
			String newDate1 = GetDate.converTingDateIntoString(date2);
			System.out.println("newDate1 is "+newDate1);
			int principalAmount4=principalAmount1-4500;
			
			String principalAmount5= String.valueOf(principalAmount4);
			System.out.println(" Hi principalAmount3 is "+principalAmount5);
			
			Response rspn2 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount5, newDate1, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			Response rspn3 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount5, newDate1, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			
			Response response3=callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
			String additionalDisbursement=response3.jsonPath().getString("additionalDisbursement[3]");
			System.out.println("additionalDisbursement"+additionalDisbursement);
			
			Double dadditionalDisbursement = Double.valueOf(additionalDisbursement);
			Double openingbalcalc1=dadditionalDisbursement+dopeningBalance;
		
			Double calInt1=TermLoanCalculation.calculateInterestOnDayWise(openingbalcalc, Interest, 26);
			Double Interestcal1=DecimalFormater.covertodecimal(calInt1);
			String SInterestcal1=String.valueOf(Interestcal1);
			
			Response response7 = callGETMethod(token, "period","4", url3+"/api/v1/term-loan-charges/charges-and-payments/"+responseOfPreview);
			System.out.println(response7.getBody().asString());
	    	String amount1=response7.jsonPath().get("scheduleRoi.amount[1]").toString();
	    	System.out.println(" amount is "+amount1);
	    	//softassert.assertEquals(SInterestcal1, amount1);
	    	
	    	Double finalInterest=openingbalcalc+openingbalcalc1;
	    	Double Interestcal2=DecimalFormater.covertodecimal(finalInterest);
	    	String Exp_regularInterest =String.valueOf(Interestcal2);
	    	Response response8=callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
			String regularInterest=response8.jsonPath().getString("regularInterest[3]");
			//softassert.assertEquals(Exp_regularInterest, regularInterest);
			
			System.out.println("Hi Test....");
			System.out.println("Hi Test....");
			System.out.println("responseOfPreview  "+responseOfPreview);

			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();

}
	@Feature("Verify and validate the disbursement date ,wherein disbursement date should be less than maturity date")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void openandClosingCal(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		SoftAssert softassert = new SoftAssert();
		
		try {
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
		    System.out.println("length "+length);
		    for(int i=0;i<length;i++) {
		    	//response.jsonPath().get("openingBalance["+i+"]").toString()
		    	String str=response.jsonPath().get("openingBalance["+i+"]").toString();
		    	Double openingBalance = Double.valueOf(str);
		    	System.out.println("openingBalance  "+openingBalance);
		    	String str1=response.jsonPath().get("regularInterest["+i+"]").toString();
		    	Double regularInterest = Double.valueOf(str1);
		    	
		    	System.out.println("regularInterest "+regularInterest);
		    	String str2=response.jsonPath().get("interestRate["+i+"]").toString();
		    	Double Interest = Double.valueOf(str2);
		    	Double double_divisor = Double.valueOf(divisor);
		    	System.out.println("Interest "+Interest);
		    	Double Interestcal=openingBalance*(Interest/double_divisor)/100;
		    	double Interests=DecimalFormater.covertodecimal(Interestcal);
		    	
		    	System.out.println("Interestcal "+Interests);
		    	softassert.assertEquals(regularInterest, Interests);
		    	//double principal =openingBalance-Interestcal;
		    	String str5=response.jsonPath().get("period["+i+"]").toString();
		    	Integer currentPeriod = Integer.valueOf(str5);
		    	String str3 = response.jsonPath().get("termLoan.terms["+i+"]").toString();
		    	Integer dterms = Integer.valueOf(str3);
				
				  Double rate= (Interest/100)/dterms;
				  
				 
		    	double temp4=TermLoanCalculation.calculateRegularPaymentDue(openingBalance, rate, dterms, currentPeriod);
		    	Double pricipal = temp4-Interestcal;
		    	
		    	
		    	 Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
					softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
		    }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Feature("Verify and validate the disbursement date ,wherein disbursement date should be less than maturity date")
	@Stories(value = { @Story(value = "TERM LOAN SETUP")})
	@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
	@Step("Creation of Term loan with Positive details")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void disburseHistory(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		
		try {
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		    int length=response.body().path("list.size()");
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			Date date1=GetDate.converTingStringIntoDate(initialPaymentDate);
			Date date = GetDate.addMonth(date1, 2);
			Integer principalAmount1 = Integer.valueOf(principalAmount);
			int principalAmount2=principalAmount1-3000;
			String principalAmount3= String.valueOf(principalAmount2);
			System.out.println(" Hi principalAmount3 is "+principalAmount3);
			String newDate = GetDate.converTingDateIntoString(date);
			System.out.println("newDate IS "+newDate);
			Response rspn = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount3, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			Response rspn1 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount3, newDate, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			
			System.out.println("rspn1 is "+rspn.statusCode());
			softassert.assertEquals(rspn1.getStatusCode(), STATUS_CODE_201);
			
			Date date2 = GetDate.addDay(date, 2);
	        System.out.println("Hi Date is ");
			
			
			String newDate1 = GetDate.converTingDateIntoString(date2);
			System.out.println("newDate1 is "+newDate1);
			int principalAmount4=principalAmount1-4500;
			
			String principalAmount5= String.valueOf(principalAmount4);
			System.out.println(" Hi principalAmount3 is "+principalAmount5);
			
			Response rspn2 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount5, newDate1, responseOfPreview),url3+"/api/v1/term-loans/disbursement/preview","clientId",borrower_id);
			Response rspn3 = callPOSTMethodWithQuery(token,payloads.disbursementPayment(principalAmount5, newDate1, responseOfPreview),url3+"/api/v1/term-loans/disbursement/commit","clientId",borrower_id);
			
			Response rspn4 = callGETMethod(token,"termloanId",responseOfPreview,url3+"/api/v1/term-loans/disbursement/history");
			System.out.println(rspn4.getBody().asString());
			
			   Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}