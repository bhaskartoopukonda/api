package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.DecimalFormater;
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

public class Amortization extends AbstractRestAssuredResponse{


	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;
	private static final int STATUS_CODE_500 =500;
	static double dfee=0.0;

	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 


	@Feature("Amortization")
	@Stories(value = { @Story(value = "Get amortization for requested term loan")})
	@Description("This is a test case which verifies the status code: Get amortization for requested term loan")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.MINOR)
	@Test(groups= {"smoke" })
	public void amortizationGet() throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		
		
		try {
			
			Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
			System.out.println(getFee.getBody().asString());
			
			 int length=getFee.body().path("list.size()");
			 System.out.println("length is "+length);
			 for(int i=0;i<length;i++) {
				String LoanId=getFee.jsonPath().getList("id").get(i).toString();

				Response responseOfgetFee=callGETMethodWithQuery(token, data.getAmortizationscheduleAPI(),LoanId);
				
				System.out.println(responseOfgetFee.getBody().asString());
				

				softassert.assertEquals(responseOfgetFee.statusCode(),STATUS_CODE_200, "this is the status code for Amortization");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();

	}


	@Feature("Amortization")
	@Stories(value = { @Story(value = "To get all term loan payments due on requested batch date")})
	@Description("Verify to get all term loan payments due on requested batch date for a particular client.")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.NORMAL)
	@Test(groups= {"sanity", "smoke","regression" })
	public void amortizationSchelue() throws FileNotFoundException, IOException, ParseException {

		SoftAssert softassert = new SoftAssert();
		try {
			//list out all the active loan
			Response getFee=callGETMethod(token, "clientId",data.clientId(),"statusList","active",url3+"/api/v1/term-loans");
			System.out.println(getFee.getBody().asString());
			
			 int length=getFee.body().path("list.size()");
			 System.out.println("length is "+length);
			String LoanId=getFee.jsonPath().getList("id").get(0).toString();

			System.out.println("LoanId"+LoanId);
			verifyingStatuscodes(getFee.statusCode(),STATUS_CODE_200, "this is the status code for Loan ID");
	       
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			String batch_date=sdf.format(date);
			Response amortizationSchedule=callGETMethod(token,"batchDate",batch_date,url3+"/api/v1/amortization-schedule/payments-due/"+data.clientId());
			System.out.println("amortizationSchedule:"+amortizationSchedule.getBody().asString());
			softassert.assertEquals(amortizationSchedule.statusCode(),STATUS_CODE_200, "this is the status code for Amortization");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();
	}

	//POSt
	@Feature("Amortization")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("Verify to init term loan payments for any particular loan")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	
	public void amortizationScheluePost(String loanType_id,String borrower_id,String name,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();

		try {
			
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreviewAmt(loanType_id,borrower_id,name,loanNumber,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
			System.out.println("responseOfPreview is "+responseOfPreview);
		   // int length=response.body().path("list.size()");
		   
	        Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommitAmt(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			String batch_date=sdf.format(date);
			Float amount=response.jsonPath().get("totalPaymentDue[0]");
			String total_amount=String.valueOf(amount);

       Response createBatch = callPOSTMethod(token, "batch_data", payloads.getPayloadForCreateBatch(batch_date, "1276",total_amount),
					url+"/api/cash-application-v2/v1/batches");
        Thread.sleep(10000);
		int batch_id = createBatch.then().extract().path("batch_id");
		System.out.println("batch_id is "+batch_id);
		 Integer inbatches= createBatch.then().extract().path("id");
		 String batches= String.valueOf(inbatches);
		 System.out.println("Batch is "+batches);
		
			System.out.println(createBatch.getBody().asString());
			
			Response get_time=callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
			String principal_due_amount=get_time.jsonPath().get("totalPaymentDue[0]").toString();
			String period=get_time.jsonPath().get("period[0]").toString();
			String interest_due_amount=get_time.jsonPath().get("regularInterest[0]").toString();
			
			String initial_payment_date=get_time.jsonPath().get("termLoan.initialPaymentDate[0]").toString();
			String payment_due_date=get_time.jsonPath().get("termLoan.initialPaymentDate[0]").toString();
		
			
			Response respn1 = callGETMethodWithSixQuery(token,"borrower_id",borrower_id,"batch_id",batches,"batch_date",batch_date,"check_id","undefined","loan_number",loanNumber,"allocation_amount",total_amount,url+"/api/cash-application-v2/v1/term_loans/auto_allocation");
			System.out.println(respn1.getBody().asString());
			
			
			Response create_batch_pl=callPUTMethod(token,"batch_data",payloads.termLonDistrubution(batch_date, "1276", total_amount, borrower_id, "ATY17", total_amount, loanNumber, loanName, responseOfPreview, initial_payment_date, period, payment_due_date, interest_due_amount, principal_due_amount, total_amount, total_amount),url+"/api/cash-application-v2/v1/batches/"+batches);
			Thread.sleep(10000);
			System.out.println("create_batch_pl "+create_batch_pl.getBody().asString());

			Response batch_processd=callPOSTMethod(token,payloads.processBatch(batches),url+"/api/cash-application-v2/v1/batches/batch_process");
			System.out.println("create_batch_pl is "+batch_processd.getBody().asString());
			
			Response paymentdetails=callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
			String bvalue=paymentdetails.jsonPath().get("paymentDone[0]").toString();
			System.out.println("bvalue is "+bvalue);
			softassert.assertEquals(bvalue, "true");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		softassert.assertAll();
	}




	@Feature("Amortization")
	@Stories(value = { @Story(value = "Amortization")})
	@Description("Verify to update regular payment for a amortization period")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void amortizationSchelueregularPaymentDueUpdate() throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
       
		try {
			Response getFee=callGETMethod(token, data.getTermloanID());
			System.out.println("getFee"+getFee.asString());
			String LoanId=getFee.jsonPath().getList("id").get(0).toString();
			System.out.println("LoanId"+LoanId);
			softassert.assertEquals(getFee.statusCode(),STATUS_CODE_200, "this is the status code for TermLoan Id");


			Response amortization=callGETMethod(token, "termLoanId", LoanId, data.getAmortizationscheduleAPI());
			System.out.println("amortization:"+amortization.asString());
			String ResponseID=amortization.jsonPath().getList("id").get(0).toString();
			String period=amortization.jsonPath().getList("period").get(0).toString();
			String interestRate=amortization.jsonPath().getList("interestRate").get(0).toString();
			String paymentDate=amortization.jsonPath().getList("paymentDate").get(0).toString();
			String openingBalance=amortization.jsonPath().getList("openingBalance").get(0).toString();
			String regularInterest=amortization.jsonPath().getList("regularInterest").get(0).toString();
			String regularPrincipal=amortization.jsonPath().getList("regularPrincipal").get(0).toString();
			String regularPaymentDue=amortization.jsonPath().getList("regularPaymentDue").get(0).toString();
			String totalPaymentDue=amortization.jsonPath().getList("totalPaymentDue").get(0).toString();
			String endingBalance=amortization.jsonPath().getList("endingBalance").get(0).toString();
			String balanceDue=amortization.jsonPath().getList("balanceDue").get(0).toString();
			String loanNumber=amortization.jsonPath().getList("termLoan.loanNumber").get(0).toString();
			String loanName=amortization.jsonPath().getList("termLoan.loanName").get(0).toString();
			String loanType_id=amortization.jsonPath().getList("termLoan.loanType.id").get(0).toString();
			String principalAmount=amortization.jsonPath().getList("termLoan.principalAmount").get(0).toString();
			String revisedInterestRateEffectiveDate=amortization.jsonPath().getList("termLoan.revisedInterestRateEffectiveDate").get(0).toString();
			String interestRateType=amortization.jsonPath().getList("termLoan.interestRateType").get(0).toString();
			String interestRateCode=amortization.jsonPath().getList("termLoan.interestRateCode").get(0).toString();
			String divisor=amortization.jsonPath().getList("termLoan.divisor").get(0).toString();
			String termType_id=amortization.jsonPath().getList("termLoan.termType.id").get(0).toString();
			String value=amortization.jsonPath().getList("termLoan.termType.value").get(0).toString();
			String display=amortization.jsonPath().getList("termLoan.termType.display").get(0).toString();
			String terms=amortization.jsonPath().getList("termLoan.terms").get(0).toString();
			String originationDate=amortization.jsonPath().getList("termLoan.originationDate").get(0).toString();
			String disbursementDate=amortization.jsonPath().getList("termLoan.disbursementDate").get(0).toString();
			
			String amortizationType=amortization.jsonPath().getList("termLoan.amortizationType").get(0).toString();
			
			String maturityDate=amortization.jsonPath().getList("termLoan.maturityDate").get(0).toString();
			String initialPaymentDate=amortization.jsonPath().getList("termLoan.initialPaymentDate").get(0).toString();
			String loanStatus_id=amortization.jsonPath().getList("termLoan.loanStatus.id").get(0).toString();
			String soFarDisbursement=amortization.jsonPath().getList("termLoan.soFarDisbursement").get(0).toString();
			String balanceDisbursement=amortization.jsonPath().getList("termLoan.balanceDisbursement").get(0).toString();
			String periodStartDate=amortization.jsonPath().getList("periodStartDate").get(0).toString();
			String periodEndDate=amortization.jsonPath().getList("periodEndDate").get(0).toString();
			String additionalDisbursement=amortization.jsonPath().getList("additionalDisbursement").get(0).toString();
			String disbursementAmount=amortization.jsonPath().getList("termLoan.disbursementAmount").get(0).toString();
			
			System.out.println("ResponseID:"+ResponseID);
			
			softassert.assertEquals(amortization.statusCode(), STATUS_CODE_200, "this is to get stats code of amortization Schecule");

			//regularPaymentDue
			Double dregularPaymentDue = Double.valueOf(regularPaymentDue);
			Double dinterestRate = Double.valueOf(interestRate);
			Double regularPaymentDuecal=dregularPaymentDue+dinterestRate;
			System.out.println(" regularPaymentDue is "+regularPaymentDue);
			System.out.println("regularPaymentDuecal is "+regularPaymentDuecal);
			String sregularPaymentDuecal=String.valueOf(regularPaymentDuecal);
			Response regulardue=callPUTMethodWithQuaryParameter(token,"amortizationScheduleId",ResponseID, payloads.getPayloadforAmortizationUPdateRegularDate(ResponseID, period, interestRate, paymentDate, openingBalance, regularInterest, regularPrincipal, sregularPaymentDuecal, totalPaymentDue, endingBalance, balanceDue, LoanId, loanNumber, loanName, loanType_id, principalAmount, interestRate, revisedInterestRateEffectiveDate, interestRateType, interestRateCode, divisor, termType_id, value, display, terms, originationDate, disbursementDate, maturityDate, initialPaymentDate, loanStatus_id, amortizationType, soFarDisbursement, balanceDisbursement, disbursementAmount, periodStartDate, periodEndDate, additionalDisbursement),url3+"/api/v1/amortization-schedule/update-regular-due");
			System.out.println("{regulardue:"+regulardue.asString());
			//i will update this test script
		softassert.assertEquals(regulardue.statusCode(), STATUS_CODE_204, "this is get status code of regulardue PUT ");
		Response amortization1=callGETMethod(token, "termLoanId", LoanId, data.getAmortizationscheduleAPI());
		String regularPaymentDue1=amortization1.jsonPath().getList("regularPaymentDue").get(0).toString();
		softassert.assertEquals(regularPaymentDue1, sregularPaymentDuecal);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		softassert.assertAll();


	}



	
	@Feature("Amortization")
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
	
	
	
	@Feature("Amortization")
	@Stories(value = { @Story(value = "Amortization")})
	@Description("Verify the undo all the payments request batch number loans")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	
    @Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
	public void undoFunctionality(String loanType_id,String borrower_id,String name,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount,String ref_batch_no,String total_amount,String check_no,String check_amount) throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		
		try {
		
			Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreviewAmt(loanType_id,borrower_id,name,loanNumber,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
			String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
			System.out.println("responseOfPreview is "+responseOfPreview);
		   // int length=response.body().path("list.size()");
			
            Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommitAmt(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
			
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			String batch_date=sdf.format(date);
		//Step to create Batch
			 Response createBatch = callPOSTMethod(token, "batch_data", payloads.getPayloadForCreateBatch(batch_date, ref_batch_no, total_amount),
			 url+"/api/cash-application-v2/v1/batches");
			    Thread.sleep(10000);
				int batch_id = createBatch.then().extract().path("batch_id");
				System.out.println("batch_id is "+batch_id);
				 Integer inbatches= createBatch.then().extract().path("id");
				 String batches= String.valueOf(inbatches);
				 System.out.println("Batch is "+batches);
				
					System.out.println(createBatch.getBody().asString());
					Response get_time=callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
					String principal_due_amount=get_time.jsonPath().get("totalPaymentDue[0]").toString();
					String period=get_time.jsonPath().get("period[0]").toString();
					String interest_due_amount=get_time.jsonPath().get("regularInterest[0]").toString();
					
					String initial_payment_date=get_time.jsonPath().get("termLoan.initialPaymentDate[0]").toString();
					String payment_due_date=get_time.jsonPath().get("termLoan.initialPaymentDate[0]").toString();
					
					Response create_batch_pl=callPUTMethod(token,"batch_data",payloads.termLonDistrubution(batch_date, ref_batch_no, total_amount, borrower_id, check_no, check_amount, loanNumber, loanName, responseOfPreview, initial_payment_date, period, payment_due_date, interest_due_amount, principal_due_amount, total_amount, total_amount),url+"/api/cash-application-v2/v1/batches/"+batches);
					Thread.sleep(10000);
					System.out.println("create_batch_pl "+create_batch_pl.getBody().asString());
					
					// Click on process batch Symbol
					Response batch_processd=callPOSTMethod(token,payloads.processBatch(batches),url+"/api/cash-application-v2/v1/batches/batch_process");
					System.out.println("create_batch_pl is "+batch_processd.getBody().asString());
					

					//Get all batch detail to fetch check ID
					
					Response batchdetail=callGETMethods(token, url+"/api/cash-application-v2/v1/batches/"+batches);
					System.out.println("batchdetail"+batchdetail.asString());
					softassert.assertEquals(batchdetail.statusCode(), STATUS_CODE_200, "this is to get status code og batch detail");
					String checkId=batchdetail.jsonPath().getString("data.checks.data[0].id").toString();
					System.out.println("checkId"+checkId);
					
					//Steps to perform Undo
					Response undobatch=callPOSTMethod(token,payloads.processBatch(checkId),url+"/api/cash-application-v2/v1/batches/undo_batch_process");
					System.out.println("undobatch"+undobatch.asString());
					softassert.assertEquals(undobatch.statusCode(), STATUS_CODE_204, "this is to get status code of batch UNDO");
					
					
		
		   
	        
	 }
		 catch(Exception e) 
        {
			 e.printStackTrace();
        } 
		
		
		
		
		softassert.assertAll();
		
		
		
		   
	}
		
		
		
		
		
		
		
		
	    @Feature("Amortization")
		@Stories(value = { @Story(value = "Amortization")})
		@Description("Verify the functionality of undo batch")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
		public void undo(String loanType_id,String borrower_id,String name,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount,String ref_batch_no,String total_amount,String check_no,String check_amount) throws FileNotFoundException, IOException, ParseException, InterruptedException {
			SoftAssert softassert = new SoftAssert();
			
			try {
			
			
				Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreviewAmt(loanType_id,borrower_id,name,loanNumber,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				System.out.println("responseOfPreview is "+responseOfPreview);
			   // int length=response.body().path("list.size()");
				
	            Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommitAmt(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				System.out.println(response1.getStatusCode());
				softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
				
				SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				String batch_date=sdf.format(date);
			//Step to create Batch
				 Response createBatch = callPOSTMethod(token, "batch_data", payloads.getPayloadForCreateBatch(batch_date, ref_batch_no, total_amount),
				 url+"/api/cash-application-v2/v1/batches");
				    Thread.sleep(10000);
					int batch_id = createBatch.then().extract().path("batch_id");
					System.out.println("batch_id is "+batch_id);
					 Integer inbatches= createBatch.then().extract().path("id");
					 String batches= String.valueOf(inbatches);
					 System.out.println("Batch is "+batches);
					
						System.out.println(createBatch.getBody().asString());
						Response get_time=callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
						String principal_due_amount=get_time.jsonPath().get("totalPaymentDue[0]").toString();
						String period=get_time.jsonPath().get("period[0]").toString();
						String interest_due_amount=get_time.jsonPath().get("regularInterest[0]").toString();
						
						String initial_payment_date=get_time.jsonPath().get("termLoan.initialPaymentDate[0]").toString();
						String payment_due_date=get_time.jsonPath().get("termLoan.initialPaymentDate[0]").toString();
						
						Response create_batch_pl=callPUTMethod(token,"batch_data",payloads.termLonDistrubution(batch_date, ref_batch_no, total_amount, borrower_id, check_no, check_amount, loanNumber, loanName, responseOfPreview, initial_payment_date, period, payment_due_date, interest_due_amount, principal_due_amount, total_amount, total_amount),url+"/api/cash-application-v2/v1/batches/"+batches);
						Thread.sleep(10000);
						System.out.println("create_batch_pl "+create_batch_pl.getBody().asString());
						
						// Click on process batch Symbol
						Response batch_processd=callPOSTMethod(token,payloads.processBatch(batches),url+"/api/cash-application-v2/v1/batches/batch_process");
						System.out.println("create_batch_pl is "+batch_processd.getBody().asString());
						

						//Get all batch detail to fetch check ID
						
						Response batchdetail=callGETMethods(token, url+"/api/cash-application-v2/v1/batches/"+batches);
						System.out.println("batchdetail"+batchdetail.asString());
						softassert.assertEquals(batchdetail.statusCode(), STATUS_CODE_200, "this is to get status code og batch detail");
						String checkId=batchdetail.jsonPath().getString("data.checks.data[0].id").toString();
						String batch_no=batchdetail.jsonPath().getString("data.batch_no").toString();
						System.out.println("batch_no is "+batch_no);
						//System.out.println("checkId"+arraylist);
						
						Response deleteresponse = callDELETEMethodWithQuery(token,url+"/api/v1/amortization-schedule/undo-payments","batchNumber",batch_no,"chequeIds",Arrays.asList(checkId));
						System.out.println(deleteresponse.getStatusCode());
						System.out.println(deleteresponse.getBody().asString());
		
					 }
			 catch(Exception e) 
	        {
				 e.printStackTrace();
	        } 
				
		
		

}
	    @Feature("Verify and validate the disbursement")
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
			    System.out.println("status code "+response1.getStatusCode());
				softassert.assertEquals(STATUS_CODE_201, response1.getStatusCode());
				
				Double Interest = Double.valueOf(interestRate);
				Integer term = Integer.valueOf(terms);
				Double rate= (Interest/100)/term;
				Double double_divisor = Double.valueOf(divisor);
				
				 for(int i=0;i<length;i++) {
				    	//response.jsonPath().get("openingBalance["+i+"]").toString()
				    	String str=response.jsonPath().get("openingBalance["+i+"]").toString();
				    	Double openingBalance = Double.valueOf(str);
				    	String str4=response.jsonPath().get("period["+i+"]").toString();
				    	Integer currentPeriod = Integer.valueOf(str4);
				    	//System.out.println("openingBalance is "+openingBalance);
				    	Double Interestcal=openingBalance*(Interest/double_divisor)/100;
				    	double Interestcal1 = DecimalFormater.covertodecimal(Interestcal);
				    	double regularPaymentDueCal=TermLoanCalculation.calculateRegularPaymentDue(openingBalance, rate, term,currentPeriod);
				    	double regularPaymentDueCal1 = DecimalFormater.covertodecimal(regularPaymentDueCal);
				    	//System.out.println("regularPaymentDueCal1 is "+regularPaymentDueCal1);
				    	//System.out.println("Interestcal is "+Interestcal1);
				    	double regularPrincipal12=regularPaymentDueCal1-Interestcal1;
				    	double regularPrincipal13 = DecimalFormater.covertodecimal(regularPrincipal12);
				    	System.out.println("regularPrincipal12 is "+regularPrincipal13);
				    }
			     
			    Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());

				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	   
	    @Feature("Amortization")
		@Stories(value = { @Story(value = "TERM LOAN SETUP")})
		@Description("This is a test case which verifies the status code: creation of Term loan with positive data")
		@Step("Creation of Term loan with Positive details")
		@Severity(SeverityLevel.BLOCKER)
		//@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	    public void editPaymentDue(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
	    	
	    	SoftAssert softassert = new SoftAssert();
	    	try {
				
	    		Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
				String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
				
				
				
				String loanNumber=response.jsonPath().getList("termLoan.loanNumber").get(0).toString();
				Response response1 = callPOSTMethodWithQuery(token,payloads.masterTermLoanCommit(responseOfPreview, loanType_id, borrower_id, name, loanNumber,loanName, principalAmount, disbursementDate, initialPaymentDate, termType_id, value, display, terms, originationDate, maturityDate, interestRate, divisor, interestRateType, interestRateCode, rateAdjustment, amortizationType, fixedPrincipal,loanStatus_id, disbursementAmount),url3+"/api/v1/term-loans/commit","clientId",borrower_id);
				
				Response response2=callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
				
				String amortizationScheduleId=response2.jsonPath().getString("id[3]");
				String paymentDate=response2.jsonPath().getString("paymentDate[3]");
				String openingBalance=response2.jsonPath().getString("openingBalance[3]");
				String regularInterest=response2.jsonPath().getString("regularInterest[3]");
				String regularPrincipal=response2.jsonPath().getString("regularPrincipal[3]");
				//String regularPaymentDue=response.jsonPath().getString("regularPaymentDue[3]");
				//String regularPaymentDue="1000";
				String totalPaymentDue=response2.jsonPath().getString("totalPaymentDue[3]");
				String endingBalance=response2.jsonPath().getString("endingBalance[3]");
				String balanceDue=response2.jsonPath().getString("balanceDue[3]");
				String period=response2.jsonPath().getString("period[3]");
				String periodStartDate=response2.jsonPath().getString("periodStartDate[3]");
				String periodEndDate=response2.jsonPath().getString("periodEndDate[3]");
				String totalInterest=response2.jsonPath().getString("termLoan.totalInterest[3]");
				String revisedInterestRateEffectiveDate=response2.jsonPath().getString("termLoan.revisedInterestRateEffectiveDate[3]");
				
				String soFarDisbursement=response2.jsonPath().getString("termLoan.soFarDisbursement[3]");
				String balanceDisbursement=response2.jsonPath().getString("termLoan.balanceDisbursement[3]");
				
				Response response3=callPUTMethodWithQuaryParameter(token,"amortizationScheduleId",amortizationScheduleId,payloads.editAmtpayload(amortizationScheduleId, period, interestRateCode, paymentDate, openingBalance, regularInterest, regularPrincipal, regularInterest, totalPaymentDue, endingBalance, balanceDue, responseOfPreview, loanNumber, loanName, loanType_id, principalAmount, totalInterest, rateAdjustment, revisedInterestRateEffectiveDate, interestRateType, interestRateCode, divisor, termType_id, value, display, terms, originationDate, disbursementDate, maturityDate, initialPaymentDate, loanStatus_id, soFarDisbursement, balanceDisbursement, disbursementAmount, periodStartDate, periodEndDate),url3+"/api/v1/amortization-schedule/update-regular-due");
				System.out.println(response3.getStatusCode());
			
				Response response4=callGETMethod(token,"termLoanId",responseOfPreview,url3+"/api/v1/amortization-schedule");
				String regularPrincipal1=response4.jsonPath().getString("regularPrincipal[3]");
				Double dregularPrincipal = Double.valueOf(regularPrincipal1);
				softassert.assertEquals(dregularPrincipal,0.0);
				Double Interest = Double.valueOf(interestRate);
				Integer term = Integer.valueOf(terms);
				Double rate= (Interest/100)/term;
				Double dendingBalance = Double.valueOf(endingBalance);
				Double dregularInterest = Double.valueOf(regularInterest);
				double calc=dregularPrincipal-dregularInterest;
				double expect_dendingBalance=dendingBalance+calc;
				
				String endingBalance4=response4.jsonPath().getString("endingBalance[3]");
				
				Double dendingBalance4 = Double.valueOf(endingBalance4);
				softassert.assertEquals(expect_dendingBalance, dendingBalance4);
				
				
				
				Response deleteresponse = callDELETEMethod(token,payloads.payloadforDeleteLoan(responseOfPreview),url3+"/api/v1/term-loans");
				softassert.assertEquals(STATUS_CODE_204, deleteresponse.getStatusCode());
				
				System.out.println(response1.getStatusCode());
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	    	softassert.assertAll();
	    }
	    

	    }
	
	

	

