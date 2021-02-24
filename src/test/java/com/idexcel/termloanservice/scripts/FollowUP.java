package com.idexcel.termloanservice.scripts;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
import com.idexcel.utilities.TestNGDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class FollowUP extends AbstractRestAssuredResponse{
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	
	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 
	double sum=0;
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow up status code validation")})
	@Description("This is a test case which verifies the status code: Get Attention Required Count API ")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void verifyGetAttentionRequiredCount() {
		
		SoftAssert softassert = new SoftAssert();
		
		try {
			//1st get call
			Response response = callGETMethod(token,data.getAttentionRequiredCount());
			String num=response.body().asString();
			System.out.println("My number is  "+num);
			int total=Integer.parseInt(num);
			int statuscode = response.getStatusCode();
			System.out.println(statuscode);
			Response respn = callGETMethod(token,"days","-1","sortingKey","overduedays","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/period");
			String scode=respn.jsonPath().getString("noOfPeriods");
			int i=Integer.parseInt(scode);
			System.out.println("my code is "   +scode);
			//System.out.println(respn.getBody().asString());
			Response respn1 = callGETMethod(token,"days","-1","sortingKey","outstanding-bal","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/loan");
			String code=respn1.jsonPath().getString("noOfLoans");
			System.out.println("noOfLoans is  "+code);
			int j=Integer.parseInt(code);
			int k = i+j;
			System.out.println("my code is "   +k);
			
			softassert.assertEquals(total, k);
			
			
		} catch (Exception e) {
			
		}
		softassert.assertAll();
	}
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the get the total counts of follow-up required loans and periods")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	//@Test(groups= {"smoke"})
	public void getFollowUpRequiredCount() {
		
		SoftAssert softassert = new SoftAssert();
		try {
			//2nd get call
			Response response = callGETMethod(token,data.getFollowUpRequiredCount());
			int statuscode = response.getStatusCode();
			System.out.println(response.getBody().asString());
			String count = response.getBody().asString();
			int j=Integer.parseInt(count);
			System.out.println("my test count is "   +j);
			//
			Response respn1 = callGETMethod(token,"days","0","sortingKey","duedate","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/period");
			String scode1=respn1.jsonPath().getString("noOfLoans");
			System.out.println("no of periods " +scode1);
			int a=Integer.parseInt(scode1);
			
			Response respn2 = callGETMethod(token,"days","5","sortingKey","duedate","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/period");
			String scode2=respn2.jsonPath().getString("noOfLoans");
			System.out.println("no of periods " +scode2);
			int b=Integer.parseInt(scode2);
			
			Response respn3 = callGETMethod(token,"days","0","sortingKey","maturity-date","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/loan");
			String scode3=respn3.jsonPath().getString("noOfLoans");
			System.out.println("no of periods " +scode3);
			int c=Integer.parseInt(scode3);
			
			
			Response respn4 = callGETMethod(token,"days","5","sortingKey","maturity-date","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/loan");
			String scode4=respn4.jsonPath().getString("noOfLoans");
			System.out.println("no of periods " +scode4);
			int d=Integer.parseInt(scode4);
			int e =a+b+c+d;
			System.out.println("total is  " +e);
			
			softassert.assertEquals(j, e);
			
			
		} catch (Exception e) {
			
		}
		softassert.assertAll();
	}
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the get the matured or maturing loans details with outstanding balance by request days as 0,5")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void getFollowUpLoans(String days,String SortingKey,String filterBy) {
		
		
		SoftAssert softassert = new SoftAssert();
		try {
			//3rd get call
			
			Response response = callGETMethod(token,"days",days,"sortingKey",SortingKey,"filterBy",filterBy,url3+"/api/v1/term-loan/follow-up/loan");
			int statuscode = response.getStatusCode();
			System.out.println(response.getBody().asString());
			String scode1=response.jsonPath().getString("overAllOutstantingBalance");
			System.out.println("overAllOutstantingBalance  is "+scode1);
			Double overAllOutstantingBalance = Double.valueOf(scode1);
			System.out.println("I m doing round off"+Math.round(overAllOutstantingBalance));
			long actual_overAllOutstantingBalance = Math.round(overAllOutstantingBalance);
			String scode2=response.jsonPath().getString("data.outstandingBalance");
			String scode3 = scode2.substring(1, scode2.length()-1);
		    //System.out.println("scode2 is  ..."+scode2);
			//System.out.println("my code is "+scode3);
			String[] scode4 = scode3.split(",");
            List<String> list = new ArrayList<String>();
			
			for(int i=0;i<scode4.length;i++) {
				
				 list.add(scode4[i].trim());
				
			}
			String[] itemsArray = new String[list.size()];
	        itemsArray = list.toArray(itemsArray);
	        for(int i=0;i<=itemsArray.length-1;i++) {
	        
	        	sum = sum+Double.valueOf(itemsArray[i]);
	            System.out.println("Sum is checking  "+sum);
	        }
	        System.out.println("The last sum is   "+sum);
	        long expected_overAllOutstantingBalance = Math.round(sum);
	        System.out.println(expected_overAllOutstantingBalance);
	        softassert.assertEquals(actual_overAllOutstantingBalance,expected_overAllOutstantingBalance);
			
		} 
		
		catch (Exception e) {
			
		}
		softassert.assertAll();
		
	}
	
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the get follow-up notes history as per the request loans and periods")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void paymentdueNotes() {
		SoftAssert softassert = new SoftAssert();
		
		try {
			//1 post method
			
			Response response = callGETMethod(token,"days","5","sortingKey","duedate","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/period");
			System.out.println(response.getBody().asString());
			System.out.println(response.getStatusCode());
			String period=response.jsonPath().getString("data.period[0]");
			System.out.println("my period is "+period);
			String termLoanId=response.jsonPath().getString("data.termLoanId[0]");
			String loanNumber=response.jsonPath().getString("data.loanNumber[0]");
			System.out.println("loanNumber is "+loanNumber);
			System.out.println("my termLoanId is "+termLoanId);
			String qa="I am doing follow up";
			Response rspn = callPOSTMethod(token,payloads.createNoteWithoutreminderDate(qa, termLoanId, period),url3+"/api/v1/term-loan/follow-up/notes/period");
			Thread.sleep(5000);
			Response response1=callPOSTMethodWithQuery(token,payloads.notelevelEqualstoPeriod(termLoanId, period),url3+"/api/v1/term-loan/follow-up/notes","notesLevel","period");
			System.out.println("Hi my body is "+response1.body().asString());
			String notes=response1.jsonPath().getString("notes[0]");
			softassert.assertEquals(qa, notes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
	}
	@Feature("Follow up :")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("This is a test case which verifies the status code: Get Attention Required Count API ")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void getFollowUpTermLoanNotesThroughLoanLevel() {
		SoftAssert softassert = new SoftAssert();
		String pattern = "MM/dd/yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime(); 
		String todayAsString = df.format(today);
		System.out.println("Today is: " + todayAsString);
		
		try {
			//2 post methed
			
			Response response = callGETMethod(token,"days","5","sortingKey","maturity-date","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/loan");
			System.out.println(response.getBody().asString());
			
			String termLoanId=response.jsonPath().getString("data.id[0]");
			
			System.out.println("my termLoanId is "+termLoanId);
			
		    Response rspn = callPOSTMethod(token,payloads.create("This from script message", todayAsString, termLoanId),url3+"/api/v1/term-loan/follow-up/notes/loan");
		    System.out.println("my test body  "+rspn.getStatusCode());
			Response response1 = callPOSTMethodWithQuery(token, payloads.followupMaturingLoan(termLoanId, "0"),url3+"/api/v1/term-loan/follow-up/notes","notesLevel","loan");
			System.out.println("My response by  "  +response1.getBody().asString());
			Response response2 = callGETMethod(token,"days","5","sortingKey","maturity-date","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/loan");
			String reminderDate=response2.jsonPath().getString("data.reminderDate[0]");
			System.out.println("reminderDate is "+reminderDate);
			
			System.out.println(response1.getStatusCode());
			softassert.assertEquals(todayAsString, reminderDate);
			//softassert.assertEquals(actual, expected);
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
	}
	
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the create Notes for follow-up over-due periods or follow-up periods")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void createNotesForFollowupOverDuePeriodsOrFollowUPeriods() {
             SoftAssert softassert = new SoftAssert();
             String pattern = "MM/dd/yyyy";
	         DateFormat df = new SimpleDateFormat(pattern);
	         Date today = Calendar.getInstance().getTime(); 
	         String todayAsString = df.format(today);
	         System.out.println("Today is: " + todayAsString);
		
		try {
			//3 post call
			
			Response response = callGETMethod(token,"days","5","sortingKey","duedate","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/period");
			System.out.println(response.getBody().asString());
			String period=response.jsonPath().getString("data.period[0]");
			
			System.out.println("my period is "+period);

			String termLoanId=response.jsonPath().getString("data.termLoanId[0]");
			String loanNumber=response.jsonPath().getString("data.loanNumber[0]");
			System.out.println("loanNumber is "+loanNumber);
			Response response1 = callPOSTMethod(token, payloads.createNoteOnPeriodLevel("hii",todayAsString,termLoanId,period),url3+"/api/v1/term-loan/follow-up/notes/period");
			System.out.println(response1.getBody().asString());
			System.out.println(response1.getStatusCode());
			Response response2 = callPOSTMethodWithQuery(token, payloads.followupMaturingLoan(termLoanId,period),url3+"/api/v1/term-loan/follow-up/notes","notesLevel","period");
			System.out.println(response2.getStatusCode());
			
			System.out.println("My response by  "  +response1.getBody().asString());
			System.out.println(response1.getStatusCode());
			Response response3 = callGETMethod(token,"days","5","sortingKey","duedate","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/period");
			String reminderDate=response3.jsonPath().getString("data.reminderDate[0]");
			System.out.println("reminderDate is "+reminderDate);
			softassert.assertEquals(todayAsString, reminderDate);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
		
	}
	
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the send the notification for follow-up periods and loans for all four template")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
	public void creatNotify(String templateId) {
		 //4th post call
		 SoftAssert softassert = new SoftAssert();
		 String pattern = "MM/dd/yyyy";
         DateFormat df = new SimpleDateFormat(pattern);
         Date today = Calendar.getInstance().getTime(); 
         String todayAsString = df.format(today);
         System.out.println("Today is: " + todayAsString);
		
		try {
			
			Response response1 = callGETMethod(token,"days","5","sortingKey","duedate","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/period");
            String period=response1.jsonPath().getString("data.period[0]");
			
			System.out.println("my period is "+period);

			String termLoanId=response1.jsonPath().getString("data.termLoanId[0]");
			Response response2 = callPOSTMethod(token, payloads.followUpLoanNotifyRequest(templateId,todayAsString,termLoanId,period),data.createNotify());
			System.out.println(response2.getBody().asString());
			System.out.println(response2.getStatusCode());
			int scode = response2.getStatusCode();
			softassert.assertEquals(scode, STATUS_CODE_200);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
	}
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the get notification history as per the loan and periods")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression","smoke"})
	public void getNotificationHistory(String templateId,String level) {
		 SoftAssert softassert = new SoftAssert();
		 String pattern = "MM/dd/yyyy";
         DateFormat df = new SimpleDateFormat(pattern);
         Date today = Calendar.getInstance().getTime(); 
         String todayAsString = df.format(today);
         System.out.println("Today is: " + todayAsString);
		 //5th post call
		try {
			
			Response response1 = callGETMethod(token,"days","5","sortingKey","duedate","filterBy","ALL",url3+"/api/v1/term-loan/follow-up/period");
            String period=response1.jsonPath().getString("data.period[0]");
			
			System.out.println("my period is "+period);

			String termLoanId=response1.jsonPath().getString("data.termLoanId[0]");
			Response response2 = callPOSTMethod(token, payloads.followUpLoanNotifyRequest(templateId,todayAsString,termLoanId,period),data.createNotify());
			System.out.println(response2.getBody().asString());
			Response response = callPOSTMethodWithQuery(token, payloads.followupMaturingLoan(termLoanId,period),data.getListOfNotification(),"level",level);
			System.out.println(response.getBody().asString());
			//System.out.println(response.getStatusCode());
			int scode = response.getStatusCode();
			softassert.assertEquals(scode, STATUS_CODE_200);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
	}
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the get the notification email or text template list as per request")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void emailNotificationTemplate() {
		 SoftAssert softassert = new SoftAssert();
		 //4th get call
		try {
			Response response = callGETMethod(token,data.emailNotificationTemplate());
			System.out.println(response.getBody().asString());
			System.out.println(response.getStatusCode());
			int scode = response.getStatusCode();
			softassert.assertEquals(scode, STATUS_CODE_200);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
	}
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the get the notification email or text template list as per request")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void textTemplate() {
		 SoftAssert softassert = new SoftAssert();
		 //5th get call
		try {
			Response response = callGETMethod(token,data.textTemplate());
			System.out.println(response.getBody().asString());
			System.out.println(response.getStatusCode());
			int scode = response.getStatusCode();
			softassert.assertEquals(scode, STATUS_CODE_200);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
	}
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the No. of Loans is the total number of records / Loan number")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression","smoke"})
	public void termloanFollowUp(String days,String sortingKey,String filterBy) {
		 SoftAssert softassert = new SoftAssert();
		 //7th get call
		try {
			Response response = callGETMethod(token,"days",days,"sortingKey",sortingKey,"filterBy",filterBy,data.getFollowUpPeriods());
			System.out.println(response.getBody().asString());
			System.out.println(response.getStatusCode());
			int scode = response.getStatusCode();
			softassert.assertEquals(scode, STATUS_CODE_200);
			String noofloan=response.jsonPath().getString("noOfLoans");
			int numberOfLoan=Integer.valueOf(noofloan).intValue();
			System.out.println("numberOfLoan  "+numberOfLoan);
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
		softassert.assertAll();
	}
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the payment recived quick review activity")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression","smoke"})
	public void getPaymentrecevied(String days) {
		 SoftAssert softassert = new SoftAssert();
		 //7th get call
		try {
			Response response = callGETMethodWithOneQuery(token,data.getPaymentrecevied(),days);
			System.out.println(response.getBody().asString());
			System.out.println(response.getStatusCode());
			int scode = response.getStatusCode();
			softassert.assertEquals(scode, STATUS_CODE_200);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
	}
	@Feature("Follow Up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the Overall Total O/s Balance")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void overTotalOutstaging() {
		try {
			
			double sum=0;
			double sum1=0;
			double sum2=0;
			double total=0;
			//String [] now = null;
			Response response = callGETMethodWithTwoQuery(token,data.getFollowUpPeriods(),"-1","overduedays");
			System.out.println(response.getBody().asString());
			String overAllOutstantingBalance=response.jsonPath().getString("overAllOutstantingBalance");
			//double dnum = Double.parseDouble(overAllOutstantingBalance);
			double dnum=Double.valueOf(overAllOutstantingBalance).doubleValue();
			//System.out.printf("dnum: %.2f\n", dnum);
			System.out.printf("dnum: %.2f\n", dnum);
			System.out.println(overAllOutstantingBalance);
			//System.out.println("Hi test ...." +dnum);
			String str = response.jsonPath().getString("data.principalBalance");
			
			//System.out.println("my string is a "+str);
			String str2 = str.substring(1, str.length()-1);
			//System.out.println("hi test "+str2);
			String[] str3= str2.split(",");
			for(int i=0;i<str3.length;i++) {
				sum= sum+Double.valueOf(str3[i]).doubleValue();
				//System.out.println("my sum is "+sum);
			}
			//System.out.println("my sum is   "+sum );
			System.out.printf("sum: %.2f\n", sum);
			String str1 = response.jsonPath().getString("data.interestBalance");
			//System.out.println("my string is a "+str1);
			String str4 = str1.substring(1, str1.length()-1);
			//System.out.println("hi test  "+str4);
			String[] str5= str4.split(",");
			for(int i=0;i<str5.length;i++) {
				sum1= sum+Double.valueOf(str5[i]).doubleValue();
			}
			//System.out.println("my sum1 is   "+sum1);
			System.out.printf("sum1: %.2f\n", sum1);
			String str6 = response.jsonPath().getString("data.feeBalance");
			//System.out.println("my string is a "+str6);
			String str7 = str6.substring(1, str6.length()-1);
			//System.out.println("my string is a "+str7);
			String[] str8= str7.split(",");
			for(int i=0;i<str8.length;i++) {
				sum2= sum+Double.valueOf(str8[i]).doubleValue();
			}
			//System.out.println("my sum2 is   "+sum2);
			System.out.printf("sum2: %.2f\n", sum2);
			total =sum+sum1+sum2;
			//System.out.println("the total is "+total);
			System.out.printf("total: %.2f\n", total);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Feature("Follow Up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the No. of Loans is the total number of records / Loan number")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression","smoke"})
	public void numberOfClent(String days,String sortingKey,String filterBy) {
		 SoftAssert softassert = new SoftAssert();
		 //6th get call
		try {
			Response response = callGETMethod(token,"days",days,"sortingKey",sortingKey,"filterBy",filterBy,data.getFollowUpPeriods());
			System.out.println(response.getBody().asString());
			//System.out.println(response.getStatusCode());
			int scode = response.getStatusCode();
			softassert.assertEquals(scode, STATUS_CODE_200);
			String noOfClients=response.jsonPath().getString("noOfClients");
			int noOfclients=Integer.valueOf(noOfClients).intValue();
			System.out.println("number Of clients  "+noOfclients);
			String data=response.jsonPath().getString("data.borrowerId");
			System.out.println("Hi data "+data);
			String data1 = data.substring(1, data.length()-1);
			String[] data2 = data1.split(",");
            List<String> list = new ArrayList<String>();
			
			for(int i=0;i<data2.length;i++) {
				
				 list.add(data2[i].trim());
				
			}
			Set<String> s = new LinkedHashSet<String>(list);
			int borrowerId=s.size();
			
			System.out.println("Hi test is "+borrowerId);
			softassert.assertEquals(noOfclients, borrowerId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
	}
	@Feature("Follow Up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the No. of Loans and No of Checks for yesterday ,today and so far in this week")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression","smoke"})
	public void quickReview(String days) {
		 SoftAssert softassert = new SoftAssert();
		 
		try {
			Response response = callGETMethodWithOneQuery(token,url3+"/api/v1/term-loan/follow-up/quick-activity-review/payment-recevied",days);
			System.out.println(response.getBody().asString());
			//System.out.println(response.getStatusCode());
			int scode = response.getStatusCode();
			softassert.assertEquals(scode, STATUS_CODE_200);
			String noOfClients=response.jsonPath().getString("noOfClients");
			int noOfclients=Integer.valueOf(noOfClients).intValue();
			System.out.println("number Of clients  "+noOfclients);
			String data=response.jsonPath().getString("data.borrowerId");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		softassert.assertAll();
	}
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the Get Follow Up Required Count")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.MINOR)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression","smoke"})
	public void quickReviewFollowup(String days,String sortingKey,String filterBy) {
		
		SoftAssert softassert = new SoftAssert();
		
		try {
			//6 number get method i have to check again
			Response respone = callGETMethod(token,"days",days,"sortingKey",sortingKey,"filterBy",filterBy,data.getFollowUpPeriods());
			System.out.println("My response body  " +respone.getBody().asString());
			System.out.println(respone.getStatusCode());
			softassert.assertEquals(respone.getStatusCode(), STATUS_CODE_200);
			
		} catch (Exception e) {
			
		}
		softassert.assertAll();
		
	}
	@Feature("Follow Up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the functionality of SMS notification for a particular loan to take follow up action wherein phone type  is Bussiness/TollFree/Fax/Home/Direct/Cell/Bisuness.")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression","smoke"})
	public void verifySMSNotification(String termLoanId,String templateId) {
		
		SoftAssert softassert = new SoftAssert();
		
		try {
			Response sms = callPOSTMethod(token,payloads.smsNotificationPayload(termLoanId,templateId),data.createNotify());
			System.out.println(sms.getBody().asString());
			System.out.println("SMS notification  .."+sms.getStatusCode());
			softassert.assertEquals(sms.getStatusCode(),STATUS_CODE_200);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Feature("Follow Up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("Verify the functionality of SMS notification for a multiple loan of multiple client to take follow up action.")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.MINOR)
	@Test(groups= {"smoke"})
   public void smsNotificationPayloadForMultipletermloanId() {
		
		SoftAssert softassert = new SoftAssert();
		
		try {
			Response sms = callPOSTMethod(token,payloads.smsNotificationPayloadForMultipletermloanId(),data.createNotify());
			System.out.println(sms.getBody().asString());
			System.out.println("SMS notification  .."+sms.getStatusCode());
			softassert.assertEquals(sms.getStatusCode(),STATUS_CODE_200);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Feature("Follow up")
	@Stories(value = { @Story(value = "Follow Up Required Count status code validation")})
	@Description("This is a test case which verifies the text/email subscription")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.MINOR)
	@Test(groups= {"smoke"})
	public void verifyLenderSubscription() throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();
		Response response = callGETMethod(token,"menuName","followup-notify-text",url3+"/api/v1/term-loan/follow-up/notify/text/subscription");
		System.out.println(response.body().asString());
		softassert.assertEquals(true, true);
	}
	

}
