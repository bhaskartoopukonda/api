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

public class TermLoanDisburnsmentDate extends AbstractRestAssuredResponse {
	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader();
	

	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	
	static String originationDate;
	static String initialPaymentDate;
	static String maturityDate;
	static String disbursementDate;
	static String dumm;
	
	@Feature("TERM lOAN DISBURNSMNET DATE FOR NEGATIVE DATE")
	@Stories(value = { @Story(value = "Term laon Disburnsment date for Negative Date") })
	@Description("This is a test case which verifies the status code when  Disburnsment date for Negative values")
	@Step("verifies Disburnsment date for Negative Data")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void termLoanDisburnsmentNegative(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String termType_id,String value,String display,String terms,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
	
	try {
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();	   
		String initialPaymentDate=sdf.format(date);
		
		System.out.println("initialPaymentDate"+initialPaymentDate);
		
		Date date2 = GetDate.addMonth(date, -1);
		String originationDate=sdf.format(date2);
		System.out.println("originationDate"+originationDate);
		
		//String disbursementDate=sdf.format(date2);
		//System.out.println("disbursementDate"+disbursementDate);
		
		int iterm= Integer.parseInt(terms);
		Date date3 = GetDate.addDay(date2,iterm);
		String maturityDate = sdf.format(date3);
		System.out.println("maturityDate"+maturityDate);
		Response response = callPOSTMethodWithQuery(token,payloads.masterTermloanPreview(loanType_id,borrower_id,name,loanName,principalAmount,disbursementDate,initialPaymentDate,termType_id,value,display,terms,originationDate,maturityDate,interestRate,divisor,interestRateType,interestRateCode,rateAdjustment,amortizationType,fixedPrincipal,loanStatus_id,disbursementAmount),url3+"/api/v1/term-loans/preview","clientId",borrower_id);
		//String responseOfPreview=response.jsonPath().getList("termLoan.id").get(0).toString(); 
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		softassert.assertEquals(response.getStatusCode(), STATUS_CODE_400);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	softassert.assertAll();
	
	}
	@Feature("TERM lOAN DISBURNSMNET DATE FOR NEGATIVE DATE")
	@Stories(value = { @Story(value = "Term laon Disburnsment date for Negative Date") })
	@Description("This is a test case which verifies the status code when  Disburnsment date for Negative values")
	@Step("verifies Disburnsment date for Negative Data")
	@Severity(SeverityLevel.BLOCKER)
	//@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void verifyDisburseDate(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String termType_id,String value,String display,String terms,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
		SoftAssert softassert = new SoftAssert();

		int iterm= Integer.parseInt(terms);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();	   
			originationDate=sdf.format(date);
			System.out.println("originationDate"+originationDate);
			
			if(value.equalsIgnoreCase("months")) {
				Date date1 = GetDate.addMonth(date, 1);
				initialPaymentDate=sdf.format(date1);
				System.out.println("initialPaymentDate is"+initialPaymentDate);
				Date date2=GetDate.addMonth(date, iterm);
				maturityDate=sdf.format(date2);
				System.out.println("maturityDate is"+maturityDate);
			}else {
				if(value.equalsIgnoreCase("days")) {
					Date date1 = GetDate.addDay(date, 1);
					initialPaymentDate=sdf.format(date1);
					System.out.println("initialPaymentDate is"+initialPaymentDate);
					Date date2=GetDate.addDay(date, iterm);
					maturityDate=sdf.format(date2);
					System.out.println("maturityDate is"+maturityDate);
				}else {
					if(value.equalsIgnoreCase("weeks")) {
						Date date1 = GetDate.addWeek(date, 7);
						initialPaymentDate=sdf.format(date1);
						System.out.println("initialPaymentDate is"+initialPaymentDate);
						Date date2=GetDate.addWeek(date, iterm*7);
						maturityDate=sdf.format(date2);
						System.out.println("maturityDate is"+maturityDate);
					}
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
	}
}
