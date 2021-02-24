package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.JSONFileReader;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class FollowUpCalculation extends AbstractRestAssuredResponse{
	
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	
	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 
	
	
	@Feature("Verify the Interest Balance = Interest Due - Interest Paid")
	@Stories(value = { @Story(value = "Follow up Interest Balance")})
	@Description("This is a test case which verifies the Interest Balance ")
	@Step("Interest Balance")
	@Severity(SeverityLevel.MINOR)
	@Test(groups= {"smoke"})
	public void calculateInterestBalance() {
		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"-1","overduedays");
			String termLoanId=response.jsonPath().getString("data.termLoanId[0]");
			System.out.println(termLoanId);
			String intb=response.jsonPath().getString("data.interestBalance[0]");
			System.out.println("My interest balance "+intb);
			float interestBalance=Float.valueOf(intb).floatValue();
			Response res = callGETMethodWithQuery(token,  data.getAmortizationApis() ,termLoanId);
			System.out.println(res.getBody().asString());
			String ints=res.jsonPath().getString("regularInterest[0]");
			System.out.println(ints);
			float f1=Float.valueOf(ints).floatValue();
			String ints1=res.jsonPath().getString("totalInterestPayment[0]");
			float f2=Float.valueOf(ints1).floatValue();
			float f3=f1-f2;
			System.out.println("After calculation    "+f3);
			softassert.assertEquals(interestBalance, f3);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Feature("Verify the Fee Balance = Fee Due (Other Fees) - Fee Paid")
	@Stories(value = { @Story(value = "Follow up Fee Balance validation")})
	@Description("This is a test case which verifies the Fee Balance")
	@Step("Fee Balance")
	@Severity(SeverityLevel.MINOR)
	@Test(groups= {"smoke"})
	public void calculateFeeBalence() {
		
		SoftAssert softassert = new SoftAssert();
		
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"-1","overduedays");
			String termLoanId=response.jsonPath().getString("data.termLoanId[0]");
			System.out.println(termLoanId);
			String intb=response.jsonPath().getString("data.feeBalance[0]");
			float feeBalance=Float.valueOf(intb).floatValue();
			System.out.println("feeBalance is "+feeBalance);
			Response res = callGETMethodWithQuery(token,  data.getAmortizationApis() ,termLoanId);
			String ints=res.jsonPath().getString("fee[0]");
			float f1=Float.valueOf(ints).floatValue();
			String ints1=res.jsonPath().getString("totalFeePayment[0]");
			float f2=Float.valueOf(ints1).floatValue();
			float f3=f1-f2;
			softassert.assertEquals(feeBalance, f3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Feature("Verify the Principal Balance = (the Principal Due - Principal Paid of the overdue period)")
	@Stories(value = { @Story(value = "Follow up Principal Balance")})
	@Description("This is a test case which verifies the Principal Balance")
	@Step("the Principal Due - Principal Paid of the overdue period")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void principalBalance() {
		 
		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"-1","overduedays");
			String termLoanId=response.jsonPath().getString("data.termLoanId[0]");
			System.out.println(termLoanId);
			String intb=response.jsonPath().getString("data.principalBalance[0]");
			float principalBalance=Float.valueOf(intb).floatValue();
			System.out.println("principalBalance is "+principalBalance);
			Response res = callGETMethodWithQuery(token,  data.getAmortizationApis() ,termLoanId);
			String ints=res.jsonPath().getString("totalPaymentDue[0]");
			System.out.println(ints);
			float f1=Float.valueOf(ints).floatValue();
			String ints1=res.jsonPath().getString("totalPaymentDone[0]");
			System.out.println(ints1);
			float f2=Float.valueOf(ints1).floatValue();
			float f3=f1-f2;
			softassert.assertEquals(principalBalance, f3);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Feature("Verify the functionality of sort by client ")
	@Stories(value = { @Story(value = "Follow up status code validation")})
	@Description("This is a test case which verifies the status code: Get Attention Required Count API ")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void sortbyClient() {
		SoftAssert softassert = new SoftAssert();
		try {
			Response respn = callGETMethodWithTwoQuery(token,  data.getFollowUpPeriods() ,"-1","clientName");
			String clientName=respn.jsonPath().getString("data.clientName[0]");
			softassert.assertEquals(clientName,"ABH-001");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Feature("Verify the Overall Total O/s Balance is the Sum of outstanding balance of all the records")
	@Stories(value = { @Story(value = "Overall Total O/s Balance")})
	@Description("This is a test case which verifies the Overall Total O/s Balance ")
	@Step("Overall Total O/s Balance")
	@Severity(SeverityLevel.MINOR)
	@Test(groups= {"smoke"})
	public void calculateOutStandingAftermaturity() {
		double sum=0;
		
		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpLoans(),"-1","outstanding-bal");
			System.out.println(response.getBody().asString());
			String overAllOutstantingBalance=response.jsonPath().getString("overAllOutstantingBalance");
			double dnum=Double.valueOf(overAllOutstantingBalance).doubleValue();
			System.out.printf("dnum: %.2f\n", dnum);
			System.out.println("rond of "+Math.round(dnum));
			String outstandingBalance=response.jsonPath().getString("data.outstandingBalance");
			System.out.println(outstandingBalance);
			String outstandingBalance2 = outstandingBalance.substring(1, outstandingBalance.length()-1);
			System.out.println(outstandingBalance2);
			String[] outstandingBalance3= outstandingBalance2.split(",");
			for(int i=0;i<outstandingBalance3.length;i++) {
				sum= sum+Double.valueOf(outstandingBalance3[i]).doubleValue();
				//System.out.println("my sum is "+sum);
			}
			System.out.println("my sum is "+sum);
			System.out.println("outstandingBalance round off  "+Math.round(sum));
			softassert.assertEquals(Math.round(dnum), Math.round(sum));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Feature("Verify the No. of Loans is the total number of records / Loan number")
	@Stories(value = { @Story(value = "No. of Loans is the total number of records / Loan number")})
	@Description("This is a test case which verifies the No. of Loans is the total number of records / Loan number")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.MINOR)
	@Test(groups= {"smoke"})
	public void numberOfLoanInAttentionRequired() {
		
		SoftAssert softassert = new SoftAssert();
		int count=0;
		int j=0;
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"-1","overduedays");
			//System.out.println(response.getBody().asString());
			String noOfLoans=response.jsonPath().getString("noOfLoans");
			System.out.println("Hi test is "+noOfLoans);
			int loans=Integer.valueOf(noOfLoans).intValue();
			String termLoanId=response.jsonPath().getString("data.termLoanId");
			//System.out.println(termLoanId);
			String termLoanId1 = termLoanId.substring(1, termLoanId.length()-1);
			String[] termLoanId2= termLoanId1.split(",");
			
            List<String> list = new ArrayList<String>();
			
			for(int i=0;i<termLoanId2.length;i++) {
				
				 list.add(termLoanId2[i].trim());
				
			}
			Set<String> s = new LinkedHashSet<String>(list);
		
			System.out.println(s.size());
			int numberOfloan=s.size();
			softassert.assertEquals(loans, numberOfloan);

			      
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Feature("Verify the No. of Client is Total number of unique Clients")
	@Stories(value = { @Story(value = "No. of Client is Total number of unique Clients")})
	@Description("This is a test case which verifies the No. of Client is Total number of unique Clients ")
	@Step("No. of Client")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void numberOfClientOverduePeriod() {
		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"-1","overduedays");
			String noOfClients=response.jsonPath().getString("noOfClients");
			System.out.println(noOfClients);
			int noOfclients= Integer.valueOf(noOfClients).intValue();
			String borrowerId=response.jsonPath().getString("data.borrowerId");
			//System.out.println(borrowerId);
			String borrowerId1 = borrowerId.substring(1, borrowerId.length()-1);
			//System.out.println(borrowerId1);
			String[] borrowerId2= borrowerId1.split(",");
			List<String> list = new ArrayList<String>();
			
			for(int i=0;i<borrowerId2.length;i++) {
				
				 list.add(borrowerId2[i].trim());
				
			}
			Set<String> s = new LinkedHashSet<String>(list);
			
			System.out.println(s.size());
			int clients=s.size();
			softassert.assertEquals(noOfclients, clients);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Feature("Verify the Payment Due Loans section under Follow up Required tab")
	@Stories(value = { @Story(value = "No. of Client is Total number of unique Clients")})
	@Description("This is a test case which verifies the No. of Client is Total number of unique Clients ")
	@Step("No. of Client")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void calculateNumberOfloanInFollowup() {
		
		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"0","duedate");
			String noofloan=response.jsonPath().getString("noOfLoans");
			int numberOfLoan=Integer.valueOf(noofloan).intValue();
			System.out.println("Number of Loan"+numberOfLoan);
			String data=response.jsonPath().getString("data.termLoanId");
			System.out.println("Hi data "+data);
			String data1 = data.substring(1, data.length()-1);
			String[] data2 = data1.split(",");
            List<String> list = new ArrayList<String>();
			
			for(int i=0;i<data2.length;i++) {
				
				 list.add(data2[i].trim());
				
			}
			Set<String> s = new LinkedHashSet<String>(list);
			int numberofloan=s.size();
			
			System.out.println("Hi test is "+numberofloan);
			softassert.assertEquals(numberOfLoan, numberofloan);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Feature("Verify the number of period")
	@Stories(value = { @Story(value = "No. of Client is Total number of unique Clients")})
	@Description("This is a test case which verifies the No. of Client is Total number of unique Clients ")
	@Step("No. of Client")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void numberofOverduePeriod() {
		
		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"5","duedate");
			String noOfPeriods=response.jsonPath().getString("noOfPeriods");
			int noOfperiods=Integer.valueOf(noOfPeriods).intValue();
			System.out.println("Number of Loan"+noOfperiods);
			String data=response.jsonPath().getString("data.id");
			System.out.println("Hi data "+data);
			String data1 = data.substring(1, data.length()-1);
			String[] data2 = data1.split(",");
            List<String> list = new ArrayList<String>();
			
			for(int i=0;i<data2.length;i++) {
				
				 list.add(data2[i].trim());
				
			}
			Set<String> s = new LinkedHashSet<String>(list);
			int noofperiod=s.size();
			
			System.out.println("Hi test is "+noofperiod);
			softassert.assertEquals(noOfperiods, noofperiod);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Feature("Verify the card details(Loan Name,Client Name,Maturity Date)")
	@Stories(value = { @Story(value = "No. of Client is Total number of unique Clients")})
	@Description("This is a test case which verifies the No. of Client is Total number of unique Clients ")
	@Step("No. of Client")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void cardDetails() {
		
		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"-1","overduedays");
			
			String data=response.jsonPath().getString("data.clientName");
			String clientName=response.jsonPath().getString("data.clientName[0]");
			System.out.println("clientName is "+clientName);
			System.out.println(data);
			String data1 = data.substring(1, data.length()-1);
			String[] data2 = data1.split(",");
         List<String> list = new ArrayList<String>();
			
			for(int i=0;i<data2.length;i++) {
				
				 list.add(data2[i].trim());
				
			}
			Set<String> s = new LinkedHashSet<String>(list);
			String[] arrayOfString = s 
                    .toArray(new String[0]);
			System.out.println("Client Name is "+arrayOfString[0]);
			String data3=response.jsonPath().getString("data.loanName");
			System.out.println(data3);
			String data4 = data3.substring(1, data3.length()-1);
			String[] data5 = data4.split(",");
			String data6=response.jsonPath().getString("data.loanNumber");
			System.out.println(data6);
			String data7 = data6.substring(1, data6.length()-1);
			String[] data8 = data7.split(",");
			softassert.assertEquals(arrayOfString[0], clientName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	

}
	@Feature("Verify the card details(Loan Name,Client Name,Maturity Date)")
	@Stories(value = { @Story(value = "No. of Client is Total number of unique Clients")})
	@Description("This is a test case which verifies the No. of Client is Total number of unique Clients ")
	@Step("No. of Client")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void cardDetails1() {
		
		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"-1","overduedays");
			
			String data=response.jsonPath().getString("data.loanName");
			String loanName=response.jsonPath().getString("data.loanName[0]");
			System.out.println("clientName is "+loanName);
			System.out.println(data);
			String data1 = data.substring(1, data.length()-1);
			String[] data2 = data1.split(",");
         List<String> list = new ArrayList<String>();
			
			for(int i=0;i<data2.length;i++) {
				
				 list.add(data2[i].trim());
				
			}
			Set<String> s = new LinkedHashSet<String>(list);
			String[] arrayOfString = s 
                    .toArray(new String[0]);
			System.out.println("Client Name is "+arrayOfString[0]);
			
			softassert.assertEquals(arrayOfString[0], loanName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	

}
	@Feature("Verify the card details(Loan Name,Client Name,Maturity Date)")
	@Stories(value = { @Story(value = "No. of Client is Total number of unique Clients")})
	@Description("This is a test case which verifies the No. of Client is Total number of unique Clients ")
	@Step("No. of Client")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void cardDetails2() {
		
		SoftAssert softassert = new SoftAssert();
		try {
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"-1","overduedays");
			
			String data=response.jsonPath().getString("data.loanNumber");
			String loanNumber=response.jsonPath().getString("data.loanNumber[0]");
			System.out.println("clientName is "+loanNumber);
			System.out.println(data);
			String data1 = data.substring(1, data.length()-1);
			String[] data2 = data1.split(",");
         List<String> list = new ArrayList<String>();
			
			for(int i=0;i<data2.length;i++) {
				
				 list.add(data2[i].trim());
				
			}
			Set<String> s = new LinkedHashSet<String>(list);
			String[] arrayOfString = s 
                    .toArray(new String[0]);
			System.out.println("Client Name is "+arrayOfString[0]);
			
			softassert.assertEquals(arrayOfString[0], loanNumber);
		} catch (Exception e) {
			// TODO: handle exception
		}
	

}
	@Feature("Verify the card details(Loan Name,Client Name,Maturity Date)")
	@Stories(value = { @Story(value = "No. of Client is Total number of unique Clients")})
	@Description("This is a test case which verifies the No. of Client is Total number of unique Clients ")
	@Step("No. of Client")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void testqa() throws FileNotFoundException, IOException, ParseException {
		Response response = callGETMethod(token,"days","-1","sortingKey","overduedays","filterBy","HRT",data.getFollowUpPeriods());
		//System.out.println("response is  "+response.getBody().asString());
		String reminderDate= response.jsonPath().get("data[1].reminderDate");
		System.out.println("reminderDate   is  "+reminderDate);
		String lastFollowupDate= response.jsonPath().get("data[1].lastFollowupDate");
		System.out.println("lastFollowupDate is "+lastFollowupDate);
		
		String termLoanId= response.jsonPath().get("data[1].id");
		String period= response.jsonPath().get("data[1].period");
		Response respn = callPOSTMethod(token,payloads.createNoteWithoutreminderDate("Hi test QA API", termLoanId, period),data.createNote());
		Response rspn1=callPOSTMethod(token,payloads.notelevelEqualstoPeriod(termLoanId, period),data.getTermLoanNotes(),"https://stagingtermloan.cyncsoftware.com/api/v1/term-loan/follow-up/notes?notesLevel=period");
	}

	
}
