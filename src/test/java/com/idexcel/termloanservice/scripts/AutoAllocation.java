package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
import io.restassured.response.Response;

public class AutoAllocation  extends AbstractRestAssuredResponse{


	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;


	
	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 

	@Feature("AutoAllocation")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("Verify the autoallocation with valid/invalid payload and valid/invalid loan number")
	@Step("Verify the autoallocation with valid/invalid payload and valid/invalid loan number")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke","regression" })
	public void autoAllocation(String AutoAllocateURI,String batchDate,String clientId,String loanNumber,String allocationAmount,String StatusCode) throws FileNotFoundException, IOException, ParseException {

		SoftAssert softassert = new SoftAssert();
		{
			
Response autoAllocate=callPOSTMethod(token, payloads.getAllocateRequestBody(batchDate,clientId,loanNumber,allocationAmount) ,AutoAllocateURI);
System.out.println("autoAllocate"+autoAllocate.asString());
softassert.assertEquals(autoAllocate.statusCode(),Integer.valueOf(StatusCode).intValue(),"This is the status code to verfiy Term loan creation");
softassert.assertAll();
}}
	
	
	
	
	@Feature("AutoAllocation")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
   @Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke" })
	public void autoAllocationPeriod(String batchDate,String clientId,String loanNumber,String allocationAmount,String AutoAllocateURI,String StatusCode,String Period) throws FileNotFoundException, IOException, ParseException {

		SoftAssert softassert = new SoftAssert();
		{
			
Response autoAllocate=callPOSTMethod(token, payloads.getAllocateRequestBodyForPEriod( batchDate, clientId, loanNumber, allocationAmount,Period), AutoAllocateURI);
System.out.println("autoAllocate"+autoAllocate.asString());
softassert.assertEquals(autoAllocate.statusCode(), STATUS_CODE_200, "this is the status code for termloanResponse");
softassert.assertAll();
}}
	






	@Feature("AutoAllocation")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke" })
	public void autoAllocationForManualFee(String batchDate,String clientId,String loanNumber,String allocationAmount,String AutoAllocateURI,String StatusCode,String Period) throws FileNotFoundException, IOException, ParseException {

		SoftAssert softassert = new SoftAssert();
		{
			
Response autoAllocate=callPOSTMethod(token, payloads.getAllocateRequestBodyForPEriod( batchDate, clientId, loanNumber, allocationAmount,Period), AutoAllocateURI);
System.out.println("autoAllocate"+autoAllocate.asString());
softassert.assertEquals(autoAllocate.statusCode(), STATUS_CODE_404, "this is the status code for termloanResponse");
softassert.assertAll();
}}


/*
	@Feature("AutoAllocation")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke" })
	public void undoBatchAfterAutoAllocation(String batchDate,String clientId,String loanNumber,String allocationAmount,String AutoAllocateURI,String StatusCode,String Period,String TotalAmount) throws FileNotFoundException, IOException, ParseException {

		SoftAssert softassert = new SoftAssert();
		{
			

			//Step to create Batch
			Response createBatch=callPOSTMethod(token, "batch_data",Payloads.createBatch(batchDate, TotalAmount),  data.CreatebatchURI());
			System.out.println("createBatch"+createBatch.asString());
			softassert.assertEquals(createBatch.statusCode(), STATUS_CODE_201, "This is to verfiy status code of batch creation");
			
			String batchId=createBatch.jsonPath().getString("batch_id").toString();
			System.out.println("batchId"+batchId);

			
			//Create repayment detail
			Response getautolloction=callGETMethod(token, "https://staging.cyncsoftware.com/api/cash-application-v2/v1/term_loans/auto_allocation?borrower_id=11091&batch_id="+batchId+"&batch_date=04/08/2020&check_id=undefined&loan_number=11&allocation_amount=5000");
			System.out.println("getautolloction"+getautolloction.asString());
			softassert.assertEquals(getautolloction.statusCode(), STATUS_CODE_200, "this is the status code for termloanResponse");
	 }
softassert.assertAll();
}}*/




@Feature("Autoallocation")
@Stories(value = { @Story(value = "termaloan status code validation")})
@Description("Verify the functionality of auto allocation with valid period and valid loan")
@Step("verifies chargecode module")
@Severity(SeverityLevel.BLOCKER)
@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity", "smoke" })
public void auto(String batchDate,String TotalAmount,String borrower_id,String loan_number) throws FileNotFoundException, IOException, ParseException {

	SoftAssert softassert = new SoftAssert();
	{
		

		//Step to create Batch
		Response createBatch=callPOSTMethod(token, "batch_data",payloads.createBatch(batchDate, TotalAmount),  data.CreatebatchURI());
		System.out.println("createBatch"+createBatch.asString());
		softassert.assertEquals(createBatch.statusCode(), STATUS_CODE_201, "This is to verfiy status code of batch creation");
		
		String batchId=createBatch.jsonPath().getString("batch_id").toString();
		System.out.println("batchId"+batchId);

		
		//Create repayment detail
		//Response getautolloction=callGETMethod(token, url+"/api/cash-application-v2/v1/term_loans/auto_allocation?borrower_id=11622&batch_id="+batchId+"&batch_date=07/16/2020&check_id=undefined&loan_number=7hgbqaz&allocation_amount=4000");
		Response getautolloction=callGETMethodWithSixQuery(token,"borrower_id",borrower_id,"batch_id",batchId,"batch_date","batchDate","check_id","undefined","loan_number",loan_number,"allocation_amount",TotalAmount,url+"/api/cash-application-v2/v1/term_loans/auto_allocation");
		System.out.println("getautolloction"+getautolloction.asString());
		softassert.assertEquals(getautolloction.statusCode(), STATUS_CODE_200, "this is the status code for termloanResponse");
 }
softassert.assertAll();
}}





















