package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
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

public class OneTimeManualFee  extends AbstractRestAssuredResponse{


	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;

	static double dfee=0.0;
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 
		
		

		@Feature("TS_01:One Time Manual Fee")
		@Stories(value = { @Story(value = "Verify the functionality of one time manual fee where activity date as loan origination date")})
		@Description("Verify the functionality of one time manual fee where activity date as loan origination date ")
		@Step("Verify the functionality of one time manual fee where activity date as loan origination date")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
		public void oneTimeManualFee(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {

		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		   
			String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			System.out.println("loanNumber is from body "+loanNumber);
			
			Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			
			
			
			Response response2 = callGETMethod(token,"frequency","manual",url3+"/api/v1/charges-template/term-loan/"+responseOfPreview);
			System.out.println(response2.getBody().asString());
			String id=response2.jsonPath().getList("id").get(0).toString();
			
			String gracePeriodDays=response2.jsonPath().getList("termLoan.gracePeriodDays").get(0).toString();
			//Integer gracePeriodDays=response2.then().extract().path("termLoan.gracePeriodDays[0]");
			System.out.println("gracePeriodDays is "+gracePeriodDays);
			String soFarDisbursement=response2.jsonPath().getList("termLoan.soFarDisbursement").get(0).toString();
			String balanceDisbursement=response2.jsonPath().getList("termLoan.balanceDisbursement").get(0).toString();
			String chargeCode_id=response2.jsonPath().getList("chargeCode.id").get(0).toString();
			String chargeCode=response2.jsonPath().getList("chargeCode.chargeCode").get(0).toString();
			String transactionCode=response2.jsonPath().getList("chargeCode.transactionCode").get(0).toString();
			
			String natSign=response2.jsonPath().getList("chargeCode.natSign.id").get(0).toString();
			String natSign_value=response2.jsonPath().getList("chargeCode.natSign.value").get(0).toString();
			String natSign_displayName=response2.jsonPath().getList("chargeCode.natSign.displayName").get(0).toString();
			
			String frequency=response2.jsonPath().getList("chargeCode.frequency.id").get(0).toString();
			String frequency_value=response2.jsonPath().getList("chargeCode.frequency.value").get(0).toString();
			String frequency_displayName=response2.jsonPath().getList("chargeCode.frequency.displayName").get(0).toString();
			
			String chargeType_id=response2.jsonPath().getList("chargeType.id").get(0).toString();
			String chargeType_value=response2.jsonPath().getList("chargeType.value").get(0).toString();
			String chargeType_displayName=response2.jsonPath().getList("chargeType.displayName").get(0).toString();
			String calculationType=response2.jsonPath().getList("chargeType.calculationType").get(0).toString();
			
			String postingType=response2.jsonPath().getList("chargeCode.postingType.id").get(0).toString();
			String postingType_value=response2.jsonPath().getList("chargeCode.postingType.value").get(0).toString();
			
			String postingType_displayName=response2.jsonPath().getList("chargeCode.postingType.displayName").get(0).toString();
			String charge_value=response2.jsonPath().getList("value").get(0).toString();

			String sign=response2.jsonPath().getList("natSign").get(0).toString();
			
			//SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			//Date date = new Date();
			//String activityDate=sdf.format(date);
			//System.out.println("activityDate is "+activityDate);
			//System.out.println("gracePeriodDays Is "+gracePeriodDays);
			
			Response response3=callPOSTMethod(token,payloads.addChargecodeOnLoan(id, responseOfPreview, loanNumber,loanName,loanType_id,principalAmount,interestRate,totalInterest,rateAdjustment,revisedInterestRateEffectiveDate,interestRateType,interestRateCode,divisor,termType_id,value,display,terms,originationDate,disbursementDate,maturityDate,initialPaymentDate,borrower_id,loanStatus_id,gracePeriodDays,amortizationType,soFarDisbursement,balanceDisbursement,disbursementAmount,chargeCode_id,chargeCode,transactionCode,natSign,natSign_value,natSign_displayName,frequency,frequency_value,frequency_displayName,chargeType_id,chargeType_value,chargeType_displayName,calculationType,postingType,postingType_value,postingType_displayName,charge_value,sign,originationDate),url3+"/api/v1/term-loan-charges/calculate-fee/"+responseOfPreview);
			System.out.println("status code is of last "+response3.getStatusCode());
			System.out.println("hiiiiiiiiiiiiiiiiiiiii"+response3.getBody().asString());
			
			Double dcharge_value = Double.valueOf(charge_value);
			Double dprincipalAmount = Double.valueOf(principalAmount);
			double calc=dprincipalAmount/100;
			double percentage=calc*dcharge_value;
			String chargedAmount=String.valueOf(percentage);
			
			Response response4=callPOSTMethod(token,payloads.addChargecodeOnLoancommit(id, responseOfPreview, loanNumber, loanName, loanType_id, principalAmount, interestRateCode, totalInterest, rateAdjustment, revisedInterestRateEffectiveDate, termType_id, frequency_value, display, terms, originationDate, disbursementDate, maturityDate, initialPaymentDate, borrower_id, loanStatus_id, soFarDisbursement, balanceDisbursement, disbursementAmount, chargeCode_id, chargeCode, transactionCode, natSign, natSign_value, natSign_displayName, frequency_displayName, chargeType_id, chargeType_value, chargeType_displayName, calculationType, postingType, postingType_value, postingType_displayName, charge_value, sign, originationDate, chargedAmount),url3+"/api/v1/term-loan-charges/add-fee/"+responseOfPreview);
			System.out.println("last code is "+response4.getStatusCode());
			
			Response response5 = callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
			
			int length=response5.body().path("list.size()");
			int i=0;
		    System.out.println("length "+length);
		    for(i=0;i<length;i++) {
		    	String fee=response5.jsonPath().getList("fee").get(i).toString();
		    	dfee = Double.valueOf(fee);
		    	if(percentage==dfee) {
		    		System.out.println("fee is "+fee);
		    		System.out.println("i value is "+i);
		    		softassert.assertEquals(dfee, percentage);
		    		break;
		    	}
		    	
		    	
		    }
		   int x=i+1;
		    String day_period=String.valueOf(x);
	    	Response response6 = callGETMethod(token, "period",day_period, url3+"/api/v1/term-loan-charges/charges-and-payments/"+responseOfPreview);
			System.out.println(response6.getBody().asString());
	    	String charge_id=response6.jsonPath().get("charges.id[0]").toString();
	    	
	    	System.out.println("id is ...test");
	    	System.out.println(charge_id);
	    	Response deletecharge=callDELETEMethod(token,url3+"/api/v1/term-loan-charges/undo-charged-amount/"+charge_id);
	    	
	    	softassert.assertEquals(STATUS_CODE_204, deletecharge.getStatusCode());
	    	
			Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
			softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();
		}
		
		@Feature("One time manual fee")
		@Stories(value = { @Story(value = "Amortization")})
		@Description("This is a test case which verifies the creation of loan and adding a charge code")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
		public void AmortizationSchedule(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			
			
			
			try {
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
			   
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
				
				
				
				
				Response response2 = callGETMethod(token,"frequency","manual",url3+"/api/v1/charges-template/term-loan/"+responseOfPreview);
				System.out.println(response2.getBody().asString());
				String id=response2.jsonPath().getList("id").get(0).toString();
				
				String gracePeriodDays=response2.jsonPath().getList("termLoan.gracePeriodDays").get(0).toString();
				//Integer gracePeriodDays=response2.then().extract().path("termLoan.gracePeriodDays[0]");
				System.out.println("gracePeriodDays is "+gracePeriodDays);
				String soFarDisbursement=response2.jsonPath().getList("termLoan.soFarDisbursement").get(0).toString();
				String balanceDisbursement=response2.jsonPath().getList("termLoan.balanceDisbursement").get(0).toString();
				String chargeCode_id=response2.jsonPath().getList("chargeCode.id").get(0).toString();
				String chargeCode=response2.jsonPath().getList("chargeCode.chargeCode").get(0).toString();
				String transactionCode=response2.jsonPath().getList("chargeCode.transactionCode").get(0).toString();
				
				String natSign=response2.jsonPath().getList("chargeCode.natSign.id").get(0).toString();
				String natSign_value=response2.jsonPath().getList("chargeCode.natSign.value").get(0).toString();
				String natSign_displayName=response2.jsonPath().getList("chargeCode.natSign.displayName").get(0).toString();
				
				String frequency=response2.jsonPath().getList("chargeCode.frequency.id").get(0).toString();
				String frequency_value=response2.jsonPath().getList("chargeCode.frequency.value").get(0).toString();
				String frequency_displayName=response2.jsonPath().getList("chargeCode.frequency.displayName").get(0).toString();
				
				String chargeType_id=response2.jsonPath().getList("chargeType.id").get(0).toString();
				String chargeType_value=response2.jsonPath().getList("chargeType.value").get(0).toString();
				String chargeType_displayName=response2.jsonPath().getList("chargeType.displayName").get(0).toString();
				String calculationType=response2.jsonPath().getList("chargeType.calculationType").get(0).toString();
				
				String postingType=response2.jsonPath().getList("chargeCode.postingType.id").get(0).toString();
				String postingType_value=response2.jsonPath().getList("chargeCode.postingType.value").get(0).toString();
				
				String postingType_displayName=response2.jsonPath().getList("chargeCode.postingType.displayName").get(0).toString();
				String charge_value=response2.jsonPath().getList("value").get(0).toString();

				String sign=response2.jsonPath().getList("natSign").get(0).toString();
				
				SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				String activityDate=sdf.format(date);
				System.out.println("activityDate is "+activityDate);
				System.out.println("gracePeriodDays Is "+gracePeriodDays);
				
				Response response3=callPOSTMethod(token,payloads.addChargecodeOnLoan(id, responseOfPreview, loanNumber,loanName,loanType_id,principalAmount,interestRate,totalInterest,rateAdjustment,revisedInterestRateEffectiveDate,interestRateType,interestRateCode,divisor,termType_id,value,display,terms,originationDate,disbursementDate,maturityDate,initialPaymentDate,borrower_id,loanStatus_id,gracePeriodDays,amortizationType,soFarDisbursement,balanceDisbursement,disbursementAmount,chargeCode_id,chargeCode,transactionCode,natSign,natSign_value,natSign_displayName,frequency,frequency_value,frequency_displayName,chargeType_id,chargeType_value,chargeType_displayName,calculationType,postingType,postingType_value,postingType_displayName,charge_value,sign,activityDate),url3+"/api/v1/term-loan-charges/calculate-fee/"+responseOfPreview);
				System.out.println("status code is of last "+response3.getStatusCode());
				System.out.println("hiiiiiiiiiiiiiiiiiiiii"+response3.getBody().asString());
				
				Double dcharge_value = Double.valueOf(charge_value);
				Double dprincipalAmount = Double.valueOf(principalAmount);
				double calc=dprincipalAmount/100;
				double percentage=calc*dcharge_value;
				String chargedAmount=String.valueOf(percentage);
				
				Response response4=callPOSTMethod(token,payloads.addChargecodeOnLoancommit(id, responseOfPreview, loanNumber, loanName, loanType_id, principalAmount, interestRateCode, totalInterest, rateAdjustment, revisedInterestRateEffectiveDate, termType_id, frequency_value, display, terms, originationDate, disbursementDate, maturityDate, initialPaymentDate, borrower_id, loanStatus_id, soFarDisbursement, balanceDisbursement, disbursementAmount, chargeCode_id, chargeCode, transactionCode, natSign, natSign_value, natSign_displayName, frequency_displayName, chargeType_id, chargeType_value, chargeType_displayName, calculationType, postingType, postingType_value, postingType_displayName, charge_value, sign, activityDate, chargedAmount),url3+"/api/v1/term-loan-charges/add-fee/"+responseOfPreview);
				System.out.println("last code is "+response4.getStatusCode());
				
				Response response5 = callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
				
				int length=response5.body().path("list.size()");
				int i=0;
			    System.out.println("length "+length);
			    for(i=0;i<length;i++) {
			    	String fee=response5.jsonPath().getList("fee").get(i).toString();
			    	dfee = Double.valueOf(fee);
			    	if(percentage==dfee) {
			    		System.out.println("fee is "+fee);
			    		System.out.println("i value is "+i);
			    		softassert.assertEquals(dfee, percentage);
			    		break;
			    	}
			    	
			    	
			    }
			   int x=i+1;
			    String day_period=String.valueOf(x);
		    	Response response6 = callGETMethod(token, "period",day_period, url3+"/api/v1/term-loan-charges/charges-and-payments/"+responseOfPreview);
				System.out.println(response6.getBody().asString());
		    	String charge_id=response6.jsonPath().get("charges.id[0]").toString();
		    	
		    	System.out.println("id is ...test");
		    	System.out.println(charge_id);
		    	Response deletecharge=callDELETEMethod(token,url3+"/api/v1/term-loan-charges/undo-charged-amount/"+charge_id);
		    	
		    	softassert.assertEquals(STATUS_CODE_204, deletecharge.getStatusCode());
		    	
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			softassert.assertAll();
			
		
		
		
		
		}

	//One time -POSt-Percentage
		

		@Feature("TS_02:One Time Manual Fee")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("Verify the functionality of one time manual fee where activity date as loan origination date +1 term")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
		public void oneTimeManualCal(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
			   
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
				
				
				
				
				Response response2 = callGETMethod(token,"frequency","manual",url3+"/api/v1/charges-template/term-loan/"+responseOfPreview);
				System.out.println(response2.getBody().asString());
				String id=response2.jsonPath().getList("id").get(0).toString();
				
				String gracePeriodDays=response2.jsonPath().getList("termLoan.gracePeriodDays").get(0).toString();
				//Integer gracePeriodDays=response2.then().extract().path("termLoan.gracePeriodDays[0]");
				System.out.println("gracePeriodDays is "+gracePeriodDays);
				String soFarDisbursement=response2.jsonPath().getList("termLoan.soFarDisbursement").get(0).toString();
				String balanceDisbursement=response2.jsonPath().getList("termLoan.balanceDisbursement").get(0).toString();
				String chargeCode_id=response2.jsonPath().getList("chargeCode.id").get(0).toString();
				String chargeCode=response2.jsonPath().getList("chargeCode.chargeCode").get(0).toString();
				String transactionCode=response2.jsonPath().getList("chargeCode.transactionCode").get(0).toString();
				
				String natSign=response2.jsonPath().getList("chargeCode.natSign.id").get(0).toString();
				String natSign_value=response2.jsonPath().getList("chargeCode.natSign.value").get(0).toString();
				String natSign_displayName=response2.jsonPath().getList("chargeCode.natSign.displayName").get(0).toString();
				
				String frequency=response2.jsonPath().getList("chargeCode.frequency.id").get(0).toString();
				String frequency_value=response2.jsonPath().getList("chargeCode.frequency.value").get(0).toString();
				String frequency_displayName=response2.jsonPath().getList("chargeCode.frequency.displayName").get(0).toString();
				
				String chargeType_id=response2.jsonPath().getList("chargeType.id").get(0).toString();
				String chargeType_value=response2.jsonPath().getList("chargeType.value").get(0).toString();
				String chargeType_displayName=response2.jsonPath().getList("chargeType.displayName").get(0).toString();
				String calculationType=response2.jsonPath().getList("chargeType.calculationType").get(0).toString();
				
				String postingType=response2.jsonPath().getList("chargeCode.postingType.id").get(0).toString();
				String postingType_value=response2.jsonPath().getList("chargeCode.postingType.value").get(0).toString();
				
				String postingType_displayName=response2.jsonPath().getList("chargeCode.postingType.displayName").get(0).toString();
				String charge_value=response2.jsonPath().getList("value").get(0).toString();

				String sign=response2.jsonPath().getList("natSign").get(0).toString();
				
				
				
				Response response3=callPOSTMethod(token,payloads.addChargecodeOnLoan(id, responseOfPreview, loanNumber,loanName,loanType_id,principalAmount,interestRate,totalInterest,rateAdjustment,revisedInterestRateEffectiveDate,interestRateType,interestRateCode,divisor,termType_id,value,display,terms,originationDate,disbursementDate,maturityDate,initialPaymentDate,borrower_id,loanStatus_id,gracePeriodDays,amortizationType,soFarDisbursement,balanceDisbursement,disbursementAmount,chargeCode_id,chargeCode,transactionCode,natSign,natSign_value,natSign_displayName,frequency,frequency_value,frequency_displayName,chargeType_id,chargeType_value,chargeType_displayName,calculationType,postingType,postingType_value,postingType_displayName,charge_value,sign,originationDate),url3+"/api/v1/term-loan-charges/calculate-fee/"+responseOfPreview);
				System.out.println("status code is of last "+response3.getStatusCode());
				System.out.println("hiiiiiiiiiiiiiiiiiiiii"+response3.getBody().asString());
				
				Double dcharge_value = Double.valueOf(charge_value);
				Double dprincipalAmount = Double.valueOf(principalAmount);
				double calc=dprincipalAmount/100;
				double percentage=calc*dcharge_value;
				String chargedAmount=String.valueOf(percentage);
				
				Response response4=callPOSTMethod(token,payloads.addChargecodeOnLoancommit(id, responseOfPreview, loanNumber, loanName, loanType_id, principalAmount, interestRateCode, totalInterest, rateAdjustment, revisedInterestRateEffectiveDate, termType_id, frequency_value, display, terms, originationDate, disbursementDate, maturityDate, initialPaymentDate, borrower_id, loanStatus_id, soFarDisbursement, balanceDisbursement, disbursementAmount, chargeCode_id, chargeCode, transactionCode, natSign, natSign_value, natSign_displayName, frequency_displayName, chargeType_id, chargeType_value, chargeType_displayName, calculationType, postingType, postingType_value, postingType_displayName, charge_value, sign, originationDate, chargedAmount),url3+"/api/v1/term-loan-charges/add-fee/"+responseOfPreview);
				System.out.println("last code is "+response4.getStatusCode());
				
				Response response5 = callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
				
				int length=response5.body().path("list.size()");
				int i=0;
			    System.out.println("length "+length);
			    for(i=0;i<length;i++) {
			    	String fee=response5.jsonPath().getList("fee").get(i).toString();
			    	dfee = Double.valueOf(fee);
			    	if(percentage==dfee) {
			    		System.out.println("fee is "+fee);
			    		System.out.println("i value is "+i);
			    		softassert.assertEquals(dfee, percentage);
			    		break;
			    	}
			    	
			    	
			    }
			   int x=i+1;
			    String day_period=String.valueOf(x);
		    	Response response6 = callGETMethod(token, "period",day_period, url3+"/api/v1/term-loan-charges/charges-and-payments/"+responseOfPreview);
				System.out.println(response6.getBody().asString());
		    	String charge_id=response6.jsonPath().get("charges.id[0]").toString();
		    	
		    	System.out.println("id is ...test");
		    	System.out.println(charge_id);
		    	Response deletecharge=callDELETEMethod(token,url3+"/api/v1/term-loan-charges/undo-charged-amount/"+charge_id);
		    	
		    	softassert.assertEquals(STATUS_CODE_204, deletecharge.getStatusCode());
		    	
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			softassert.assertAll();
	}
		@Feature("TS_02:One Time Manual Fee")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("Verify the functionality of one time manual fee where activity date as loan origination date +1 term")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
		public void oneTimeManualFeeNeg(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			
			try {
				
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
			   
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				System.out.println("loanNumber is from body "+loanNumber);
				
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
				
				
				
				
				Response response2 = callGETMethod(token,"frequency","manual",url3+"/api/v1/charges-template/term-loan/"+responseOfPreview);
				System.out.println(response2.getBody().asString());
				String id=response2.jsonPath().getList("id").get(0).toString();
				
				String gracePeriodDays=response2.jsonPath().getList("termLoan.gracePeriodDays").get(0).toString();
				//Integer gracePeriodDays=response2.then().extract().path("termLoan.gracePeriodDays[0]");
				System.out.println("gracePeriodDays is "+gracePeriodDays);
				String soFarDisbursement=response2.jsonPath().getList("termLoan.soFarDisbursement").get(0).toString();
				String balanceDisbursement=response2.jsonPath().getList("termLoan.balanceDisbursement").get(0).toString();
				String chargeCode_id=response2.jsonPath().getList("chargeCode.id").get(0).toString();
				String chargeCode=response2.jsonPath().getList("chargeCode.chargeCode").get(0).toString();
				String transactionCode=response2.jsonPath().getList("chargeCode.transactionCode").get(0).toString();
				
				String natSign=response2.jsonPath().getList("chargeCode.natSign.id").get(0).toString();
				String natSign_value=response2.jsonPath().getList("chargeCode.natSign.value").get(0).toString();
				String natSign_displayName=response2.jsonPath().getList("chargeCode.natSign.displayName").get(0).toString();
				
				String frequency=response2.jsonPath().getList("chargeCode.frequency.id").get(0).toString();
				String frequency_value=response2.jsonPath().getList("chargeCode.frequency.value").get(0).toString();
				String frequency_displayName=response2.jsonPath().getList("chargeCode.frequency.displayName").get(0).toString();
				
				String chargeType_id=response2.jsonPath().getList("chargeType.id").get(0).toString();
				String chargeType_value=response2.jsonPath().getList("chargeType.value").get(0).toString();
				String chargeType_displayName=response2.jsonPath().getList("chargeType.displayName").get(0).toString();
				String calculationType=response2.jsonPath().getList("chargeType.calculationType").get(0).toString();
				
				String postingType=response2.jsonPath().getList("chargeCode.postingType.id").get(0).toString();
				String postingType_value=response2.jsonPath().getList("chargeCode.postingType.value").get(0).toString();
				
				String postingType_displayName=response2.jsonPath().getList("chargeCode.postingType.displayName").get(0).toString();
				String charge_value=response2.jsonPath().getList("value").get(0).toString();

				String sign=response2.jsonPath().getList("natSign").get(0).toString();
				
				SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				System.out.println("date is ........"+date);
				Date date1=GetDate.addMonth(date, 1);
				String activityDate=sdf.format(date1);
				System.out.println("activityDate is "+activityDate);
				
				
				Response response3=callPOSTMethod(token,payloads.addChargecodeOnLoan(id, responseOfPreview, loanNumber,loanName,loanType_id,principalAmount,interestRate,totalInterest,rateAdjustment,revisedInterestRateEffectiveDate,interestRateType,interestRateCode,divisor,termType_id,value,display,terms,originationDate,disbursementDate,maturityDate,initialPaymentDate,borrower_id,loanStatus_id,gracePeriodDays,amortizationType,soFarDisbursement,balanceDisbursement,disbursementAmount,chargeCode_id,chargeCode,transactionCode,natSign,natSign_value,natSign_displayName,frequency,frequency_value,frequency_displayName,chargeType_id,chargeType_value,chargeType_displayName,calculationType,postingType,postingType_value,postingType_displayName,charge_value,sign,activityDate),url3+"/api/v1/term-loan-charges/calculate-fee/"+responseOfPreview);
				int statuscode=response3.getStatusCode();
				System.out.println("hiiiiiiiiiiiiiiiiiiiii"+response3.getBody().asString());
				softassert.assertEquals(STATUS_CODE_400, response3.getStatusCode());
				
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			softassert.assertAll();
	}

	
//One time-Negative for Percentage
		
	    @Feature("Term loan One time manual fee")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="sanity")
		public void oneTimeManualNegative(String negativedata,String Statuscode) throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		
			Response getFee=callGETMethod(token, data.getTermloanID());
			System.out.println("getFee"+getFee.asString());
			String LoanId=getFee.jsonPath().getList("id").get(0).toString();
			System.out.println("LoanId:"+LoanId);
			softassert.assertEquals(getFee.statusCode(), STATUS_CODE_200, "this is the status code for termloanResponse");
			
			Response NegativeDatas=callPOSTMethod(token, payloads.getPayloadsforManualNegativePercentage(negativedata),data.getManualfeePost()+LoanId );
			System.out.println("NegativeDatas:"+NegativeDatas.asString());
			softassert.assertEquals(NegativeDatas.statusCode(),Integer.valueOf(Statuscode).intValue(), "this is the status code for termloanResponse");
			softassert.assertEquals(NegativeDatas.statusCode(),Integer.valueOf(Statuscode).intValue(), "this is the status code for termloanResponse");
			softassert.assertAll();
	}

	//One time _value
		@Feature("Term loan One time manual fee")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
	    @Test(groups= {"smoke" })
		public void oneTimeManualFeePostValue() throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			
			try {
				Response getFee=callGETMethod(token, data.getTermloanID());
				System.out.println("getFee"+getFee.asString());
				String LoanId=getFee.jsonPath().getList("id").get(0).toString();
				System.out.println("LoanId:"+LoanId);
				softassert.assertEquals(getFee.statusCode(), STATUS_CODE_200, "this is the status code for termloanResponse");
				


				Response manualFeePost=callPOSTMethod(token, payloads.getPayloadforManualFeePostValue(), data.getManualfeePost()+LoanId);
				System.out.println("manualFeePost:"+manualFeePost.asString());
				softassert.assertEquals(manualFeePost.statusCode(), STATUS_CODE_400, "this is the status code for termloanResponse");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			softassert.assertAll();

}
		//One time Value-Negative
		
		

	@Feature("TERM LOAN ONE TIME MANUAL VALUE FOR NEGATIVE DATA")
		@Stories(value = { @Story(value = "Term loan one time manual value for negative data")})
		@Description("This is a test case which verifies the status code: one time manual fee for value with NEgative data")
		@Step("verifies one time manual value as negative")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression"})
		public void OnetimeValueNEgative(String negativedata,String Statuscode) throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		
			Response getFee=callGETMethod(token, data.getTermloanID());
			System.out.println("getFee"+getFee.asString());
			String LoanId=getFee.jsonPath().getList("id").get(0).toString();
			System.out.println("LoanId:"+LoanId);
			softassert.assertEquals(getFee.statusCode(), STATUS_CODE_200, "this is the status code for termloanResponse");
			
			Response NegativeDatas=callPOSTMethod(token, payloads.getPayloadforManualValueNegative(negativedata),data.getManualfeePost()+LoanId );
			System.out.println("NegativeDatas:"+NegativeDatas.asString());
			softassert.assertEquals(NegativeDatas.statusCode(),Integer.valueOf(Statuscode).intValue(), "this is the status code for one time manual value as negative");
			softassert.assertAll();

}  
	

//Late Penalty
	
	


	@Feature("Late fee penalty Percentage")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
    @Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression"})
	public void latefeepenalty(String percentage,String Statuscode) throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		
		Response latefeepenalty=callPOSTMethod(token, payloads.getpenaltyRequestbody(percentage),url3+"/api/v1/term-loan-charges/add-fee/acb37b38-dd05-4ebf-b0e1-2ea2c9682dbc");
		System.out.println("latefeepenalty"+latefeepenalty.asString());
		softassert.assertEquals(latefeepenalty.statusCode(),Integer.valueOf(Statuscode).intValue(), "Statius code of Late fee penalty for PErcentage");
		softassert.assertAll();

}





	@Feature("Late fee penalty Percentage")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression"})
	public void latefeepenaltyValue(String value,String Statuscode) throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		
		Response latefeepenalty=callPOSTMethod(token, payloads.getpenaltyRequestbodyForvalue(value),url3+"/api/v1/term-loan-charges/add-fee/acb37b38-dd05-4ebf-b0e1-2ea2c9682dbc");
		System.out.println("latefeepenalty"+latefeepenalty.asString());
		
		Response getFee=callGETMethod(token, data.getTermloanID());
		System.out.println("getFee"+getFee.asString());
		String LoanId=getFee.jsonPath().getList("id").get(0).toString();
		System.out.println("Hi i m checking termloanId  "+LoanId);
		softassert.assertEquals(latefeepenalty.statusCode(),Integer.valueOf(Statuscode).intValue(), "Statius code of Late fee penalty for value");
		softassert.assertAll();

}

}